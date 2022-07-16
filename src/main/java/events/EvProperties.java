package events;
 
// import java.io.File;
// import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.servlet.ServletContext;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class EvProperties {
 
	private static String dbuser="test";
	private static String dbpswd="test";
	private static String dburl="test";
	private static String hostname="Not-Set-Yet";
	private static Boolean inAWS=true;
	private static String tomcat="not-set";
	private static ServletContext sc;
	private static String webhook="not-set-yet";

	public void setDbuser(String d) { dbuser=d; }
	public void setDbpswd(String d) { dbpswd=d; }
	public void setDburl(String d) { dburl=d; }
	public void setHostname(String d) { hostname=d; }
	public void setInAWS(Boolean x) { inAWS=x; }
	public void setTomcat(String d) { tomcat=d; }
	public void setServletContext(ServletContext x) { sc=x; }
	public void setWebhook(String x) { webhook=x; }
	
	public static String getDbuser() { return dbuser; }
	public static String getDbpswd() { return dbpswd; }
	public static String getDburl() { return dburl; }
	public static String getHostname() { return hostname; }
	public static Boolean getInAWS() { return inAWS; }
	public static String getTomcat() { return tomcat; }
	public static ServletContext getServletContext() { return sc; }
	public static String getWebhook() { return webhook; }

	public String getPropValues() throws IOException {
 
		String result = "";
		Properties prop = new Properties();
		String propFileName = "events.properties";
		InputStream is = null;
		java.net.InetAddress host;
		String hostname = "";
 
		try {
			host = java.net.InetAddress.getLocalHost();
			hostname = host.getHostName();
			System.out.println("Hostname: " + hostname);
			setHostname(hostname);
		} catch (Exception ex) {
			System.out.println("Inet Exception occurred getting hostname" + ex);
		}
		is = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (is != null) {
			prop.load(is);
 
			// get the property value and print it out
			String dbu = prop.getProperty("dbuser");
			String dbp = prop.getProperty("dbpassword");
			String url = prop.getProperty("url");
			String awsurl = prop.getProperty("awsurl");
			String localWebhook=prop.getProperty("localWebhook");
			String awsWebhook=prop.getProperty("awsWebhook");
			setDbuser(dbu);
			setDbpswd(dbp);
			if (hostname.substring(0,3).equals("ip-")) {
				setDburl(awsurl);
				setInAWS(true);
				setWebhook(awsWebhook);
			} else {
				setDburl(url);
				setInAWS(false);
				setWebhook(localWebhook);
			}
			System.out.println("url set to: "+getDburl());
			result="properties= "+dbu+", "+dbp+", "+url+","+awsurl;
			System.out.println("-- properties --");
			System.out.println("dbuser: "+dbu);
			System.out.println("dbpassword: "+dbp);
			System.out.println("local URL:"+url);
			System.out.println("AWS URL:"+awsurl);
			System.out.println("Webhook URL:"+getWebhook());
			
		} else  {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
 
		Date time = new Date(System.currentTimeMillis());
		System.out.println("Program Ran on " + time );
		return result;
	}
}

