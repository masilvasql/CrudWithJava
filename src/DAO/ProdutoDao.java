/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ProdutoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marce
 */
public class ProdutoDao {
    
    Connection conn;
    
    private PreparedStatement incluirRegistro;
    
    public ProdutoDao() throws SQLException{
        Conexao conexao = new Conexao();
        conn = conexao.getConexao();
        
       // incluirRegistro = conn.prepareCall("CALL insereProdutos(?, ? , ?)");
       incluirRegistro = conn.prepareStatement("INSERT INTO produtos (desccurta, desclonga, unidademedida)VALUES (?,?, ?)");
    }
    
    public int insereProduto(ProdutoBeans pb ) throws SQLException{
        int resultado;
        
        incluirRegistro.setString(1, pb.getDescCurta());
        incluirRegistro.setString(2, pb.getDescLonga());
        incluirRegistro.setString(3, pb.getUnidadeMedida());
        
        resultado = incluirRegistro.executeUpdate();;
        
        return resultado;
    }
    
}
