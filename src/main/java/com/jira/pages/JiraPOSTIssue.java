package com.jira.pages;

import io.restassured.response.Response;

import com.jira.BaseAPI;
import com.jira.api.EndPoints;

public class JiraPOSTIssue extends BaseAPI {

  public static Response createIssue(String issueBody) {

    String endpoint = EndPoints.CREATE_ISSUE;
    Response response = postRequest(endpoint, issueBody);
    response.then().log().all();

    return response;
  }
}
