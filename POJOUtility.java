package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POJOUtility
{	
		public static void CreateJSONObjectFromEmployeeClassObject() throws JsonProcessingException, FileNotFoundException
		{
			String path = "C:\\Users\\Pallavi\\Pictures\\Workspace\\Eclipse_Wrokspace\\RestCucumberFramework\\src\\test\\resources\\data\\PersonalDetails.json";
			File f = new File(path);
			FileReader fr = new FileReader(f);
			JSONObject jo = new JSONObject(fr);
			
			Employee emp1 = new Employee();
			emp1.setFirstName(jo.getJSONObject("Data1").getString("first_name"));
			//emp1.setFirstName(jo.("Data1").getString("id"));
			//emp1.setLastname("Mehra");
			//emp1.setGender("Male");
			//emp1.setAge(35);
			//emp1.setSalary(10000.00);
			System.out.println("Employee value"+emp1);
			
			ObjectMapper objMapper = new ObjectMapper();	
			String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
			RequestSpecification reqSpec = RestAssured.given();
			reqSpec.baseUri("http://httpbin.org/post");
			reqSpec.contentType(ContentType.JSON);
			reqSpec.body(employeeJSON);

			Response response = reqSpec.post();
			response.prettyPrint();
	}

}
