package Test_Cases;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Tests {
	
	@Test
	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://localhost:3000/api";
		
		// Scenario 1: Dashboard Retrieval
		Response dashboardResponse = given()
				.header("Authorization", "Bearer your_access_token")
				.get("/api/dashboards");
		System.out.println("Dashboard Response Code: " + dashboardResponse.getStatusCode());
		System.out.println("Dashboard Response Body: " + dashboardResponse.getBody().asString());
		
		// Scenario 2: Dashboard Creation via API
		String requestBody = "{ \"name\": \"New Dashboard\" }";
        Response createDashboardResponse = given()
            .header("Authorization", "Bearer your_access_token")
            .contentType("application/json")
            .body(requestBody)
            .post("/api/dashboards");
        System.out.println("Create Dashboard Response Code: " + createDashboardResponse.getStatusCode());
        System.out.println("Create Dashboard Response Body: " + createDashboardResponse.getBody().asString());
        
        // Scenario 3: Dashboard Update via API
        Response updateDashboardResponse = given()
            .header("Authorization", "Bearer your_access_token")
            .contentType("application/json")
            .body("{ \"name\": \"Updated Dashboard\" }")
            .put("/api/dashboards/123");
        System.out.println("Update Dashboard Response Code: " + updateDashboardResponse.getStatusCode());

        // Scenario 4: Dashboard Deletion via API
        Response deleteDashboardResponse = given()
            .header("Authorization", "Bearer your_access_token")
            .delete("/api/dashboards/123");
        System.out.println("Delete Dashboard Response Code: " + deleteDashboardResponse.getStatusCode());

        // Scenario 5: Visualization Data Retrieval
        Response visualizationDataResponse = given()
            .header("Authorization", "Bearer your_access_token")
            .get("/api/visualization-data");
        System.out.println("Visualization Data Response Code: " + visualizationDataResponse.getStatusCode());
        System.out.println("Visualization Data Response Body: " + visualizationDataResponse.getBody().asString());
	}
}