package com.chatovich.xml.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class ValidationXSD {

    final static String FILE_NAME = "file/candies.xml";
    final static String SCHEMA_NAME = "file/candies_xsd.xsd";
    final static Logger LOGGER = LogManager.getLogger(ValidationXSD.class);

    public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(SCHEMA_NAME);
        try {
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
            // проверка документа
            Source source = new StreamSource(FILE_NAME);
            validator.validate(source);
            LOGGER.log(Level.INFO, FILE_NAME + " is valid.");
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Validation "+ FILE_NAME + " failed "
                    + e.getMessage() );
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, FILE_NAME + " is not valid:"
                    + e.getMessage());
        }
    }
}
