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
        String fileName = FILE_NAME;
        String schemaName = SCHEMA_NAME;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
            // проверка документа
            Source source = new StreamSource(fileName);
            validator.validate(source);
            LOGGER.log(Level.INFO, fileName + " is valid.");
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Validation "+ fileName + " failed "
                    + e.getMessage() );
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, fileName + " is not valid:"
                    + e.getMessage());
        }
    }
}
