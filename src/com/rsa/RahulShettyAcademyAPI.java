package com.rsa;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.*;
import com.json.JsonToString;
import com.json.Payload;

public class RahulShettyAcademyAPI {

	String value = RestAssured.baseURI = "https://rahulshettyacademy.com";
	String Place_Id;
	String ExpectedAddress;

	public static void main(String[] args) {
		RahulShettyAcademyAPI rsa = new RahulShettyAcademyAPI();
		rsa.createLocation();
		rsa.updateLocation();
		rsa.getLocation();

	}

	public void createLocation() {
		String LocationResponse = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.addLocation()).when()
				.post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

		JsonPath js = JsonToString.JsonFormatToString(LocationResponse);
		Place_Id = js.getString("place_id");
			}

	public void updateLocation() {
		ExpectedAddress = "Testing Update Address";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.updateLocation(Place_Id, ExpectedAddress)).when().put("maps/api/place/update/json").then()
				.log().all().assertThat().statusCode(200).extract().response().asString();
	}

	public void getLocation() {
		String LocationResponseAfterUpdate = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", Place_Id).when().get("maps/api/place/get/json").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();

		JsonPath js = JsonToString.JsonFormatToString(LocationResponseAfterUpdate);
		String ActualAddress = js.getString("address");

		System.out.println(ActualAddress);
		// Assert.assertEquals(ActualAddress, ExpectedAddress);
	}
	
	
}
