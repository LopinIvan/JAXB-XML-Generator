package com.lopinivan.jaxb;

import jakarta.xml.bind.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Класс для сериализации (Java -> XML) и десериализации (XML -> Java)
public class SerializationAndDeserializationJavaXML {

    // Метод сериализации
    public <T> void generateXML(T object, String fileName) throws JAXBException, IOException {

        // Формирование пути к директории для сохранения XML-файлов
        Path outputDirectory = Paths.get("src", "main", "resources", "xml");
        if(!Files.exists(outputDirectory)) {
            Files.createDirectories(outputDirectory);
        }
        // Добавление .xml если не указано расширение в имени файла
        if (!fileName.endsWith(".xml")) {
            fileName += ".xml";
        }
        File xmlFile = outputDirectory.resolve(fileName).toFile();

        // Создаём JAXB-контекст для работы с классом объекта
        // Создаём Marshaller для преобразования объекта Java в XML
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        // Устанавливаем свойство форматирования для удобного отображения XML
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Преобразование объекта Java в XML и запись в файл
        marshaller.marshal(object, xmlFile);

        System.out.println("XML file generated: " + xmlFile.getAbsolutePath());
    }

    // Метод десериализации
    public <T> T parseXML(String fileName, Class<T> clazz) throws JAXBException {

        // Формирование пути к директории с XML файлами
        // Добавление .xml если не указано расширение в имени файла
        Path outputDirectory = Paths.get("src", "main", "resources", "xml");
        if (!fileName.endsWith(".xml")) {
            fileName += ".xml";
        }
        File xmlFile = outputDirectory.resolve(fileName).toFile();

        // Создаем JAXB-контекст для работы с указанным классом
        // Создаем Unmarshaller, который будет преобразовывать XML в объект Java
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Десериализация XML в объект Object
        // Безопасное приведение объекта к ожидаемому типу
        T object = clazz.cast(unmarshaller.unmarshal(xmlFile));

        System.out.println("XML file parsed: " + xmlFile.getAbsolutePath());

        return object;
    }

}
