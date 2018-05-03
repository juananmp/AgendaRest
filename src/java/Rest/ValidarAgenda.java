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
@Path("ValidarAgenda")
public class ValidarAgenda {

    @Context
    private UriInfo context;
 File file = new File("Agenda.xml");

    File xsdFile = new File("ValidarAgenda.xsd");
    /**
     * Creates a new instance of ValidarAgenda
     */
    public ValidarAgenda() {
    }

    /**
     * Retrieves representation of an instance of Rest.ValidarAgenda
     * @return an instance of java.lang.String
     */
   
    @POST
   @Produces(MediaType.TEXT_PLAIN)
    //POST  http://localhost:8080/AgendaRest/webresources/ValidarAgenda
    //application-xml  application/xml
    
    //Ya no hace falta comentarios arriba, ahora content-type application/xml y le paso manualmente la agenda 
        public String putXml() throws JAXBException {
          String txt = "Juanan";
          File schemaFile = new File("ValidarAgenda.xsd");
         
        if(!schemaFile.exists()){
            CrearXsd.crear();
        }
        try {

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(file));
            txt = (file + " is valid against the " + xsdFile + " Schema");
        } catch (SAXException ex) {
            txt = (file + " is not valid against the " + xsdFile + " Schema");
            Logger.getLogger(ValidarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
       return txt;
    }
    }
    
    

