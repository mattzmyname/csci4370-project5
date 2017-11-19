import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.sql.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//ADD LOGGING AND SQL CONNECTION
public class BcryptHashing
{
	private static HashMap<String,String> listUsers = new HashMap<String,String>();
	
    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, IOException
    {
    	pullUserDB();
    	//sample
    	/*
    	String username = "richard";
        String  originalPassword = "password";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        addUser(username, generatedSecuredPasswordHash);
        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        System.out.println(matched);
        */
    	//scanner ver
    	Scanner sc = new Scanner(System.in);
    	int exitcode = 0;
    	do{
    	try{
        	System.out.println("Press 1 to authenticate user. Press 2 to add user. Press 3 to exit.");
        	exitcode = sc.nextInt();
        	switch(exitcode){
    		case 1:
    			System.out.println("Enter Username: ");
    			String username = "";
    			String attemptPassword;
    			username = sc.next();
    			System.out.println("Enter Password: ");
    			attemptPassword = sc.next();
    			authenticateUser(username,attemptPassword);
				
    			break;
    		case 2:
    			String user = "";
    			String origPassword;
    			while(user.length() < 1){
    				System.out.println("Create Username: ");
    				user = sc.next();
    				if(listUsers.containsKey(user) == true){
    					System.out.println("User already exists.");
    					user= "";
    				}
    				else
    				{
    					System.out.println("Create password: ");
    					origPassword = sc.next();
    					addUser(user,BCrypt.hashpw(origPassword, BCrypt.gensalt(12)));
    				}
    			}
    			break;
    		case 3:
    			System.out.println("Exiting.");
    			break;
    		default:
    			System.out.println("Invalid Command");
    			break;
    		}
    	}	catch(NumberFormatException e){
    		System.out.println("Invalid command");
    	}
    	}    	while(exitcode != 3);

    	sc.close();
    	//scanner ver
    	
    	
        pushUserDB();
        
    }
    private static void pullUserDB() throws FileNotFoundException, IOException{
    	try{
    	FileInputStream fstream = new FileInputStream("passwddb.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine, tempUser, tempHash;
        while ((strLine = br.readLine()) != null) {
        	String[] tokens =strLine.split(" ");
        	tempUser = tokens[0];
        	tempHash = tokens[1];
        	listUsers.put(tempUser, tempHash);
        }
        
        in.close();
    	}catch (Exception e){
      System.err.println("Error: " + e.getMessage());
    }
        
   }
    
    private static void pushUserDB() throws FileNotFoundException, IOException{
    	try{
    		PrintStream writePass = new PrintStream(new File("passwddb.txt"));
    		for (Entry<String,String> pair : listUsers.entrySet()){
                //iterate over the pairs
                writePass.println(pair.getKey()+" "+pair.getValue());
            }
    		writePass.close();
    	}catch (Exception e){
      System.err.println("Error: " + e.getMessage());
    }
        
   }
    
    public static boolean addUser(String user, String generatedSecurePasswordHash){
    	
    	if(listUsers.containsKey(user) == true){
    		System.out.println("User already exists.");
			return false;
    	}
    	else {
    		listUsers.put(user, generatedSecurePasswordHash);
    		System.out.println("Success");
    	}
    	return true;
    }
    public static boolean authenticateUser (String user, String passAttempt){
    	if(!listUsers.containsKey(user)){
    		System.out.println("User or password is incorrect.");
			return false;
    	}
    	String generatedSecuredPasswordHash = listUsers.get(user);
        boolean matched = BCrypt.checkpw(passAttempt, generatedSecuredPasswordHash);
        if(matched){
        	System.out.println("Success");
        	return true;
        }
        else
        {
        	System.out.println("User or password is incorrect1.");
        	return false;
        }
        
    }
}