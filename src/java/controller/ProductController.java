/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.SessionBean1Local;
import entities.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author HP
 */
@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    @EJB SessionBean1Local pbl;
    
    private Product p = new Product();

    private String name,description;
    private Integer ID,price, quantity;
    
    public Product getP() {
        return p;
    }
    
    //13 next month     

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    
    
    public void setP(Product p) {
        this.p = p;
    }

    public SessionBean1Local getPbl() {
        return pbl;
    }

    public void setPbl(SessionBean1Local pbl) {
        this.pbl = pbl;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    @PostConstruct
    public void init(){
        price = 0;
        quantity = 0;
        ID =0;
    }
    
    public ProductController() {
    }
 
    public Collection<Product> findAll() {
        return this.pbl.displayProducts();
    }
    
    public String add() {
        
        System.out.print(name);
        System.out.print(price);
        System.out.print(quantity);
        System.out.print(description);
        this.pbl.addProduct(name, price,quantity, description);
        return "index";
    }
    
    public void delete(Product p)
    {
        
        this.pbl.removeProduct(p);
    }
    
    public String edit(Product p)
    {
        this.ID = p.getId();
        this.description = p.getDescription();
        this.name = p.getName();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
        return "edit";
    }
    
    public String update()
    {
        System.out.println(ID);
        System.out.println(name);
        this.pbl.updateProduct(ID, name, price, quantity, description);
        return "index";
    }
    
}
