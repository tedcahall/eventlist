package events.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import events.EvProperties;

public class EventList {
	
	String evl_item_id;
    String eventlist_id;
    String user_id;
    String evdate;
    String evname;
    String evlocation;
    String evother1;
    String evother2;
    String evname_url;
    String evloc_url;
    String evo1_url;
    String evo2_url;
    
    public void setEvlItemId(String x) { this.evl_item_id = x; }
    public void setEventListId(String x) { this.eventlist_id = x; }
    public void setUserId(String x) { this.user_id = x; }
    public void setEvdate(String x) { this.evdate = x; }
    public void setEvname(String x) { this.evname = x; }
    public void setEvlocation(String x) { this.evlocation = x; }
    public void setEvother1(String x) { this.evother1 = x; }
    public void setEvother2(String x) { this.evother2 = x; }
    public void setEvnameUrl(String x) { this.evname_url = x; }
    public void setEvlocUrl(String x) { this.evloc_url = x; }
    public void setEvo1Url(String x) { this.evo1_url = x; }
    public void setEvo2Url(String x) { this.evo2_url = x; }
    
    public String getEvItemId() { return this.evl_item_id; }
    public String getEventListId() { return this.eventlist_id; }
    public String getUserId() { return this.user_id; }
    public String getEvdate() { return this.evdate; }
    public String getEvname() { return this.evname; }
    public String getEvlocation() { return this.evlocation; }
    public String getEvother1() { return this.evother1; }
    public String getEvother2() { return this.evother2; }
    public String getEvnameUrl() { return this.evname_url; }
    public String getEvlocUrl() { return this.evloc_url; }
    public String getEvo1Url() { return this.evo1_url; }
    public String getEvo2Url() { return this.evo2_url; }
    
    public static ArrayList<EventList> getEventistById(String id) {
    	Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
    	
    	ArrayList<EventList> el = new ArrayList<EventList>();
    	
    	String q="SELECT evl_item_id, eventlist_id, user_id, evdate, evname, evlocation FROM eventlist where eventlist_id=?;";
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
            
            ResultSet rs = pstmt.executeQuery();
            q2=pstmt.toString();
            System.out.println("getEventistById: q2: "+q2);
            
            int i=0;
            while (rs.next()) {
            	EventList e = new EventList();
            	String evl_item_id = rs.getString("evl_item_id");
            	String eventlist_id = rs.getString("eventlist_id");
            	String user_id = rs.getString("user_id");
            	String evdate = rs.getString("evdate");
            	String evname = rs.getString("evname");
            	String evlocation = rs.getString("evlocation");

            	e.setEvlItemId(evl_item_id);
            	e.setEventListId(eventlist_id);
            	e.setUserId(user_id);
            	e.setEvdate(evdate);
            	e.setEvname(evname);
            	e.setEvlocation(evlocation);
            	el.add(e);
            	i++;
            }
            if (i==0) el=null;
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("getEventistById SQL Exp: " + e);
            System.out.println("getEventistById SQL:" + q2);
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("getEventistById Close Exp:"+e);
        	}
        }
    	
    	return el;
    }

}
