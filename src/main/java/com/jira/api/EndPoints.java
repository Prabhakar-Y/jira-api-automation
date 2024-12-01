package com.jira.api;

public class EndPoints {

  // API endpoints
  public static final String GET_ISSUE = "/rest/api/2/issue/{issueKey}";
  public static final String CREATE_ISSUE = "/rest/api/2/issue";
  public static final String UPDATE_ISSUE = "/rest/api/2/issue/{issueKey}";
  public static final String DELETE_ISSUE = "/rest/api/2/issue/{issueKey}";
  public static final String GET_PROJECTS = "/rest/api/2/project/recent";
  public static final String GET_PROJECT = "/rest/api/2/project/{projectKey}";

}
