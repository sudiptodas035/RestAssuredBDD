package common;

import Utils.Utility;

public class ApplicationConstants {
	/*URI constants*/
	public static final String baseURI=Utility.readConfig().getProperty("baseURI");
	public static final String basePathSingleUserURI=Utility.readConfig().getProperty("basePathSingleUser");
	public static final String basePathListUserURI=Utility.readConfig().getProperty("basePathListUser");
	public static final String basePathSingleUserNotFoundURI=Utility.readConfig().getProperty("basePathSingleUserNotFound");
	public static final String basePathPostSingleUserURI=Utility.readConfig().getProperty("basePathPostSingleUser");
	public static final String basePathPostRegisterSuccessfulURI=Utility.readConfig().getProperty("basePathPostRegisterSuccessful");
	
	
	/*Status Code OK*/
	public static final int StatusCodeOK=200;
	/*Status Code 404*/
	public static final int StatusCode404=404;
	/*Status Line OK*/
	public static final String StatusLineOK="HTTP/1.1 200 OK";
	/*Status Line OK*/
	public static final String StatusLine404="HTTP/1.1 404 Not Found";
	/*Content Type*/
	public static final String ContentType="application/json; charset=utf-8";
	/*Request Content Type*/
	public static final String ReqContentType="application/json;";
}
