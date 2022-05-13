package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class xml {
    public static void XmlWrite(String filename)
    {
        try {
            File file = new File(filename);
            JAXBContext context = JAXBContext.newInstance(dog.class);
            Marshaller marshaller = context.createMarshaller();
            dog dog2 = new dog(7, "dog_name");
            marshaller.marshal(dog2, file);

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    public static void XmlRead(String filename)
    {   System.out.println("Информация из XML-файла:");
        try {
            File file = new File(filename);
            JAXBContext context = JAXBContext.newInstance(dog.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            dog dog3 = (dog) unmarshaller.unmarshal(file);
            System.out.println(dog3);

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }}
}
