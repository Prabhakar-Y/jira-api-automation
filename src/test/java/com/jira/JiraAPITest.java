package com.jira;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jira.pages.JiraGETProjects;
import com.jira.pages.JiraPOSTIssue;
import com.jira.pages.JiraPUTIssue;

import org.apache.log4j.Logger;

public class JiraAPITest {

  private static final Logger logger = Logger.getLogger(JiraAPITest.class);

  @BeforeClass
  public void setup() {
    BaseAPI.setup();
  }

  @Test(priority = 1)
  public void testGETProjects() {
    try {
      String projectKey = "EJAA";
      Response getRequestResponse = JiraGETProjects.getProjects(projectKey);
      Assert.assertEquals(getRequestResponse.getStatusCode(), 200, "Status code should be 200");
      logger.info("GET Projects request successful. Status code: " + getRequestResponse.getStatusCode());
    } catch (Exception e) {
      logger.error("Error occurred while fetching projects: " + e.getMessage(), e);
      Assert.fail("GET Projects request failed due to error: " + e.getMessage());
    }
  }

  @Test(priority = 2)
  public void testPOSTIssue() {
    try {
      String postRequestPayloadData = "{\n" +
          "  \"fields\": {\n" +
          "    \"project\": {\n" +
          "      \"key\": \"EJAA\"\n" + // Added - Project Key
          "    },\n" +
          "    \"summary\": \"[API][BUG] Test Issue\",\n" +
          "    \"description\": \"Issue created from API\",\n" +
          "    \"issuetype\": {\n" +
          "      \"name\": \"Task\"\n" +
          "    }\n" +
          "  }\n" +
          "}";
      Response postRequestResponse = JiraPOSTIssue.createIssue(postRequestPayloadData);
      Assert.assertEquals(postRequestResponse.getStatusCode(), 201, "Status code should be 201");
      logger.info("POST Issue request successful. Status code: " + postRequestResponse.getStatusCode());
    } catch (Exception e) {
      logger.error("Error occurred while creating issue: " + e.getMessage(), e);
      Assert.fail("POST Issue request failed due to error: " + e.getMessage());
    }
  }

  @Test(priority = 3)
  public void testPUTIssue() {
    try {
      String putRequestPayloadData = "{\n" +
          "  \"fields\": {\n" +
          "    \"summary\": \"Updated Issue\"\n" +
          "  }\n" +
          "}";
      String putRequestIssueId = "10000"; // replace with actual issue ID
      Response putRequestResponse = JiraPUTIssue.updateIssue(putRequestIssueId, putRequestPayloadData);
      Assert.assertEquals(putRequestResponse.getStatusCode(), 204, "Status code should be 204");
      logger.info("PUT Issue request successful. Status code: " + putRequestResponse.getStatusCode());
    } catch (Exception e) {
      logger.error("Error occurred while updating issue: " + e.getMessage(), e);
      Assert.fail("PUT Issue request failed due to error: " + e.getMessage());
    }
  }
}
