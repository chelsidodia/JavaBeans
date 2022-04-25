/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import RestClient.restClient;
import entity.Category;
import entity.Product;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Radhika Maniya
 */
@Named(value = "jSFManagedBean")
@ApplicationScoped
public class JSFManagedBean {

    restClient restc=new restClient();
    private Response res;
    private GenericType<Collection<Product>> productgeneric;
    private GenericType<Collection<Category>> categorygeneric;
       Product product = new Product();
   private String pid,name,cid,brandname;
    Collection<Category> categorylist;

    public restClient getRestc() {
        return restc;
    }

    public void setRestc(restClient restc) {
        this.restc = restc;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public GenericType<Collection<Product>> getProductgeneric() {
        return productgeneric;
    }

    public void setProductgeneric(GenericType<Collection<Product>> productgeneric) {
        this.productgeneric = productgeneric;
    }

    public GenericType<Collection<Category>> getCategorygeneric() {
        return categorygeneric;
    }

    public void setCategorygeneric(GenericType<Collection<Category>> categorygeneric) {
        this.categorygeneric = categorygeneric;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public Collection<Category> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(Collection<Category> categorylist) {
        this.categorylist = categorylist;
    }

    

    public JSFManagedBean() {
    }
    
    @PostConstruct
    public void init(){
       categorygeneric = new GenericType<Collection<Category>>(){};
       res = restc.getAllCategory(Response.class);
       this.categorylist = res.readEntity(categorygeneric);
       
//       brandgeneric = new GenericType<Collection<Brandtb>>(){};
//       res = productclient.getAllBrand(Response.class);
//       this.brandlist = res.readEntity(brandgeneric);
    }
    
    public Collection<Product> findAll(){
            productgeneric = new GenericType<Collection<Product>>(){};
            res = restc.getAllproduct(Response.class);
            Collection<Product> product = res.readEntity(productgeneric);
            return product;
    }
    
    public String add(){
        restc.addProduct(cid, name, brandname);
        this.product = new Product();
        return "display";
    }
    
    public void delete(Product p){
        this.pid = p.getPid().toString();
        Category c = p.getCid();
        this.cid = c.getCid().toString();
        restc.removeProduct(pid, cid);
        
    }
    
    public String edit(Product p){
        this.pid = p.getPid().toString();
        Category c = p.getCid();
        this.cid = c.getCid().toString();
       
        this.name = p.getPname();
        this.brandname = p.getBrandname();
        this.product=new Product();
        return "edit";
    }
    
    public String edit(){
        restc.updateProduct(pid, cid, name, brandname);
//        this.product = new Product();
        return "display";
    }

}
