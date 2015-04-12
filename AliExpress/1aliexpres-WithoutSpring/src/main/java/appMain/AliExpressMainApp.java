package appMain;

import isklucok.NemaDovolnoKolicinaIsklucok;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import menu.Display;

@EnableAutoConfiguration
@ComponentScan
@Configuration
public class AliExpressMainApp {

	public static void main(String[] args) throws IOException,
			NemaDovolnoKolicinaIsklucok {
		SpringApplication.run(AliExpressMainApp.class);
		Display display = new Display();
		display.run();

	}

}
