package cn.byau.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;



/**
 * 小小工具
 * 
 * @author
 *
 */
public class CommonUtils {

	// 管理员的权限值为01
	public static final String ADMIN_ROLE = "01";

	// 用户的权限值为02
	public static final String USER_ROlE = "02";
	
	public static boolean isContains(String containers, 
    		String[] regx) {
        for (int i = 0; i < regx.length; i++) {
            if (containers.contains(regx[i])) {
                return true;
            }
        }
        return false;
    }
	/**
	 * 返回一个不重复的字符串
	 * 
	 * @return
	 */

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	public  static String getMD5(String s) throws NoSuchAlgorithmException {
		String result = "";
		char hexDidits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d',
				'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
				'v','w','x','y','z'};
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			byte[] strTemp = s.getBytes();
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j*2];
			int k = 0;
			for(int i=0;i<j;i++) {
				byte b = md[i];
				str[k++] = hexDidits[b>>4&0xf];
				str[k++] = hexDidits[b&0xf];
			}
			result = new String(str);
		return result;
	}
	
	public static String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}


}
