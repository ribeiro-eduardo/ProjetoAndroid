/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import service.EntregaDAO;
import service.Entrega;

/**
 * REST Web Service
 *
 * @author acv28
 */
@Path("Entrega")
public class RestEntrega {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestEntrega
     */
    public RestEntrega() {
    }

   @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entrega> getEntrega(@PathParam("id") int id) {
        try{
            EntregaDAO tc = new EntregaDAO();
            
            List<Entrega> ltc = tc.getPorEntregador(id);
            
            //ltc = tc.getPorEntregador(id);
            System.out.println(id);
            System.out.println(ltc);
            return ltc;
            
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * PUT method for updating or creating an instance of RestEntrega
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
