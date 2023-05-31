/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleDeEstoque.Controller;

import controleDeEstoque.DAO.conexao.Conexao;
import controleDeEstoque.DAO.conexao.conexaoClasse;
import controleDeEstoqueJava.Domonio.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pj
 */
public class ProdutoTest {
    
    public static void main(String[] args) throws SQLException{
        
        String sql = "Select * from produto";
        
        Conexao conexao = new conexaoClasse();
        
        Produto produto = new Produto(null,null,null,null,null,null,null,null);
        
        String inserirSQL = "INSERT INTO produto(id, nome, descricao, preco, quantidade, categoria, usuario, datHoaCriacao) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setString(2,produto.getDescricao());
        
        
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        System.out.println(resultadoDoCadastro);
         
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()){
            System.out.println(result.getString("nome"));
            
        }
    }
    
}
    
