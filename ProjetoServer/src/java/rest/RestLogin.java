/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;


import service.Entregador;
import service.EntregadorDAO;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author acv28
 */
@Path("Login")
public class RestLogin {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestLogin
     */
    public RestLogin() {
    }

    
    @GET
    @Path("{login}/{senha}")
    @Produces("text/plain")
    public int getID(@PathParam("login") String login, @PathParam("senha") String senha) {
        try{
            EntregadorDAO dc = new EntregadorDAO();   
            int c=dc.login(login,senha);
            return c;
            
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves representation of an instance of rest.RestLogin
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RestLogin
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
