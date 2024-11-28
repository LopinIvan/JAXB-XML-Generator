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

        City city = new City();
        city.setCountry("Russia");
        city.setName("Irkutsk");
        city.setPeople(700000);

        serializationAndDeserializationJavaXML.generateXML(person, "person");
        serializationAndDeserializationJavaXML.generateXML(person1, "person1");
        serializationAndDeserializationJavaXML.generateXML(city, "city");

        Person parcedPerson = new Person();
        Person parcedPerson1 = new Person();
        City parcedCity = new City();

        parcedPerson = serializationAndDeserializationJavaXML.parseXML("person", Person.class);
        parcedPerson1 = serializationAndDeserializationJavaXML.parseXML("person1", Person.class);
        parcedCity = serializationAndDeserializationJavaXML.parseXML("city", City.class);

        System.out.println(parcedPerson.getName() + " " + parcedPerson.getAge());
        System.out.println(parcedPerson1.getName() + " " + parcedPerson1.getAge());
        System.out.println(parcedCity.getName() + " " + parcedCity.getCountry());
    }

}
