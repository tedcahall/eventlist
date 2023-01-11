package events.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import events.EvProperties;

public class EventListTitle {
	
    String eventlist_id;
    String user_id;
    String event_title;
    String event_desc;
    String urlkey;
    String evdate_hdr;
    String evname_hdr;
    String evlocation_hdr;
    String evother1_hdr;
    String evother2_hdr;
    String evo1_disp;
    String evo2_disp;
    
    public void setEventListId(String x) { this.eventlist_id = x; }
    public void setUserId(String x) { this.user_id = x; }
    public void setEventTitle(String x) { this.event_title = x; }
    public void setEventDesc(String x) { this.event_desc = x; }
    public void setUrlkey(String x) { this.urlkey = x; }
    public void setEvdateHdr(String x) { this.evdate_hdr = x; }
    public void setEvnameHdr(String x) { this.evname_hdr = x; }
    public void setEvlocationHdr(String x) { this.evlocation_hdr = x; }
    public void setEvother1Hdr(String x) { this.evother1_hdr = x; }
    public void setEvother2Hdr(String x) { this.evother2_hdr = x; }
    public void setEvo1Disp(String x) { this.evo1_disp = x; }
    public void setEvo2Disp(String x) { this.evo2_disp = x; }
    
    public String getEventListId() { return this.eventlist_id; }
    public String getUserId() { return this.user_id; }
    public String getEventTitle() { return this.event_title; }
    public String getEventDesc() { return this.event_desc; }
    public String getUrlkey() { return this.urlkey; }
    public String getEvdateHdr() { return this.evdate_hdr; }
    public String getEvnameHdr() { return this.evname_hdr; }
    public String getEvlocationHdr() { return this.evlocation_hdr; }
    public String getEvother1Hdr() { return this.evother1_hdr; }
    public String getEvother2Hdr() { return this.evother2_hdr; }
    public String getEvo1Disp() { return this.evo1_disp; }
    public String getEvo2Disp() { return this.evo2_disp; }
    
