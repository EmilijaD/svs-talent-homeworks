
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.GapContent;

public class BestStudent {

	public static void main(String[] args) throws IOException {

		try {

			DataOutputStream out2 = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(
							"bestStudent.out")));

			ArrayList<Double> grupa = new ArrayList<>(26);
			ArrayList<GraduateStudent> gr = new ArrayList<>(26);

			DataInputStream in5 = new DataInputStream(new BufferedInputStream(
					new FileInputStream("graduate.txt")));
			DataInputStream postGraduateStudent = new DataInputStream(
					new BufferedInputStream(new FileInputStream(
							"postgraduate.txt")));

			BufferedReader in5br = new BufferedReader(new InputStreamReader(
					in5, "UTF8"));
			BufferedReader postStudentUTF = new BufferedReader(
					new InputStreamReader(postGraduateStudent, "UTF8"));

			String str = in5br.readLine();
			for (int i = 0; i < 26; i++) {
				String f = in5br.readLine();
				String[] z = f.split("\\s");
				int[] kn = { Integer.parseInt(z[6]), Integer.parseInt(z[7]),
						Integer.parseInt(z[8]), Integer.parseInt(z[9]),
						Integer.parseInt(z[10]), Integer.parseInt(z[11]),
						Integer.parseInt(z[12]), Integer.parseInt(z[13]),
						Integer.parseInt(z[14]), Integer.parseInt(z[15]) };
				GraduateStudent gs = new GraduateStudent(z[1], z[2], z[3],
						z[4], z[0], z[5], 10, kn);
				gr.add(gs);
				double pr = gs.prosek();
				grupa.add(pr);
			}
			int index = 0;
			double max = grupa.get(0);
			for (int i = 0; i < grupa.size(); i++) {
				if (grupa.get(i) > max) {
					max = grupa.get(i);
					index = i;
				}
			}

			String string = "Najdobar pregraduate student: " + gr.get(index)
					+ "\n";

			out2.write(string.getBytes());
			out2.writeBytes("Prosek " + max+"\n");
			
			in5br.close();
			in5.close();

			ArrayList<Double> prosek = new ArrayList<>(26);
			ArrayList<PostgraduateStudent> student = new ArrayList<>(26);
			
			postStudentUTF.readLine();
			for (int i = 0; i < 21; i++)
			{
               String red= postStudentUTF.readLine();
               String [] zborovi=red.split("\\s");
               double pr=Double.parseDouble(zborovi[6]);
               PostgraduateStudent pgs = new PostgraduateStudent(zborovi[1], zborovi[2], zborovi[3], zborovi[4], zborovi[0], zborovi[5], pr);
               student.add(pgs);
               prosek.add(pr);
               
				
			}
			Double max1 = prosek.get(0);
			int indeks=0;
			for (int i=0; i<prosek.size(); i++)
			{
			  if (prosek.get(i)> max1)
			  {
				  max1=prosek.get(i);
				  indeks=i;
			  }
			}
			
			String postString="Najdobar postgraduate student: "+student.get(indeks)
					+"\n"+"Prosek: "+ max1+"\n";
			out2.write(postString.getBytes());
			String kraj ="Dodeluvanjeto na nagradite e na 17 Dekemvri";
			out2.write(kraj.getBytes());
//			System.out.println("Najdobar postgraduate student: "+student.get(indeks));
//			System.out.println("Prosek: "+max1);
//			
//			System.out
//					.println("Najdobar pregraduate student: " + gr.get(index));
//			System.out.println("Просек " + max);
            out2.close();
		} catch (EOFException e) {
			System.err.println("End of stream");
		} finally {

		}
	}
}
