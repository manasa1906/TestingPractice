package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

@Test
public class PutPatchDeleteExamples {
	public void testPost() {
		JSONObject request = new JSONObject();
		request.put("name", "Manasa");
		request.put("job", "Developer");
		System.out.println(request.toJSONString());
		System.out.println(request.toString());
		System.out.println(request);
		baseURI = "https://reqres.in/api";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}