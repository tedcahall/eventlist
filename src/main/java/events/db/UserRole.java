package events.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import events.EvProperties;

public class UserRole {
	public void setUsername(String username) { this.username = username; }
	public void setRolename(String rolename) { this.rolename = rolename; }

	public String getUsername() { return username; }
	public String getRolename() { return rolename; }
	
	String username;
	String rolename;
	
	public String writeStUserRole(UserRole t) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="INSERT INTO user_roles ";
        q+="(username, rolename) ";
        q+=" VALUES (?, ?) ;";
        String q2="";
        
        //q+="'"+t.getUsername()+"','"+t.getRolename();
        ///q+="' )";
        // System.out.println("SQL: "+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, t.getUsername());
            pstmt.setString(2, t.getRolename());
            q2=pstmt.toString();
            //System.out.println("writeStUserRole: q2: "+q2);
            pstmt.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("writeStUserRole SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("writeStUserRole Close Exp:"+e);
        		rc="writeStUserRole: closeExp:"+e;
        	}
        }
        return (rc);
	}
	
	public static String deleteUserRole(String username) {
		Connection con=null;
		String url = EvProperties.getDburl();
		String dbu = EvProperties.getDbuser();
        String dbp = EvProperties.getDbpswd();
        String rc="Success";
        
        String q="DELETE FROM user_roles  WHERE username=? ;";
        String q2="";
        // System.out.println("SQL: "+q);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
                    System.out.println("MySQl JDBC Driver Class not found "+ e);
        }
        try {
            con = DriverManager.getConnection(url, dbu, dbp);
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, username);
            q2=pstmt.toString();
            //System.out.println("deleteStUserRole: q2: "+q2);
            pstmt.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            System.out.println("SQL Exp:" + e);
            System.out.println("deletetUserRole SQL:" + q2);
            rc=""+e;
        } finally {
        	try {
        		if (con != null) con.close();
        	} catch (Exception e) {
        		System.out.println("deletetUserRole Close Exp:"+e);
        		rc="deletetUserRole: closeExp:"+e;
        	}
        }
        return (rc);
	}
}
