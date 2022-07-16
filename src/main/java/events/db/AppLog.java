package events.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// import java.util.HashMap;

import events.EvProperties;

public class AppLog {

	private String id;
	private String ts;
	private String user_id;
	private String session_id;
	private String app;
	private String topic;
	private String message;
	
	public String getId() { return id; }
	public String getTs() { return ts; }
	public String getUserId() { return user_id; }
	public String getSessionId() { return session_id; }
	public String getApp() { return app; }
	public String getTopic() { return topic; }
	public String getMessage() { return message; }
	public void setId(String id) { this.id = id; }
	public void setTs(String x) { this.ts = x; }
	public void setUserId(String x) { this.user_id = x; }
	public void setSessionId(String x) { this.session_id = x; }
	public void setApp(String x) { this.app = x; }
	public void setTopic(String x) { this.topic = x; }
	public void setMessage(String x) { this.message = x; }

	public static ArrayList<AppLog> getAppLogLast100() {
		ArrayList<AppLog> apploglist = getAppLogLastN("100");
		return(apploglist);
	}
	
	public static ArrayList<AppLog> getAppLogLastN(String n) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  ORDER BY id DESC LIMIT "+n+";";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogLast100 SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogLast100 Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogPage(String tid) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE id<='"+tid+"' ";
        q+="  ORDER BY id DESC LIMIT 100;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogLast100 SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogLast100 Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogByUserId(String UserId) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE user_id="+UserId;
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByUserId Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogLoginsByUserId(String UserId) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE user_id="+UserId+" AND topic='Login'";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogLoginsByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogLoginsByUserId Close Exp:"+e);
        	}
        }
        return (btl);
	}

	// used to show the previous login in the login page of the user app
	public static String getPreviousLoginByUserId(String UserId) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        // ArrayList<AppLog> btl = new ArrayList<AppLog>();
        String lastlogin="";
        
        String q="SELECT ts FROM app_log ";
        q+="  WHERE user_id="+UserId+" AND topic='Login' order by ts DESC LIMIT 2;"; // toss the first one as it is current session
        
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	lastlogin = rs.getString("ts");
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getPreviousLoginByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getPreviousLoginByUserId Close Exp:"+e);
        	}
        }
        return (lastlogin);
	}
	
	// used to show last login for the users in the Admin Tool
	public static String getLastLoginByUserId(String UserId) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        // ArrayList<AppLog> btl = new ArrayList<AppLog>();
        String lastlogin="";
        
        String q="SELECT ts FROM app_log ";
        q+="  WHERE user_id="+UserId+" AND topic='Login' order by ts DESC LIMIT 1;"; 
        
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	lastlogin = rs.getString("ts");
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getLastLoginsByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getLastLoginsByUserId Close Exp:"+e);
        	}
        }
        return (lastlogin);
	}
	
	public static ArrayList<AppLog> getAppLogByTopic(String top) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE topic='"+top+"'";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByTopic SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByTopic Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogLikeTopic(String top) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE topic LIKE '"+top+"%'";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByTopic SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByTopic Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogByPromoList(String list) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE topic in ("+list+")";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByTopic SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByTopic Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogByApp(String appname) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE app='"+appname+"'";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByApp SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByApp Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogUniqueSessions() {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT user_id, DISTINCT session_id FROM app_log ";
        q+="  ORDER BY session_id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByUserId Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> getAppLogBySessionId(String sess) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE session_id='"+sess+"' ";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("getAppLogByUserId SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getAppLogByUserId Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static ArrayList<AppLog> searchAppLogMessage(String query) {
		Statement stmt;
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<AppLog> btl = new ArrayList<AppLog>();
        
        String q="SELECT id, ts, user_id, session_id, app, topic, message FROM app_log ";
        q+="  WHERE message  like'%"+query+"%' ";
        q+="  ORDER BY id DESC;";
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
            stmt.executeUpdate("use subplaid;");
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
            	AppLog t = new AppLog();
            	String id = rs.getString("id");
            	String ts = rs.getString("ts");
            	String user_id = rs.getString("user_id");
            	String session_id = rs.getString("session_id");
            	String app = rs.getString("app");
            	String topic = rs.getString("topic");
            	String message = rs.getString("message");
            	t.setId(id);
            	t.setTs(ts);
            	t.setUserId(user_id);
            	t.setSessionId(session_id);
            	t.setApp(app);
            	t.setTopic(topic);
            	t.setMessage(message);
            	btl.add(t);
            }
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("searchAppLogMessage SQL:" + q);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("searchAppLogMessage Close Exp:"+e);
        	}
        }
        return (btl);
	}
	
	public static String writeAppLog(String user_id, String sid, String app, String topic, String message) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        // do not log healthchecks...
        if (message.contains("HealthChecker")) return(rc);
        if (message.contains("Timeout by: null")) return(rc);
        
        // make sure message is under 600 characters
        if (message.length() > 600)
        	message=message.substring(0,600);
        
        String q="INSERT INTO app_log (ts, user_id, session_id, app, topic, message) ";
		q+=" VALUES (now(), ? ,?, ?, ?, ?) ; ";
		String q2="";
		// System.out.println("writePwToken SQL:"+q);
		// System.out.println("writePwToken: "+user_id+" "+sid+" "+app+" "+topic+" "+message);
		if (app == null) app="unset"; // bug likely caused by no central login.
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
            pstmt.setString(2, sid);
            pstmt.setString(3, app);
            pstmt.setString(4, topic);
            pstmt.setString(5, message);
            int rowsAffected = pstmt.executeUpdate();
            q2="Rows Affected: "+rowsAffected+" - "+pstmt.toString();
            
            con.close();
        }
        catch (SQLException e) {
            System.out.println("writeAppLog SQL Exp: " + e);
            System.out.println("writeAppLog SQL: " + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("writeAppLog Close Exp: "+e);
        		rc=""+e;
        	}
        }
		return(rc);
	}
}
