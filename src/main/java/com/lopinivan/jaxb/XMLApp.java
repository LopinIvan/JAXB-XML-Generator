package com.lopinivan.jaxb;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class XMLApp
{
    public static void main( String[] args ) throws JAXBException, IOException {

        SerializationAndDeserializationJavaXML serializationAndDeserializationJavaXML
                = new SerializationAndDeserializationJavaXML();

        Person person = new Person();
        person.setName("Ivan");
        person.setAge(29);

        Person person1 = new Person();
        person1.setName("Sergey");
        person1.setAge(33);

        serializationAndDeserializationJavaXML.generateXML(person, "person");
        serializationAndDeserializationJavaXML.generateXML(person1, "person1");

        Person parcedPerson = new Person();
        Person parcedPerson1 = new Person();

        parcedPerson = serializationAndDeserializationJavaXML.parseXML("person", Person.class);
        parcedPerson1 = serializationAndDeserializationJavaXML.parseXML("person1", Person.class);

        System.out.println(parcedPerson.getName() + " " + parcedPerson.getAge());
        System.out.println(parcedPerson1.getName() + " " + parcedPerson1.getAge());
    }

}
