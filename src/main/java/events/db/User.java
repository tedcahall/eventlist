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
	public void setFlagger(Boolean flagger) { this.flagger = flagger; }
	public void setCreated(String created) { this.created = created; }
	public void setLastlogin(String lastlogin) { this.lastlogin = lastlogin; }
	
	public String getUserId() { return user_id; }
	public String getFirstname() { return firstname; }
	public String getLastname() { return lastname; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getEmail() { return email; }
	public Boolean getBounced() { return bounced; }
	public Boolean getFlagger() { return flagger; }
	public String getCreated() { return created; }
	public String getLastlogin() { return lastlogin; }
	
	String user_id;
	String firstname;
	String lastname;
	String username;
	String password;
	String email;
	Boolean bounced;
	Boolean flagger;
	String created;
	String lastlogin;
	
	public static int getCount() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        int count=0;
        
        String q="SELECT count(*) FROM st_user ;";
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
        
        
        String q="SELECT count(*) FROM st_user WHERE created=curdate();";
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
        
        
        String q="SELECT count(*) FROM st_user WHERE DATE_ADD(created, INTERVAL 7 DAY) > curdate();";
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
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, flagger, created, lastlogin FROM st_user ORDER BY user_id ;";
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
            	Boolean flagger = rs.getBoolean("flagger");
            	String created = rs.getString("created");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	u.setFlagger(flagger);
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
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, created, lastlogin FROM st_user WHERE bounced=true ORDER BY user_id ;";
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
	
	public static ArrayList<User> getFlaggerStUser() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> ul = new ArrayList<User>();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, flagger, created, lastlogin FROM st_user WHERE flagger=true ORDER BY user_id ;";
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
            	Boolean flagger = rs.getBoolean("flagger");
            	String created = rs.getString("created");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	u.setFlagger(flagger);
            	u.setCreated(created);
            	u.setLastlogin(lastlogin);
            	ul.add(u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getFlaggerStUser SQL Exp:" + e);
            System.out.println("getFlaggerStUser SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getFlaggerStUser Close Exp:"+e);
        	}
        }
        return (ul);
	}
	
	public static HashMap<String, User> getFlaggerStUserWithUserTags() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        HashMap<String, User> uhm = new HashMap<String, User>();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, flagger, created, lastlogin FROM st_user WHERE flagger=true ";
        q+="   AND user_id in (SELECT DISTINCT user_id from user_tag) ";
        q+="   ORDER BY user_id ;";
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
            	Boolean flagger = rs.getBoolean("flagger");
            	String created = rs.getString("created");
            	String lastlogin = rs.getString("lastlogin");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setBounced(bounced);
            	u.setFlagger(flagger);
            	u.setCreated(created);
            	u.setLastlogin(lastlogin);
            	uhm.put(user_id, u);
            	// System.out.println("StUser.getFlaggerStUserWithUserTags: found user: "+username+" "+user_id);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getFlaggerStUserWithUserTags SQL Exp:" + e);
            System.out.println("getFlaggerStUserWithUserTags SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getFlaggerStUserWithUserTags Close Exp:"+e);
        	}
        }
        return (uhm);
	}
	
	// SQL kind of getting messy since there can be multiple tags for one BillerMaster - and we only want to count new Subs by BillerMaster / AcctId
	public static ArrayList<User> getNewSubsByUser() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> ul = new ArrayList<User>();
        
        // This is a count of count.  The subselect gets the counts per master_id/acct_id - and then the outer select rolls them up.
        // Example: digit.io has 4 tags that all roll up to the Digit.io BillerMaster ID.  Those might show 4 new subs when first found - but should only be 1 ad the MID level
        // The sub-select would have a count of 4 for that MasterID/AcctID - but that would be rolled up as 1 sub in the outer query and not 4.
        // Similar issues exist with Apl*iTunes, Uber *Trip, Uber *Eats, etc where the soft descriptor can vary inside a single account.  Fun!
        String q="SELECT uid, fn, ln, un, em, ll, bb, count(*) FROM ( ";
        q+="SELECT a.user_id AS uid, a.firstname AS fn, a.lastname AS ln, a.username AS un, a.email AS em, a.lastlogin AS ll, bounced AS bb, count(*) AS cnt FROM st_user as a, biller_user as b ";
        q+=" WHERE a.user_id=b.user_id ";
        q+=" AND b.ts > date_add(a.lastlogin, INTERVAL 1 hour) ";
        q+=" GROUP BY a.user_id, a.firstname, a.lastname, a.username, a.email, a.lastlogin, a.bounced, b.master_id, b.acct_id) AS junk";
        q+=" GROUP BY uid, fn, ln, un, em, ll, bb; ";
        
        // below is the old code that worked before the concept of the BillerMaster and multiple tags per BillerMaster.
        /*
        String q="select a.user_id, a.firstname, a.lastname, a.username, a.email, a.lastlogin, count(*) from st_user as a, biller_user as b ";
        q+=" where a.user_id=b.user_id ";
        q+=" AND b.ts > date_add(a.lastlogin, INTERVAL 1 hour) ";
        q+=" group by a.user_id, a.firstname, a.lastname, a.username, a.email, a.lastlogin; ";
        */
        // System.out.println("getNewSubsByUser q="+q);
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
            	String user_id = rs.getString("uid");
            	String firstname = rs.getString("fn");
            	String lastname = rs.getString("ln");
            	String username = rs.getString("un");
            	String password = rs.getString("count(*)");
            	String email = rs.getString("em");
            	String lastlogin = rs.getString("ll");
            	Boolean bounced = rs.getBoolean("bb");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setPassword(password);
            	u.setEmail(email);
            	u.setLastlogin(lastlogin);
            	u.setBounced(bounced);
            	ul.add(u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getNewSubsByUser SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getNewSubsByUser Close Exp:"+e);
        	}
        }
        return (ul);
	}
	
	// need to pass in lastlogin since the field in the st_user record has been updated by the time we need it
	public static int getNewSubsByUserId(String uid, String lastlogin) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        int nsubs=0;
        
        if ("Initial Login".equals(lastlogin)) lastlogin="2099-12-31"; // Date in the far future...
        // String q="SELECT user_id, firstname, lastname, username, password, email FROM st_user ;";
        String q="select count(*) from st_user as a, biller_user as b ";
        q+=" where a.user_id=b.user_id AND a.user_id="+uid;
        q+=" AND date_sub(b.ts, INTERVAL 1 hour) > '"+lastlogin+"' ;";
        // System.out.println("getNewSubsByUserId q="+q);
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
            	nsubs = rs.getInt("count(*)");
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getNewSubsByUserId SQL Exp: " + e);
            System.out.println("getNewSubsByUserId SQL: " + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getNewSubsByUserId Close Exp:"+e);
        	}
        }
        return (nsubs);
	}
	
	public static HashMap<String,User> getStUserHM() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        HashMap<String, User> uhm = new HashMap<String, User>();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced FROM st_user ;";
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
        
        String q="SELECT user_id, firstname, lastname, username, password, email, lastlogin FROM st_user ";
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
		//Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        User u = new User();
        
        String q="SELECT user_id, firstname, lastname, username, password, email, created, lastlogin FROM st_user ";
        q+="  WHERE username=? ;";
        String q2="";
        // System.out.println("q="+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            //stmt = con.createStatement();
            //stmt.executeUpdate("use subplaid;");
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, uname);
            q2=pstmt.toString();
            // System.out.println("getStUserByUsername: q2: "+q2);
            ResultSet rs = pstmt.executeQuery();
            
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
        
        String q="SELECT user_id, firstname, lastname, username, password, email, bounced, lastlogin FROM st_user ";
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
	
	public static ArrayList<User> getStUsersWithNoBanks() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> stl = new ArrayList<User>();
        
        String q="SELECT user_id, firstname, lastname, username, email, lastlogin, bounced FROM st_user ";
        q+="  WHERE user_id NOT in (select user_id from bank) ORDER BY user_id;";
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
            	String email = rs.getString("email");
            	String lastlogin = rs.getString("lastlogin");
            	Boolean bounced = rs.getBoolean("bounced");

            	u.setUserId(user_id);
            	u.setFirstname(firstname);
            	u.setLastname(lastname);
            	u.setUsername(username);
            	u.setEmail(email);
            	u.setLastlogin(lastlogin);
            	u.setBounced(bounced);
            	stl.add(u);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getStUsersWithNoBanks SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getStUsersWithNoBanks Close Exp:"+e);
        	}
        }
        return (stl);
	}
	
	public static ArrayList<User> getStUserCountByDate() { 
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        ArrayList<User> stl = new ArrayList<User>();
        
        String q="SELECT created, count(*) FROM st_user ";
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
        
        String q="INSERT INTO st_user ";
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
            int rowAffected = pstmt.executeUpdate();
            q2=pstmt.toString();
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
        
        String q="UPDATE st_user SET firstname=?, lastname=?, email=? WHERE user_id=? ;";
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
            int rowAffected = pstmt.executeUpdate();
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2=pstmt.toString();
            
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
        
        String q="UPDATE st_user SET lastlogin=now() WHERE username=? ;";
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

            int rowAffected = pstmt.executeUpdate();
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2=pstmt.toString();
            
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
        
        String q="UPDATE st_user SET lastlogin=? WHERE user_id=? ;";
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
        
        String q="UPDATE st_user ";
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
        
        String q="UPDATE st_user SET bounced=? WHERE user_id=? ;";
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
	
	public static String setUserFlagger(String user_id) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="UPDATE st_user SET flagger=true WHERE user_id=? ;";
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
            pstmt.setString(1, user_id);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) rc="Success";
            else rc="Failure to update 'flagger' for "+user_id;
            // System.out.println("UpdateStUserById SQL: "+pstmt.toString());
            q2=pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("setUserFlagger SQL Exp:" + e);
            System.out.println("setUserFlagger SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("setUserFlagger Close Exp:"+e);
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
        
        String q="UPDATE st_user SET bounced=? WHERE email=? ;";
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
        
        String q="DELETE FROM st_user ";
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
