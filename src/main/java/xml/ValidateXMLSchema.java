package xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidateXMLSchema {
    private static final Logger LOGGER = LogManager.getLogger(ValidateXMLSchema.class);

    public static void main(String[] args) {

        LOGGER.info("flight.xml validates against flight.xsd? " + XMLValidator("src\\main\\java\\xml\\flight.xsd", "src\\main\\java\\xml\\flight.xml"));
        LOGGER.info("airports.xml validates against airport.xsd? " + XMLValidator("src\\main\\java\\xml\\airport.xsd", "src\\main\\java\\xml\\airports.xml"));
        LOGGER.info("airport2.xml validates against airport.xsd? " + XMLValidator("src\\main\\java\\xml\\airport.xsd", "src\\main\\java\\xml\\airport2.xml"));
    }

    public static boolean XMLValidator(String xsdPath, String xmlPath) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            LOGGER.error("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
