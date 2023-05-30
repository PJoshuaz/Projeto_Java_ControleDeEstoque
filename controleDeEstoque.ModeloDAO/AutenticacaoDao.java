package controleDeEstoque.ModeloDAO;

import controleDeEstoque.ModeloDAO.exception.NegocioException;
import controleDeEstoque.View.Imagens.modelo.LoginDto;
import controleDeEstoqueJava.Domonio.Perfil;
import controleDeEstoqueJava.Domonio.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author pj
 */
public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;
        
        public AutenticacaoDao(){
            this.usuarioDao = new UsuarioDao();
        }
        
        public boolean temPermissao(Usuario usuario) {
            try{
                permissao(usuario);
                return true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage(), "Usuario sem Permissao", 0);
                return false;
            }
        }
        
        private void permissao(Usuario usuario){
            if(!Perfil.ADMIN.equals(usuario.getPerfil())){
                throw new NegocioException(" Sem Permissao para realizar essa acao");
            }
        }
        
        
        
        
        public Usuario login(LoginDto login) {
         Usuario usuario;
        usuario = usuarioDao.buscarUsuarioPeloUsuario(login.getUsuario());
        
        if(usuario == null || !usuario.isEstado())
        return null;
        
        if(usuario.isEstado() && validaSenha(usuario.getSenha(), login.getSenha())){
            return usuario;
        }
        
        return null;
     }
        // validação de senha 
    private boolean validaSenha(String senhaUsuario, String senhaLogin) {
        return senhaUsuario.equals(senhaLogin);
    }
    
   
    }
