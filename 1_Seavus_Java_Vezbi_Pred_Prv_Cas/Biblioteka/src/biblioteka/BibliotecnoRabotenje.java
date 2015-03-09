package biblioteka;

import java.util.Date;

public class BibliotecnoRabotenje {
	public static void main(String args[]) {
		Biblioteka biblioteka = new Biblioteka("Brakja Miladinovci", "3228345", "Partizanski Odredi");
		biblioteka.pecatiInfo();
		biblioteka.dodadiKniga("Kasni Porasni", "UNKNOWN", new Date());
		biblioteka.pecatiInfoZaKniga("Kasni Porasni");
	}
}
