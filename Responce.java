package com.api.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Responce {
	public static Response responce() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri(PropertiesFile.getProperty("baseURL"));
		reqSpec.queryParam("page", 1);
		reqSpec.contentType(ContentType.JSON);
		Response res = reqSpec.get();
		System.out.println("Time of get responce"+"  "+res.getTime());
		return res;
	}

	public static ResponseBody responceBody() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri(PropertiesFile.getProperty("baseURL"));
		reqSpec.queryParam("page", 1);
		reqSpec.contentType(ContentType.JSON);
		Response res = reqSpec.get();
		ResponseBody responseBody = res.getBody();
		return responseBody;

	}
}
