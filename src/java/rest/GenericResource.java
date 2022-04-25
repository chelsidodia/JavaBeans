/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import EJB.beanLocal;
import entity.Category;
import entity.Product;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Radhika Maniya
 */
@Path("generic")
public class GenericResource { 
    @EJB beanLocal pbl;
    @Context
    private UriInfo context;

    public GenericResource() {
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllproduct")
   public Collection<Product> getAllproduct() {
        return pbl.getAllproduct();
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllCategory")
    public Collection<Category> getAllCategory(){
        return pbl.getAllCategory();
    }
    
   @Path("addproduct/{cid}/{pname}/{brandname}")
    @POST
    public void addProduct(@PathParam("cid") Integer cid,@PathParam("pname") String pname,@PathParam("brandname") String brandname) {
       pbl.addProduct(cid, pname, brandname);
    }
    @Path("updateproduct/{pid}/{cid}/{pname}/{brandname}")
    @POST
    public void updateProduct(@PathParam("pid")Integer pid,@PathParam("cid") Integer cid,@PathParam("pname") String pname,@PathParam("brandname") String brandname) {
        pbl.updateProduct(pid, cid, pname, brandname);
    }

   @Path("removeproduct/{pid}/{cid}")
    @DELETE
    public void removeProduct(@PathParam("pid")Integer pid,@PathParam("cid") Integer cid) {
        pbl.removeProduct(pid, cid);
    }
   
//   @GET
//   @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Product> getAllproduct() {
//            return pbl.getAllproduct();
//    }
//    @Path("addproduct/{cid}/{pname}/{brandname}")
//    @POST
//    public void addProduct(@PathParam("cid") Integer cid,@PathParam("pname") String pname,@PathParam("brandname") String brandname) {
//       pbl.addProduct(cid, pname, brandname);
//    }
//    @Path("updateproduct/{pid}/{cid}/{pname}/{brandname}")
//    @POST
//    public void updateProduct(@PathParam("pid")Integer pid,@PathParam("cid") Integer cid,@PathParam("pname") String pname,@PathParam("brandname") String brandname) {
//        pbl.updateProduct(pid, cid, pname, brandname);
//    }
//
//   @Path("removeproduct/{pid}/{cid}")
//    @DELETE
//    public void removeProduct(@PathParam("pid")Integer pid,@PathParam("cid") Integer cid) {
//        pbl.removeProduct(pid, cid);
//    }
}
   

