
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
	public static void main(String[] args) {

		
		BufferedReader reader = null;

		try {
			File file = new File("test.txt");
			reader = new BufferedReader(new FileReader(file));
			HashMap<String, Integer> mapa = new HashMap<String, Integer>();
			String line;

			while ((line = reader.readLine()) != null) {
				String[] niza = line.split(" ");

				for (int i = 0; i < niza.length; i++) {

					niza[i].toLowerCase();
					Integer count = mapa.get(niza[i]);
					mapa.put(niza[i], count == null ? 1 : count + 1);

				}

			}

			System.out.println(mapa);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
