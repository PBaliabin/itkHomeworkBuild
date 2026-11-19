import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppTest {

    @Test
    public void propertyNameTest() {
    	String expected = "Привет, Pavel!";
    	String actual = "";

        Properties properties = new Properties();
        try (InputStream is = AppTest.class.getResourceAsStream("app.properties")) {
            if (is == null) {
                throw new FileNotFoundException("Property file not found");
            }
            properties.load(is);
            actual = App.greet(properties.getProperty("student.name"));
        } catch (IOException exception) {
            System.out.println("Error while reading properties");
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void emptyStringNameTest() {
    	String expected = "Привет, !";
    	String actual = App.greet("");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nullStringNameTest() {
    	String expected = "Назовите себя, пожалуйста";
    	String actual = App.greet(null);

        Assertions.assertEquals(expected, actual);
    }
}