    public static ArrayList<EventListTitle> getEventistTitleList() {
    	Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<EventListTitle> evl = new ArrayList<EventListTitle>();
    	
    	String q="SELECT eventlist_id, user_id, event_title, event_desc, urlkey, evdate_hdr, evname_hdr, evlocation_hdr "+
    	          "FROM eventlist_title;";
    	String q2="";
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            q2=pstmt.toString();
            ResultSet rs = pstmt.executeQuery();
            
            // System.out.println("getEventistTitleList: q2: "+q2);
            
            int i=0;
            while (rs.next()) {
            	EventListTitle ev = new EventListTitle();
            	String eventlist_id = rs.getString("eventlist_id");
            	String user_id = rs.getString("user_id");
            	String event_title = rs.getString("event_title");
            	String event_desc = rs.getString("event_desc");
            	String urlkey = rs.getString("urlkey");
            	String evdate_hdr = rs.getString("evdate_hdr");
            	String evname_hdr = rs.getString("evname_hdr");
            	String evlocation_hdr = rs.getString("evlocation_hdr");
            	
            	ev.setEventListId(eventlist_id);
            	ev.setUserId(user_id);
            	ev.setEventTitle(event_title);
            	ev.setEventDesc(event_desc);
            	ev.setUrlkey(urlkey);
            	ev.setEvdateHdr(evdate_hdr);
            	ev.setEvnameHdr(evname_hdr);
            	ev.setEvlocationHdr(evlocation_hdr);
            	evl.add(ev);
            	i++;
            }
            if (i==0) evl=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getEventistTitleList SQL Exp: " + e);
            System.out.println("getEventistTitleList SQL:" + q2);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getEventistTitleList Close Exp:"+e);
        	}
        }
    	
    	return evl;
    }
    
    public static ArrayList<EventListTitle> getEventistTitleListByUserId(String uid) {
    	Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        ArrayList<EventListTitle> evl = new ArrayList<EventListTitle>();
    	
    	String q="SELECT eventlist_id, user_id, event_title, event_desc, urlkey, evdate_hdr, evname_hdr, evlocation_hdr "+
    	          "FROM eventlist_title "+
    	          "WHERE user_id=?";
    	String q2="";
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, uid);
            q2=pstmt.toString();
            ResultSet rs = pstmt.executeQuery();
            
            // System.out.println("getEventistTitleList: q2: "+q2);
            
            int i=0;
            while (rs.next()) {
            	EventListTitle ev = new EventListTitle();
            	String eventlist_id = rs.getString("eventlist_id");
            	String user_id = rs.getString("user_id");
            	String event_title = rs.getString("event_title");
            	String event_desc = rs.getString("event_desc");
            	String urlkey = rs.getString("urlkey");
            	String evdate_hdr = rs.getString("evdate_hdr");
            	String evname_hdr = rs.getString("evname_hdr");
            	String evlocation_hdr = rs.getString("evlocation_hdr");
            	
            	ev.setEventListId(eventlist_id);
            	ev.setUserId(user_id);
            	ev.setEventTitle(event_title);
            	ev.setEventDesc(event_desc);
            	ev.setUrlkey(urlkey);
            	ev.setEvdateHdr(evdate_hdr);
            	ev.setEvnameHdr(evname_hdr);
            	ev.setEvlocationHdr(evlocation_hdr);
            	evl.add(ev);
            	i++;
            }
            if (i==0) evl=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getEventistTitleList SQL Exp: " + e);
            System.out.println("getEventistTitleList SQL:" + q2);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getEventistTitleList Close Exp:"+e);
        	}
        }
    	
    	return evl;
    }
    
    public static EventListTitle getEventistTitleById(String id) {
    	Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        EventListTitle ev = new EventListTitle();
    	
    	String q="SELECT eventlist_id, user_id, event_title, event_desc, urlkey, evdate_hdr, evname_hdr, evlocation_hdr "+
    	          "FROM eventlist_title where eventlist_id=?;";
    	String q2="";
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, id);
            q2=pstmt.toString();
            ResultSet rs = pstmt.executeQuery();
            
            // System.out.println("getEventistTitleById: q2: "+q2);
            
            int i=0;
            while (rs.next()) {
            	String eventlist_id = rs.getString("eventlist_id");
            	String user_id = rs.getString("user_id");
            	String event_title = rs.getString("event_title");
            	String event_desc = rs.getString("event_desc");
            	String urlkey = rs.getString("urlkey");
            	String evdate_hdr = rs.getString("evdate_hdr");
            	String evname_hdr = rs.getString("evname_hdr");
            	String evlocation_hdr = rs.getString("evlocation_hdr");
            	
            	ev.setEventListId(eventlist_id);
            	ev.setUserId(user_id);
            	ev.setEventTitle(event_title);
            	ev.setEventDesc(event_desc);
            	ev.setUrlkey(urlkey);
            	ev.setEvdateHdr(evdate_hdr);
            	ev.setEvnameHdr(evname_hdr);
            	ev.setEvlocationHdr(evlocation_hdr);
            	i++;
            }
            if (i==0) ev=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getEventistTitleById SQL Exp: " + e);
            System.out.println("getEventistTitleById SQL:" + q2);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getEventistTitleById Close Exp:"+e);
        	}
        }
    	
    	return ev;
    }
    
    public static EventListTitle getEventistTitleByKey(String key) {
    	Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        
        EventListTitle ev = new EventListTitle();
    	
    	String q="SELECT eventlist_id, user_id, event_title, event_desc, urlkey, evdate_hdr, evname_hdr, evlocation_hdr "+
    	          "FROM eventlist_title where urlkey=?;";
    	String q2="";
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, key);
            q2=pstmt.toString(); // this is the right location for this SELECT!
            ResultSet rs = pstmt.executeQuery();
            
            // System.out.println("getEventistTitleByKey: q2: "+q2);
            
            int i=0;
            while (rs.next()) {
            	String eventlist_id = rs.getString("eventlist_id");
            	String user_id = rs.getString("user_id");
            	String event_title = rs.getString("event_title");
            	String event_desc = rs.getString("event_desc");
            	String urlkey = rs.getString("urlkey");
            	String evdate_hdr = rs.getString("evdate_hdr");
            	String evname_hdr = rs.getString("evname_hdr");
            	String evlocation_hdr = rs.getString("evlocation_hdr");
            	
            	ev.setEventListId(eventlist_id);
            	ev.setUserId(user_id);
            	ev.setEventTitle(event_title);
            	ev.setEventDesc(event_desc);
            	ev.setUrlkey(urlkey);
            	ev.setEvdateHdr(evdate_hdr);
            	ev.setEvnameHdr(evname_hdr);
            	ev.setEvlocationHdr(evlocation_hdr);
            	i++;
            }
            if (i==0) ev=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getEventistTitleByKey SQL Exp: " + e);
            System.out.println("getEventistTitleByKey SQL:" + q2);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getEventistTitleByKey Close Exp:"+e);
        	}
        }
    	
    	return ev;
    }

}
