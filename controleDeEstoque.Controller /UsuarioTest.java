package controleDeEstoque.Controller;

import controleDeEstoque.ModeloDAO.UsuarioDao;
import controleDeEstoqueJava.Domonio.Perfil;
import controleDeEstoqueJava.Domonio.Usuario;

/**
 *
 * @author pj
 */
public class UsuarioTest {
    
    public static void main(String[] args){
        Usuario usuario = new Usuario(0l, "Paulo", "12345", "pjoshua", Perfil.ADMIN, null, null);
        
        UsuarioDao usuarioDao = new UsuarioDao();
        String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);
    }
    
    
}
 
