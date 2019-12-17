package rr;

import java.io.*;


public class Rr implements Serializable {
	
	public static class SubRr extends Rr {
		public SubRr() {
		}

		private void writeObject(ObjectOutputStream out) throws IOException {
			throw new NotSerializableException("Not today");
		}

		private void readObject(ObjectInputStream in) throws IOException {
			throw new NotSerializableException("Not today");
		}

	}

	public static void main(String[] args) {
		SubRr sub = new SubRr();
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("a:\\1.txt"));
			o.writeObject(sub);
			o.close();

			ObjectInputStream oi = new ObjectInputStream(new FileInputStream("a:\\1.txt"));
			SubRr su = (SubRr) oi.readObject();
			oi.close();
		} catch (NotSerializableException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		} catch (IOException e) {

		}

	}
}
