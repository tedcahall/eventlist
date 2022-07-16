package subs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

class DBInfo {
	public static void logInfo()
	{
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/SubPlaid");
			
			con = ds.getConnection();
			java.sql.DatabaseMetaData dbmd = con.getMetaData();
			int dbmaj, dbmin, drvmaj, drvmin, jdbcmaj, jdbcmin;
			dbmaj=dbmd.getDatabaseMajorVersion();
			dbmin=dbmd.getDatabaseMinorVersion();
			drvmaj=dbmd.getDriverMajorVersion();
			drvmin=dbmd.getDriverMinorVersion();
			jdbcmaj=dbmd.getJDBCMajorVersion();
			jdbcmin=dbmd.getJDBCMinorVersion();
			String url=dbmd.getURL();
			String username=dbmd.getUserName();
			
            System.out.println("--Database Details--");
            System.out.println("User Name: "+username);
            System.out.println("JNDI URL: "+url);
            System.out.println("Database Product: "+dbmd.getDatabaseProductName()+" "+dbmaj+"."+dbmin);
            System.out.println("Database Driver: "+dbmd.getDriverName()+" "+drvmaj+"."+drvmin);
            System.out.println("JDBC Driver: "+jdbcmaj+"."+jdbcmin);
            con.close();
			ctx.close();
            
		}catch(NamingException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
