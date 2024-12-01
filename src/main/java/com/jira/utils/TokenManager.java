package com.jira.utils;

import com.jira.BaseAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenManager {

  private static String xsrfToken;

  public static String getXSRFToken() {
    if (xsrfToken == null) {
      fetchXSRFToken();
    }
    return xsrfToken;
  }

  private static void fetchXSRFToken() {
    RestAssured.baseURI = ConfigManager.getProperty("baseURI");

    Response response = RestAssured.given()
        .header("Authorization", "Basic " + BaseAPI.authHeader)
        .when()
        .get("/rest/api/2/");

    xsrfToken = response.getCookie("atlassian.xsrf.token");
  }

}
