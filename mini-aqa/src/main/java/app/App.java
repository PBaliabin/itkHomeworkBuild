import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
	public static void main(String[] args) {
		Properties properties = new Properties();
        try (InputStream is = App.class.getResourceAsStream("app.properties")) {
            if (is == null) {
                throw new FileNotFoundException("Property file not found");
            }
            properties.load(is);
            System.out.println(greet(properties.getProperty("student.name")));
        } catch (IOException exception) {
            System.out.println("Error while reading properties");
        }
	}

	public static String greet(String name) {
		if (name == null) return "Назовите себя, пожалуйста";
		return "Привет, " + name + "!";
	}
}