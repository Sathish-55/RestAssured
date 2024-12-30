package com.rsa;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class myself {

	public static void main(String[] args) {
		String URL = RestAssured.baseURI= ("https://rahulshettyacademy.com");
		//getLoc();
		postLoc();
	}
	
	public static void getLoc() {
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "0da67d3bab01ea31df835af46bb13e64").when().get("maps/api/place/get/json").then()
		.log().all().assertThat().statusCode(200).extract().response().asString();
	}
	
	public static void postLoc() {
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Testing Practice\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/get/json").then()
		.log().all().assertThat().statusCode(200).extract().response().asString();
	}
}
