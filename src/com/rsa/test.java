package com.rsa;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("testing");
RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		given().queryParam("key" , "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Testing Practice\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"")
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200);
	}

}
