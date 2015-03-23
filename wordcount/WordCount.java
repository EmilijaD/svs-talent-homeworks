import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		File file = new File("test.txt");
		Scanner scanner = new Scanner(file);
		int br = 1;
		while (scanner.hasNextLine()) {

			String word = scanner.next();

			if (!map.containsKey(word)) {
				map.put(word, br);
			} else {
				map.put(word, br++);
			}

		}

		System.out.println(map);

		scanner.close();
	}

}
