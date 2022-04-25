/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Category;
import entity.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Radhika Maniya
 */
@Stateless
public class bean implements beanLocal {
@PersistenceContext(unitName = "JSF_JPA_REST_EJBPU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Product> getAllproduct() {
                  return em.createNamedQuery("Product.findAll").getResultList();

    }

    @Override
    public void addProduct(Integer cid, String pname, String brandname) {
    Category c = em.find(Category.class, cid);
    Collection<Product> products = c.getProductCollection();
    Product product = new Product();
    product.setPname(pname);
    product.setCid(c);
    product.setBrandname(brandname);
    products.add(product);
    c.setProductCollection(products);
    em.persist(product);
    em.merge(c);   
    }

    @Override
    public void updateProduct(Integer pid, Integer cid, String pname, String brandname) {
 Product p=em.find(Product.class,pid);
         Category c = em.find(Category.class,cid);
    
//         a.setAddressId(addressId);
       p.setCid(c);
       p.setPname(pname);
        p.setBrandname(brandname);
         
       em.merge(p);
    }

    @Override
    public void removeProduct(Integer pid, Integer cid) {
  Category c = em.find(Category.class, cid);
    
     Product product = em.find(Product.class,pid);
    Collection<Product> products = c.getProductCollection();
    if(products.contains(product))
    {
        products.remove(product);
        c.setProductCollection(products);
        em.remove(product);
        em.merge(c);
    }
    }

    @Override
    public Collection<Category> getAllCategory() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

  
}
