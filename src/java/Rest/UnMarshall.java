/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author janto
 */
public class UnMarshall {
     File XMLfile;
    //¿file agenda?
    public AgendaObject UnMarshallAgenda(){
     try {
        System.out.println("Cargando persona ...");
        JAXBContext jaxbC = JAXBContext.newInstance(AgendaObject.class);
        Unmarshaller jaxbU = jaxbC.createUnmarshaller();
        File f = new File("Agenda.xml");
         System.out.println(f.exists());
        AgendaObject ao = (AgendaObject)jaxbU.unmarshal(f);
        return ao;
        
          } catch (JAXBException ex) {
            Logger.getLogger(UnMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
    public PersonaObj UnMarshallPersona(File persona){
        try {
            System.out.println("Cargando persona ...");
            JAXBContext jaxbC = JAXBContext.newInstance(PersonaObj.class);
            Unmarshaller jaxbU = jaxbC.createUnmarshaller();
            PersonaObj p = (PersonaObj) jaxbU.unmarshal(persona);
            return p;
        } catch (JAXBException ex) {
            Logger.getLogger(UnMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

     