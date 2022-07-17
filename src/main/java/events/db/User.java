package events.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import events.EvProperties;
import events.MD5Digest;

public class User {
	public void setUserId(String user_id) { this.user_id = user_id; }
	public void setFirstname(String name) { this.firstname = name; }
	public void setLastname(String name) { this.lastname = name; }
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setEmail(String email) { this.email = email; }
	public void setBounced(Boolean bounced) { this.bounced = bounced; }
	public void setCreated(String created) { this.created = created; }
	public void setLastlogin(String lastlogin) { this.lastlogin = lastlogin; }
	
	public String getUserId() { return user_id; }
	public String getFirstname() { return firstname; }
	public String getLastname() { return lastname; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getEmail() { return email; }
	public Boolean getBounced() { return bounced; }
	public String getCreated() { return created; }
	public String getLastlogin() { return lastlogin; }
	
	String user_id;
	String firstname;
	String lastname;
	String username;
	String password;
	String email;
	Boolean bounced;
	String created;
	String lastlogin;
	
	public static int getCount() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        int count=0;
        
        String q="SELECT count(*) FROM user ;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	count = rs.getInt("count(*)");
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("StUser.getCount SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("StUser.getCount Close Exp:"+e);
        	}
        }
        return (count);
	}
	
	public static int getNewUsersToday() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        int count=0;
        
        
        String q="SELECT count(*) FROM user WHERE created=curdate();";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	count = rs.getInt("count(*)");
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("StUser.getCount SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("StUser.getCount Close Exp:"+e);
        	}
        }
        return (count);
	}
	
	public static int getNewUsersThisWeek() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        int count=0;
        
        
        String q="SELECT count(*) FROM user WHERE DATE_ADD(created, INTERVAL 7 DAY) > curdate();";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	count = rs.getInt("count(*)");
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("StUser.getCount SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("StUser.getCount Close Exp:"+e);
        	}
        }
        return (count);
	}
	
	public static ArrayList<User> getAllStUser() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> ul = new ArrayList<User>();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, created, lastlogin FROM user ORDER BY user_id ;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	User u = new User();
            	String user_id = rs.getString("user_id");
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	String username = rs.getString("username");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	Boolean bounced = rs.getBoolean("bounced");
            	String created = rs.getString("created");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	u.setCreated(created);
            	u.setLastlogin(lastlogin);
            	ul.add(u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAllStUser SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAllStUser Close Exp:"+e);
        	}
        }
        return (ul);
	}
	
	public static ArrayList<User> getBouncingStUser() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> ul = new ArrayList<User>();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, created, lastlogin FROM user WHERE bounced=true ORDER BY user_id ;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	User u = new User();
            	String user_id = rs.getString("user_id");
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	String username = rs.getString("username");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	Boolean bounced = rs.getBoolean("bounced");
            	String created = rs.getString("created");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	u.setCreated(created);
            	u.setLastlogin(lastlogin);
            	ul.add(u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getBouncingStUser SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getBouncingStUser Close Exp:"+e);
        	}
        }
        return (ul);
	}
	
	public static HashMap<String,User> getStUserHM() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        HashMap<String, User> uhm = new HashMap<String, User>();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced FROM user ;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	User u = new User();
            	String user_id = rs.getString("user_id");
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	String username = rs.getString("username");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	Boolean bounced = rs.getBoolean("bounced");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	uhm.put(user_id,u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getStUserHM SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getStUserHM Close Exp:"+e);
        	}
        }
        return (uhm);
	}
	
	public static User getStUserByEmail(String email) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        User u = new User();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, lastlogin FROM user ";
        q+="  WHERE email ='"+email+"' ;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            int i=0;
            while (rs.next()) {
            	String user_id = rs.getString("user_id");
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	String username = rs.getString("username");
            	String password = rs.getString("password");
            	email = rs.getString("email");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setLastlogin(lastlogin);
            	i++;
            }
            if (i==0) u=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getStUserByEmail SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getStUserByEmail Close Exp:"+e);
        	}
        }
        return (u);
	}
	
	public static User getStUserByUsername(String uname) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        User u = new User();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, created, lastlogin FROM user ";
        q+="  WHERE username=? ;";
        String q2="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, uname);
            
            ResultSet rs = pstmt.executeQuery();
            q2=pstmt.toString();
            // System.out.println("getStUserByUsername: q2: "+q2);
            
            int i=0;
            while (rs.next()) {
            	String user_id = rs.getString("user_id");
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	String username = rs.getString("username");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	String created = rs.getString("created");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setCreated(created);
            	u.setLastlogin(lastlogin);
            	i++;
            }
            if (i==0) u=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp: " + e);
            System.out.println("getStUserByUsername SQL:" + q2);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getStUserByUsername Close Exp:"+e);
        	}
        }
        return (u);
	}
	
	public static User getStUserByUserId(String uid) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        User u = new User();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, lastlogin FROM user ";
        q+="  WHERE user_id ='"+uid+"' ;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            int i=0;
            while (rs.next()) {
            	String user_id = rs.getString("user_id");
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	String username = rs.getString("username");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	Boolean bounced = rs.getBoolean("bounced");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	u.setLastlogin(lastlogin);
            	i++;
            }
            if (i==0) u=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getStUserByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getStUserByUserId Close Exp:"+e);
        	}
        }
        return (u);
	}
	
	public static ArrayList<User> getStUserCountByDate() { 
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> stl = new ArrayList<User>();
        
        String q="SELECT created, count(*) FROM user ";
        q+="  GROUP BY created ORDER BY created DESC;";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	User u = new User();
            	String user_id = rs.getString("count(*)");
            	String created = rs.getString("created");


            	u.setUserId(user_id);
            	u.setCreated(created);
            	stl.add(u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getStUsersCountByDate SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getStUsersCountByDate Close Exp:"+e);
        	}
        }
        return (stl);
	}
	
	public String writeStUser(User t) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String pswd=t.getPassword();
        String digest=MD5Digest.getDigestFromString(pswd);
        
        String q="INSERT INTO user ";
        q+="(firstname, lastname, username, password, email, created) ";
        q+=" VALUES (?, ?, ?, ?, ?, curdate() )";
        String q2="";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, t.getFirstname());
            pstmt.setString(2, t.getLastname());
            pstmt.setString(3, t.getUsername());
            pstmt.setString(4, digest);
            pstmt.setString(5, t.getEmail());
            int rowsAffected = pstmt.executeUpdate();
            q2="Rows Affected: "+rowsAffected+" - "+pstmt.toString();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("writeStUser SQL Exp: " + e);
            System.out.println("writeStUser SQL: " + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("writeStUser Close Exp: "+e);
        		rc="writeStUser:closeExp:"+e;
        	}
        }
        return (rc);
	}
	
	public static String updateStUserById(String user_id, String firstname, String lastname, String email) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="UPDATE user SET firstname=?, lastname=?, email=? WHERE user_id=? ;";
        String q2="";
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, email);
            pstmt.setString(4, user_id);
            int rowsAffected = pstmt.executeUpdate();
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2="Rows Affected: "+rowsAffected+" - "+pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("updateStUserById SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("updateStUserById Close Exp:"+e);
        		rc=""+e;
        	}
        }
		return(rc);
	}
	
	public static String updateLastloginByUsername(String username) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="UPDATE user SET lastlogin=now() WHERE username=? ;";
        String q2="";
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, username);

            int rowsAffected = pstmt.executeUpdate();
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2="Rows Affected: "+rowsAffected+" - "+pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("updateLastloginByUsername SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("updateLastloginByUsername Close Exp:"+e);
        		rc=""+e;
        	}
        }
		return(rc);
	}
	
	public static String updateLastloginByUserId(String user_id, String lastlogin) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="UPDATE user SET lastlogin=? WHERE user_id=? ;";
        String q2="";
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, lastlogin);
            pstmt.setString(2, user_id);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) rc="Success";
            else rc="Failure to update lastlogin for "+user_id;
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2=pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("updateLastloginByUserId SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("updateLastloginByUserId Close Exp:"+e);
        		rc=""+e;
        	}
        }
		return(rc);
	}
	
	public static String updatePasswordByEmail(String email, String pswd) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String digest=MD5Digest.getDigestFromString(pswd);
        
        String q="UPDATE user ";
        q+="SET password='"+digest+"' ";
        q+=" WHERE email='"+email+"' ;";
        // System.out.println("SQL: "+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            stmt.executeUpdate(q);
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("updatePaswdByEmail SQL:" + q);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("updatePaswdByEmail Close Exp:"+e);
        		rc="updatePasswordByEmail: closeExp:"+e;
        	}
        }
        return (rc);
	}
	
	public static String setUserBounce(String user_id, Boolean bstate) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="UPDATE user SET bounced=? WHERE user_id=? ;";
        String q2="";
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setBoolean(1, bstate);
            pstmt.setString(2, user_id);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) rc="Success";
            else rc="Failure to update 'bounced' for "+user_id;
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2=pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("setUserBounce SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("setUserBounce Close Exp:"+e);
        		rc=""+e;
        	}
        }
		return(rc);
	}
	
	public static String setUserEmailBounce(String email, Boolean bstate) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="UPDATE user SET bounced=? WHERE email=? ;";
        String q2="";
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setBoolean(1, bstate);
            pstmt.setString(2, email);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) rc="Success";
            else rc="Failure to update 'bounced' for "+email;
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2=pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("setUserEmailBounce SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("setUserEmailBounce Close Exp:"+e);
        		rc=""+e;
        	}
        }
		return(rc);
	}
	
	public static String deleteStUserByUserId(String uid) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="DELETE FROM user ";
        q+="  WHERE user_id='"+uid+"';";
        // System.out.println("SQL: "+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            stmt = con.createStatement();
            // stmt.executeUpdate("use subplaid;");
            stmt.executeUpdate(q);
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("deleteStUser SQL:" + q);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("deleteStUser Close Exp:"+e);
        		rc="deleteStUser: closeExp:"+e;
        	}
        }
        return (rc);
	}
}
