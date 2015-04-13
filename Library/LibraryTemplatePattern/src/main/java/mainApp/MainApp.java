package mainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import menu.Display;

@EnableAutoConfiguration
@ComponentScan
@Configuration
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class);
		Display display = new Display();
		display.run();

	}

}
