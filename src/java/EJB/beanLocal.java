/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Category;
import entity.Product;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Radhika Maniya
 */
@Local
public interface beanLocal {
    Collection<Category> getAllCategory();
    Collection<Product> getAllproduct();
     void addProduct(Integer cid,String pname,String brandname);
     void updateProduct(Integer pid,Integer cid,String pname,String brandname);
     void removeProduct(Integer pid,Integer cid);
}
