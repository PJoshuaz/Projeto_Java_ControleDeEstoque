package controleDeEstoque.Controller;

import controldeDeEstoque.ModeloDAO.AutenticacaoDao;
import controleDeEstoque.View.Front.Login;
import controleDeEstoque.View.Imagens.modelo.LoginDto;
import controleDeEstoqueJava.Domonio.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author pj
 */
public class LoginController implements ActionListener{
    
    private final Login login;
    private final AutenticacaoDao autenticacaoDao;
    
    public LoginController(Login login){
        this.login = login;
        this.autenticacaoDao = new AutenticacaoDao();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao){
            case "login": login(); break;
            case "cancelar": cancelar();break;
        }
    }

    private void login() {
        String usuario = this.login.getTxtLoginUsuario().getText();
        String senha = this.login.getTxtLoginSenha().getText();
        
        if(usuario.equals("") || senha.equals("")){
            this.login.getLabelLoginMensagem().setText("Campos devem Ser Preenchidos");
            return;
        }
        LoginDto loginDto = new LoginDto(usuario,senha);
        
        Usuario usuarioTemp;
        usuarioTemp = this.autenticacaoDao.login(loginDto);
        
        if(usuarioTemp != null) {
            JOptionPane.showConfirmDialog(null,usuarioTemp.getNome());
            limparCampos();
            
        }else{
            this.login.getLabelLoginMensagem().setText("Usuario e Senha incorretos");        }
        
        
    }

    private void cancelar() {
        int confirmar = JOptionPane.showConfirmDialog(login,"Tem Certeza?","Sair Do Sistema",JOptionPane.YES_NO_OPTION);
        
        if(confirmar == JOptionPane.YES_NO_OPTION){
            
            System.exit(0);
        }
 }
    
    private void limparCampos(){
        this.login.getTxtLoginUsuario().setText("");
        this.login.getTxtLoginSenha().setText("");
        this.login.getLabelLoginMensagem().setText("");
    }
    
    
}
