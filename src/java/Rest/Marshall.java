/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

/**
 *
 * @author janto
 */
public class Marshall {
       
        
       
        public void Marshall(AgendaObject agenda){
          try {
            JAXBContext context = JAXBContext.newInstance(AgendaObject.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File XMLfile = new File("Agenda.xml");
            marshaller.marshal(agenda, XMLfile);

        } catch (JAXBException ex) {
            Logger.getLogger(Marshall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
