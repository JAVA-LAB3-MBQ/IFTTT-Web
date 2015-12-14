package util;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;
public class WebUtils {
	/*
	 * convert the http request to an object
	 */
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try{
			T bean = clazz.newInstance();
			Enumeration<String> e = request.getParameterNames(); 
			while(e.hasMoreElements()){
				System.out.println("WebUtils 21");
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				System.out.println(name + value);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* 
	 * convert a Date object to String
	 */
	public static String date2String(Date d) {
		final String pattern = "yyyy-MM-dd HH:mm";
		return (new SimpleDateFormat(pattern)).format(d);
	}
}
