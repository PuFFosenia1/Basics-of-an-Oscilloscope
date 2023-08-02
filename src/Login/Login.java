package Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Main.Oscilloscope;
import Login.Log;

public class Login {
	File f = new File("note.txt");
	
	//File m = new File("C:\\Users\\levan\\OneDrive\\Desktop\\mark.txt");
	  int ln;
	  String Username,Password,Email;
	  int update;
	  int Mark;
	  StringBuffer sb = new StringBuffer();
	    String line;
	    String everything;
	    /**
	     * Creates new form notepad
	     */

	  public Login() {
		  createFolder(); 
		  readFile();
		  countLines();
		  
	  }
	  
	    void createFolder(){
	        if(!f.exists()){
	            f.mkdirs();
	        }
	    }
	    
	   public void readFile(){
	        try {
	            FileReader fr = new FileReader(f+"\\logins.txt");
	            System.out.println("file exists!");
	        } catch (FileNotFoundException ex) {
	            try {
	                FileWriter fw = new FileWriter(f+"\\logins.txt");
	                System.out.println("File created");
	            } catch (IOException ex1) {
	                Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex1);
	            }
	        }
	        
	    }
	    
	    void addData(String usr,String pswd){
	        try {
	            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
	            for(int i=0;i<ln;i++){
	                raf.readLine();
	            }
	            //if condition added after video to have no lines on first entry
	            if(ln>0){
	            raf.writeBytes("\r\n");
	            raf.writeBytes("\r\n");
	            }
	            raf.writeBytes("Username:"+usr+ "\r\n");
	            raf.writeBytes("Password:"+pswd+ "\r\n");
	           // raf.writeBytes("Email:"+mail);
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
	   
	    int CheckData(){
	    	//BufferedReader br = new BufferedReader(new FileReader("update.txt"));
	        try {
	            RandomAccessFile raf = new RandomAccessFile(f+"\\update.txt", "rw");
	            if(update == 1){
	                System.out.println("New version");
	                return 1;
	            }else{
	            	System.out.println("Old version");
	            }
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return 0;
	            
	    }
	    
	    public void Update() throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader("update.txt"));
			try {
			    line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        //sb.append("\n");
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			   everything = sb.toString();
			   System.out.println(everything);
			} finally {
			    br.close();
			}	
	    }
	    
	    boolean logic(String usr,String pswd){
	        try {
	            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
	            for(int i=0;i<ln;i+=4){
	            //	System.out.println("count "+i);
	            
	                String forUser = raf.readLine().substring(9);
	                String forPswd = raf.readLine().substring(9);
	                if(usr.equals(forUser) && pswd.equals(forPswd)){
	                    JOptionPane.showMessageDialog(null, "password matched");
	                   
					//	dispose();
	                   // break;
	                    //i==(ln-3)
						return true;
	                }else if(i==(ln-2)){
	                	System.out.println("abracadabra");
	                	 JOptionPane.showMessageDialog(null, "incorrect username/password");
	                	 //return false;
	                }
	                // if you are using user & passwword without email
	                // then dont forget to replace  k<=2 with k=2 below
	                for(int k=1;k<=2;k++){
	                   raf.readLine();
	                }
	            }
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return false;
	        
	    }
	    void update(int m) throws FileNotFoundException {
	    	 PrintWriter out = new PrintWriter("update.txt");
	         out.println(m);
                
                }
	    
	    
	    void countLines(){
	        try {
	            ln=0;
	            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
	            for(int i=0;raf.readLine()!=null;i++){
	                ln++;
	            }
	            System.out.println("number of lines:"+ln);
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
}
