/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("persona")
public class Persona {

    public Persona() {
    }

    /**
     * Retrieves representation of an instance of Rest.Persona
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{nombre}")
    @Produces(MediaType.APPLICATION_XML)
    public PersonaObj getXml(@PathParam("nombre") String nombre) {
      //http://localhost:8080/AgendaRest/webresources/persona/juanan el juanan es el parametro que le paso a la url para que busque 
       UnMarshall u = new UnMarshall();
       AgendaObject ao = u.UnMarshallAgenda();
       for (PersonaObj p : ao.getPersonaObj()){
           if (p.getName().equals(nombre)){
               return p;
           }
       }
        return null;
    }

    /**
     * PUT method for updating or creating an instance of Persona
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public PersonaObj postXml(@FormParam("nombre") String name,@FormParam("email") String email, @FormParam("telefono") String telefono){
      //Content-Type: application/x-www-form-urlencoded 
      //Body. nombre=juanan&email=juanan@gmailcom&telefono=62878855
      PersonaObj p = new PersonaObj();
      p.setName(name);
      p.setEmail(email);
      p.setTelephone(Integer.parseInt(telefono));
      return p;
    }
}
