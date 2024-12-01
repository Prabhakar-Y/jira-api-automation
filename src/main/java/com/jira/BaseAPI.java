package com.jira;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.jira.utils.TokenManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseAPI {

  public static String baseUrl;
  public static String authHeader;

  static {
    Properties properties = new Properties();
    try (InputStream inputStream = BaseAPI.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (inputStream == null) {
        throw new IllegalStateException("Config.properties not found in classpath");
      }
      properties.load(inputStream);

      baseUrl = properties.getProperty("jira.url");
      if (baseUrl == null || baseUrl.isEmpty()) {
        throw new IllegalStateException("BaseUrl cannot be null or empty. Please check your config.");
      }

      authHeader = "Basic " + System.getenv("JIRA_API_TOKEN");

      if (authHeader == null || authHeader.isEmpty()) {
        throw new IllegalStateException("JIRA_API_TOKEN environment variable is missing.");
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Error loading config.properties: " + e.getMessage(), e);
    }
  }

  // RestAssured base URI
  public static void setup() {
    if (baseUrl == null || baseUrl.isEmpty()) {
      throw new IllegalStateException("BaseUrl cannot be null or empty. Please check your config.");
    }
    RestAssured.baseURI = baseUrl;
  }

  // GET request
  public static Response getRequest(String endpoint) {
    return RestAssured.given()
        .header("Authorization", authHeader)
        .header("X-Atlassian-Token", TokenManager.getXSRFToken())
        .when()
        .get(endpoint);
  }

  // POST request
  public static Response postRequest(String endpoint, String body) {
    return RestAssured.given()
        .header("Authorization", authHeader)
        .header("Content-Type", "application/json")
        .header("X-Atlassian-Token", TokenManager.getXSRFToken())
        .body(body)
        .when()
        .post(endpoint);
  }

  // PUT request
  public static Response putRequest(String endpoint, String body) {
    return RestAssured.given()
        .header("Authorization", authHeader)
        .header("Content-Type", "application/json")
        .header("X-Atlassian-Token", TokenManager.getXSRFToken())
        .body(body)
        .when()
        .put(endpoint);
  }
}
