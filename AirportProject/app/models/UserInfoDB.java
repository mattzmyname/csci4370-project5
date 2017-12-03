package models;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import java.util.Map.Entry;
import java.util.List.*;
import models.UserInfo;


/**
 * Provides an in-memory repository for UserInfo.
 * Storing credentials in the clear is kind of bogus.
 * @author Philip Johnson
 */
public class UserInfoDB {
  
  private static Map<String, UserInfo> userinfos = new HashMap<String, UserInfo>();
  
  /**
   * Adds the specified user to the UserInfoDB.
   * @param name Their name.
   * @param email Their email.
   * @param password Their password. 
   */
  public static void addUserInfo(String email, String name, String password) {
    String hashedPassword = models.BCrypt.hashpw(password, models.BCrypt.gensalt(12));
    userinfos.put(email, new UserInfo(name, email, hashedPassword));
    runSQLUpdate("Insert into user_info(email, name,password) values ('"+email+"','"+name+"','"+ hashedPassword+"')");
     }
  
  /**
   * Returns true if the email represents a known user.
   * @param email The email.
   * @return True if known user.
   */
  public static boolean isUser(String email) {
    runSQLQuery("Select * from user_info");
    return userinfos.containsKey(email);
  }

  /**
   * Returns the UserInfo associated with the email, or null if not found.
   * @param email The email.
   * @return The UserInfo.
   */
  public static UserInfo getUser(String email) {
    runSQLQuery("Select * from user_info");
    return userinfos.get((email == null) ? "" : email);
  }

  /**
   * Returns true if email and password are valid credentials.
   * @param email The email. 
   * @param password The password. 
   * @return True if email is a valid user email and password is valid for that email.
   */
  public static boolean isValid(String email, String password) {
    return ((email != null) 
            &&
            (password != null) 
            &&
            isUser(email) 
            &&
            models.BCrypt.checkpw(password, getUser(email).getPassword()));
  }

  public static void runSQLQuery(String cmd )
    {
      try{
        userinfos.clear();
        Class.forName("com.mysql.jdbc.Driver");

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air","root","root");
        //here sonoo is the database name, root is the username and root is the password
        Statement stmt=con.createStatement();
        
        ResultSet rs=stmt.executeQuery(cmd);

        while(rs.next())
        userinfos.put(rs.getString(1),new UserInfo(rs.getString(1),rs.getString(2),rs.getString(3)));
        
        
        con.close();

        }catch(Exception e){ System.out.println(e);}

        }
    
    public static void runSQLUpdate(String cmd )
    {
      try{
        Class.forName("com.mysql.jdbc.Driver");

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air","root","root");
        //here sonoo is the database name, root is the username and root is the password
        Statement stmt=con.createStatement();
        
        int result=stmt.executeUpdate(cmd);  
        System.out.println(result+" records affected"); 
        con.close();

        }catch(Exception e){ System.out.println(e);}

        }
    }
  
