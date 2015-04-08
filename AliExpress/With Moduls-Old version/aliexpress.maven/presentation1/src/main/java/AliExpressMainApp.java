
import java.io.IOException;

public class AliExpressMainApp {

	public static void main(String[] args) throws IOException,
			NemaDovolnoKolicinaIsklucok {
		ParserAndUI parser = new ParserAndUI();
		parser.readAndParse("produkti.txt");

	}

}
