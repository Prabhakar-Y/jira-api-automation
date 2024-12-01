package com.jira.pages;

import io.restassured.response.Response;

import com.jira.BaseAPI;
import com.jira.api.EndPoints;

public class JiraGETProjects extends BaseAPI {

  public static Response getProjects(String projectKey) {

    String endpoint = EndPoints.GET_PROJECTS;
    Response response = getRequest(endpoint);
    response.then().log().all();

    return response;
  }
}
