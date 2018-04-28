/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("agenda")
public class Agenda {
        
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Agenda
     */
    File agenda;
    public Agenda() {
    }

    /**
     * Retrieves representation of an instance of Rest.Agenda
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public AgendaObject getXml() {
        //http://localhost:8080/AgendaRest/webresources/agenda
       UnMarshall u = new UnMarshall();
       return u.UnMarshallAgenda();
    }

   }
