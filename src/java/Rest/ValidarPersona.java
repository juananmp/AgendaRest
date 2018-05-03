/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("ValidarPersona")
public class ValidarPersona {

    @Context
    private UriInfo context;
  //   File file = new File("Agenda.xml");

    File xsdFile = new File("ValidarAgenda.xsd");

    /**
     * Creates a new instance of ValidarPersona
     */
    public ValidarPersona() {
    }

    /**
     * Retrieves representation of an instance of Rest.ValidarPersona
     * @return an instance of java.lang.String
     */
    
    /**
     * PUT method for updating or creating an instance of ValidarPersona
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String putXml(PersonaObj p) throws JAXBException {
        //Tambien si hago content-type application/xml y le paso una persona funciona
         String txt = "Juanan";
         AgendaObject ao = new AgendaObject();
         ao.getPersonaObj().add(p);
          File fi = new File("filen.xml");
          File schemaFile = new File("ValidarAgenda.xsd");
          JAXBContext jAXBcontext = JAXBContext.newInstance(AgendaObject.class);
            Marshaller marshaller = jAXBcontext.createMarshaller();
        if(!schemaFile.exists()){
            CrearXsd.crear();
        }
        try {

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
           
            marshaller.marshal(ao, fi);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(fi));
            txt = (fi + " is valid against the " + xsdFile + " Schema");
        } catch (SAXException ex) {
            txt = (fi + " is not valid against the " + xsdFile + " Schema");
            Logger.getLogger(ValidarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
       return txt;
    }
    }

