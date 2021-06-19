package prj.sunaynatalreja.jsonutil;

import static com.jayway.restassured.RestAssured.given;
import java.util.Map;
import org.testng.Assert;
import com.jayway.restassured.response.Response;

import prj.sunaynatalreja.extentreportutil.ExtentReportUtil;
import prj.sunaynatalreja.logutil.Log;

public class JSONUtil {
	
	private static JSONUtil jsonutilinstance;
	
	private JSONUtil()
	{
		
	}
	public static JSONUtil getInstance()
    {
        if (jsonutilinstance == null)
        	jsonutilinstance = new JSONUtil();
  
        return jsonutilinstance;
    }	
	
	
	
	/**
	 * Json Get Request With Path Parameter
	 * @param Url
	 * @param data
	 * @return
	 */
	public String executeJsonGetPathParameter(String Url,Map<String,String> data)  {
		Response response =given().pathParams(data).when().get(Url);
		if(response.getStatusCode()>399)
		{
			Assert.fail("Response status code is :"+response.getStatusCode()+response.getStatusLine()+ "for request: "+Url);
			Log.setMessageInfo("Request Url: "+Url);
		}
		
		String res = response.body().asString();
		Log.setMessageInfo("response: "+ res);
		
		return res;
	}
	
	/**
	 * Json Get Request With Query Parameter
	 * @param Url
	 * @param data
	 * @return
	 */
	public Response executeJsonGetQueryParams(Map<String,String> param,String Url)  {
		// Creating object for JSON request
		Response response =given().queryParams(param).when().get(Url);
		if(response.getStatusCode()>399)
		{
			Assert.fail("Response status code is :"+response.getStatusCode()+response.getStatusLine()+ "for request: "+Url);
			Log.setMessageInfo("Request Url: "+Url);
		}
		return response;
	}
	
	/**
	 * Json Put request, taking request json as String
	 * @param testData
	 * @param url
	 * @return
	 */
	public String executeJsonPut(String testData, String url) {
		Response response = given().header("Content-Type", "application/json").body(testData)
				.relaxedHTTPSValidation().request().put(url);
		if(response.getStatusCode()>399)
		{
			Assert.fail("Response status code is :"+response.getStatusCode()+response.getStatusLine()+ "for request: "+url);
			Log.setMessageInfo("Request URL: "+url);
			Log.setMessageInfo("Request Body: "+testData);
		}
		String res = response.body().asString();
		Log.setMessageInfo(res);
		
		return res;
	}
	
	/**
	 * Generic post request 
	 * which takes json string payload and url as input
	 * and returns string response
	 * @param testData
	 * @param url
	 * @return
	 */
	public String executeJsonPost(String testData, String url) {

		
		Response response = given().header("Content-Type", "application/json").body(testData)
				.relaxedHTTPSValidation().request().post(url);
		if(response.getStatusCode()>399)
		{
			Assert.fail("<b>Response status code is :"+response.getStatusCode()+response.getStatusLine()+"</b>"+ "for request: "+url);
			Log.setMessageInfo("Request URL: "+url);
			Log.setMessageInfo("Request Body: "+testData);
		}
		String res = response.body().asString();
		Log.setMessageInfo(res);
		
		return res;
	}
	

	/**
	 * Json Delete with path params
	 * @param pathParams
	 * @param url
	 * @return
	 */
	public Response executeJsonDeleteWithPathParams(Map<String,String> pathParams,String url) {
		Response response =given().pathParams(pathParams).when().delete(url);
		if(response.getStatusCode()>399)
		{
			Assert.fail("<b>Response status code is :"+response.getStatusCode()+response.getStatusLine()+"</b>"+ "for request: "+url);
			Log.setMessageInfo("Request URL: "+url);
			
		}
		String res = response.body().asString();
		Log.setMessageInfo(res);
		return response;
	}
}
