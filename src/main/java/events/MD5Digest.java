package events;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// https://www.avajava.com/tutorials/lessons/how-do-i-use-md5-passwords-with-a-jdbc-realm-for-tomcat.html
// https://www.avajava.com/tutorials/lessons/how-do-i-generate-an-md5-digest-for-a-string.html
public class MD5Digest {
	
	public static String getDigestFromString(String original) {

		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("MD5Digest:getDigestFromString ERROR: "+e);
			// e.printStackTrace();
			return(null);
		}
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		// System.out.println("original:" + original);
		System.out.println("digested(hex):" + sb.toString());
		return(sb.toString());
	}

}
