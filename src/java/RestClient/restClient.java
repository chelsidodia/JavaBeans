/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        restClient client = new restClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Radhika Maniya
 */
public class restClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/JSF_JPA_REST_EJB/webresources";

    public restClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getAllproduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllproduct");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void removeProduct(String pid, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeproduct/{0}/{1}", new Object[]{pid, cid})).request().delete();
    }

    public void addProduct(String cid, String pname, String brandname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addproduct/{0}/{1}/{2}", new Object[]{cid, pname, brandname})).request().post(null);
    }

    public void updateProduct(String pid, String cid, String pname, String brandname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateproduct/{0}/{1}/{2}/{3}", new Object[]{pid, cid, pname, brandname})).request().post(null);
    }

    public <T> T getAllCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
