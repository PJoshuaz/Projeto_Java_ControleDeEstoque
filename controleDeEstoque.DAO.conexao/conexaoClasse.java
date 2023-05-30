package controleDeEstoque.DAO.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pj
 */
public class conexaoClasse implements Conexao{
    
    private final String USUARIO = "root";
    private final String SENHA = "dgd32133";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/BancoDeDadosControleDeEstoque";
    private Connection conectar;

    @Override
    public Connection obterConexao() throws SQLException {
        
        if(conectar == null){
            conectar = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return conectar;
    }
}
