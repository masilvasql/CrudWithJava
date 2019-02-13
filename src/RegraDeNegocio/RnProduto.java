/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Beans.ProdutoBeans;
import DAO.ProdutoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class RnProduto {
    
   
    
    public int incluirNome(ProdutoBeans pb) {
        int resultado = 0;
        
        try {
             ProdutoDao pd = new ProdutoDao();
             resultado = pd.insereProduto(pb);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em RN incluirNome");
        }
        
        return resultado;
                
    }
    
    public ArrayList listaProdutos(String descCurta){
        ArrayList arrayList = new ArrayList();
        try {
            ProdutoDao pd = new ProdutoDao();
            arrayList = pd.listaProdutos(descCurta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em RN listaProdutos");
        }
        return arrayList;
    }
    
    public int deletaProduto(int id){
        int resultado = 0;
        try {
            ProdutoDao pd = new ProdutoDao();
            resultado = pd.deletaProduto(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em RN listaProdutos");
        }
        return resultado;
    }
}
