import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Recapacitacion {

	public static void main(String[] args) {
		try {

			// FICHEROS DE TEXTO
			// escribir
			FileWriter fw = new FileWriter("pasanDeMi.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < 10; i++) {
				bw.write("Frase" + i);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			// leer
			FileReader fr = new FileReader("pasanDeMi.txt");
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String s = br.readLine();
				System.out.println(s);
			}
			br.close();

			// FICHEROS BINARIOS
			// escribir
			FileOutputStream fos = new FileOutputStream("pasanMucho.bin");
			DataOutputStream dos = new DataOutputStream(fos);

			for (int i = 0; i < 10; i++) {
				dos.writeInt(i);
			}
			dos.flush();// este es opcional
			dos.close();
			// leer
			FileInputStream fis = new FileInputStream("pasanMucho.bin");
			DataInputStream dis = new DataInputStream(fis);
			try {
				while (true) {
					int a = dis.readInt();
					System.out.println(a + 1);
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("Fin fichero");
				dis.close();
			}
			// FICHEROS BINARIOS
			// escribir
			FileOutputStream fos2 = new FileOutputStream("ahoraAlMenosNoHablan.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos2);

			for (int i = 0; i < 10; i++) {
				Marc m = new Marc("Marc"+i,i*2,true);
				oos.writeObject(m);
			}
			oos.flush();// este es opcional
			oos.close();
			// leer
			FileInputStream fis2 = new FileInputStream("ahoraAlMenosNoHablan.dat");
			ObjectInputStream ois = new ObjectInputStream(fis2);
			try {
				while (true) {
					Object o = ois.readObject();
					if (o instanceof Marc) {
						System.out.println(o);
					}
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("Fin fichero");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
