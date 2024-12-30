package com.json;
import io.restassured.path.json.*;

public class JsonToString {
	
	public static JsonPath JsonFormatToString(String Response) {
		
		JsonPath js = new JsonPath(Response);
		return js;
	}

}
