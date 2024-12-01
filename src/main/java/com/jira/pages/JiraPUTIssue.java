package com.jira.pages;

import io.restassured.response.Response;

import com.jira.BaseAPI;
import com.jira.api.EndPoints;

public class JiraPUTIssue extends BaseAPI {

  public static Response updateIssue(String issueId, String updatedBody) {

    String endpoint = EndPoints.UPDATE_ISSUE.replace("{issueKey}", issueId);
    Response response = putRequest(endpoint, updatedBody);
    response.then().log().all();

    return response;
  }
}
