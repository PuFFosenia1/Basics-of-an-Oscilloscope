package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ja frame = new ja();
		frame.setVisible(true);
		String u;
		u = Read();
		try {
		if(u.equals("1")) {
			System.out.println("Up to date");
		}
		else {
			Update frame1 = new Update();
			frame1.setVisible(true);
		}}
		finally {
			System.out.println("Ignora");
		}
	}

	static String Read() {
		try {
		      File myObj = new File("update.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        return data;
		      }
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return "0";
	}
}
