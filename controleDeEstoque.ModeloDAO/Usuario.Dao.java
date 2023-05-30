package controleDeEstoque.ModeloDAO;

import controleDeEstoque.DAO.conexao.Conexao;
import controleDeEstoque.DAO.conexao.conexaoClasse;
import controleDeEstoqueJava.Domonio.Perfil;
import controleDeEstoqueJava.Domonio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pj
 */
public class UsuarioDao {
    
    private final Conexao conexao;

    public UsuarioDao() {
        this.conexao = new conexaoClasse();
    }
    
    
    public String salvar(Usuario usuario){
        return usuario.getId() == 0 ? adicionar(usuario) : editar(usuario);
    }

    private String adicionar(Usuario usuario) {
      String sql = "INSERT INTO usuario(nome, usuario, senha, perfil, estado) VALUES(?, ?, ?, ?, ?)";
      
      Usuario usuarioTemp = buscarUsuarioPeloUsuario(usuario.getUsuario());
      
      if(usuarioTemp != null){
          return String.format("Error: username %s ja existe no banco de dados", usuario.getUsuario());
      }
      try {
          PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
          
          preencherValoresPreparedStatement(preparedStatement, usuario);
          
          int resultado = preparedStatement.executeUpdate();
          
          return resultado == 1 ? "Usuario adicionado com sucesso" : "Nao foi possivel adicionar";
      }catch(SQLException e){
          return String.format("Error: %5", e.getMessage());
          
      }
    }
    

    private String editar(Usuario usuario) {
        String sql = "UPDATE usuario nome = ?, usuario = ?, senha = ?, perfil = ?, estado = ? WHERE id = ?";
        try {
          PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
          
          preencherValoresPreparedStatement(preparedStatement, usuario);
          
          int resultado = preparedStatement.executeUpdate();
          
          return resultado == 1 ? "Usuario editado com sucesso" : "Nao foi possivel editar";
      }catch(SQLException e){
          return String.format("Error: %5", e.getMessage());
          
      }}

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        
                
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsuario());
        preparedStatement.setString(3, usuario.getSenha());
        preparedStatement.setString(4, usuario.getPerfil().name());
        preparedStatement.setBoolean(5, usuario.isEstado());
        
        if (usuario.getId() != 0 ){
            preparedStatement.setLong(6,usuario.getId());
        }
    }
    
    
    public List <Usuario> buscarTodosUsuarios(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while(result.next()) {    
                usuarios.add(getUsuario(result)); 
            }
        } catch(SQLException e){ 
            System.out.println(String.format("Error:", e.getMessage()));
        }
        return usuarios;
    }
    
    
    private Usuario getUsuario(ResultSet result) throws SQLException{
        Usuario usuario = new Usuario();
        
        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        usuario.setPerfil(Perfil.valueOf(result.getString("perfil")));
        usuario.setEstado(result.getBoolean("estado"));
        usuario.setDataHoraCriacao(result.getObject("data_de_criacao",LocalDateTime.class));
        usuario.setUltimologin(result.getObject("ultimo_login", LocalDateTime.class));
    
        return usuario;
    }
    
    
        public Usuario buscarUsuarioPeloId(Long id){
        String sql = String.format("SELECT * FROM usuario WHERE id = %d",id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            if(result.next()) {    
                return getUsuario(result); 
            }
        } catch(SQLException e){ 
            System.out.println(String.format("Error:", e.getMessage()));
        }
        return null;
    }
        
      public Usuario buscarUsuarioPeloUsuario(String usuario){
        String sql = String.format("SELECT * FROM usuario WHERE usuario = '%s'",usuario);
        System.out.println(sql);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            if(result.next()) {    
                return getUsuario(result); 
            }
        } catch(SQLException e){ 
            e.printStackTrace();
            System.out.println(String.format("Error:", e.getMessage()));
        }
        return null;
    }
    
    
    
}
