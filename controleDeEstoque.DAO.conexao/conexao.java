package controleDeEstoque.DAO.conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author pj
 */
public interface Conexao {
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection obterConexao() throws SQLException;
        
    
}
