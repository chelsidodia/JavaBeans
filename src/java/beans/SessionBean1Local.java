/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Product;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface SessionBean1Local {
    
    Collection<Product> displayProducts();
    void addProduct(String name, Integer price, Integer quantity, String description);
    void updateProduct(Integer pID, String name, Integer price, Integer quantity, String description);
    void removeProduct(Product p);
   
}
