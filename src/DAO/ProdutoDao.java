/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ProdutoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class ProdutoDao {
    
    Connection conn;
    
    private PreparedStatement incluirRegistro;
    private PreparedStatement listarRegistros;
    private PreparedStatement deletarRegistros;
    
    public ProdutoDao() throws SQLException{
        Conexao conexao = new Conexao();
        conn = conexao.getConexao();
        
       // incluirRegistro = conn.prepareCall("CALL insereProdutos(?, ? , ?)");
       incluirRegistro = conn.prepareStatement("INSERT INTO produtos (desccurta, desclonga, unidademedida)VALUES (?,?, ?)");
       listarRegistros = conn.prepareStatement("SELECT * FROM produtos WHERE desccurta LIKE ?");
       deletarRegistros = conn.prepareStatement("DELETE FROM produtos WHERE idproduto = ?");
    }
    
    public int insereProduto(ProdutoBeans pb ) throws SQLException{
        int resultado;
        
        incluirRegistro.setString(1, pb.getDescCurta());
        incluirRegistro.setString(2, pb.getDescLonga());
        incluirRegistro.setString(3, pb.getUnidadeMedida());
        
        resultado = incluirRegistro.executeUpdate();;
        
        return resultado;
    }
    
    public ArrayList listaProdutos(String descCurta ) throws SQLException{
        ArrayList lista = new ArrayList();
        listarRegistros.setString(1, "%"+ descCurta +"%");
        ResultSet resultado = listarRegistros.executeQuery();
        
        while(resultado.next()){
            ProdutoBeans pb = new ProdutoBeans();
            pb.setId(resultado.getInt(1));
            pb.setDescCurta(resultado.getString(2));
            pb.setDescLonga(resultado.getString(3));
            pb.setUnidadeMedida(resultado.getString(4));
            lista.add(pb);
        }
        
        return lista;
    }
    
    public int deletaProduto(int id) throws SQLException{
        int resultado;
        deletarRegistros.setInt(1, id);
        resultado = deletarRegistros.executeUpdate();
        return resultado;
    }
    
}
