/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Beans.ProdutoBeans;
import DAO.ProdutoDao;
import java.sql.SQLException;
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
}
