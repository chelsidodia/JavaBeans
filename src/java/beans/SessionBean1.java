/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class SessionBean1 implements SessionBean1Local {

    @PersistenceContext(unitName = "JsfTryCrud2PU")
    EntityManager em;

    @Override
    public Collection<Product> displayProducts() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public void addProduct(String name, Integer price, Integer quantity, String description) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Product p = new Product(name,price,quantity,description);
        em.persist(p);
    }

    @Override
    public void updateProduct(Integer pID, String name, Integer price, Integer quantity, String description) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Product p = em.find(Product.class, pID);
        System.out.println(pID);
        System.out.println(p);
        if (p!= null)
        {
            p.setDescription(description);
            p.setPrice(price);
            p.setQuantity(quantity);
            p.setName(name);
            em.merge(p);
        }
    }

    @Override
    public void removeProduct(Product p1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Product p = em.find(Product.class, p1.getId());
        if (p!= null)
        {
            em.remove(p);
        }
    }
    
    
    
}
