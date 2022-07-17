package events;

// import java.util.HashMap;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import events.db.AppLog;


public class EventsInitializer extends HttpServlet
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 455L;

	public void init() throws ServletException
    {
		EvProperties sp = new EvProperties();
		
        // Write to Catalina.out to show we initialized
		ServletContext ctx=this.getServletContext();
        System.out.println("****************************************");
        System.out.println("*** Servlet Initialized successfully ***");
        System.out.println("*** Ted Cahall - Events Application  ***");
        System.out.println("****************************************");
        System.out.println("App path: "+ctx.getRealPath("/"));
        System.out.println("getContextPath(): " + ctx.getContextPath());
        System.out.println("Apache Tomcat Server: " + ctx.getServerInfo());
        System.out.println("Servlet API version: " + ctx.getMajorVersion() + "." +ctx.getMinorVersion());
        System.out.println("Tomcat Project Name: " + ctx.getServletContextName());
        
	try {
	  	sp.getPropValues();
	  	sp.setServletContext(ctx);
	  	String hostname=EvProperties.getHostname();
	  	String tomcat=ctx.getServerInfo();
	  	sp.setTomcat(tomcat);
	  	String project=ctx.getServletContextName();
	  	String context=ctx.getContextPath();
	  	String appPath=ctx.getRealPath("/");
	  	AppLog.writeAppLog("0", "0", "system", "Initialize", "Server: "+hostname+" * "+tomcat+" * "+project);
	  	
	  	// Write some of the DB stuff to the system log
	  	// DBInfo.logInfo();

	  	System.out.println("****************************************");
	  	
	  	System.out.println("ServletInitializer: Done initializing");
	  	AppLog.writeAppLog("0", "0", "system", "Initialize", "Done initializing: Server: "+hostname+" * "+tomcat+" * "+project+" * "+context);
	}
	catch (IOException e) {
		System.out.println("*******************************************");
    	System.out.println("*** Ted Cahall - Subtractor Application ***");
    	System.out.println("IO Exception occurred trying to get property file: " + e);
    	System.out.println("*******************************************");
	}
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {


    }
}

