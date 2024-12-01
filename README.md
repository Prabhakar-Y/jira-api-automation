# **JIRA API Test Automation**

This project automates the testing of Jira CRUD APIs using the **Page Object Model (POM)** design pattern.  
It includes test scenarios to validate the API responses.

---

## **Table of Contents**
- [Project Overview](#project-overview)
- [Test Scenarios](#test-scenarios)
- [Project Structure](#project-structure)
- [Setup](#setup-instructions)
- [Running the Tests](#running-the-tests)

---

## **Project Overview**

This automation suite is designed to validate the following:
- **CRUD operations**: GET, POST, PUT resources via API endpoints.
- **Validation of API responses**: Status codes, payloads.
- **Error handling s**.

### **Technologies Used**
- **RestAssured**: 
- **Java**: 
- **TestNG**:
- **Maven**:
- **Page Object Model (POM)**: 

---

## **Test Scenarios**

### **Functional Test Cases**
1. **GET**: Verify fetching the details of an existing issue using a valid issue ID
   - **Expected Result**: API should return a `200 OK` status with the correct issue details in the response

2. **POST**: Verify the creation of a new issue in JIRA with a valid payload
   - **Expected Result**: API should return a `201 Created` status with the issue ID in the response

3. **PUT**: Verify updating an existing issue's fields (Example- summary, description) with valid data
   - **Expected Result**: API should return a `204 No Content` status, and subsequent GET requests should reflect the updates


---

## **Project Structure**

```plaintext
jira-api-automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.jira/
│   │           ├── api/
│   │           │   └── EndPoints.java
│   │           ├── pages/                  # Page Object Model files
│   │           │   ├── JiraGETProjects.java
│   │           │   ├── JiraPostIssue.java
│   │           │   ├── JiraPutIssue.java
│   │           |── BaseAPI.java
│   │           ├── utils/                  
│   │           │   ├── ConfigManager.java     
│   │           │   └── TokenManager.java      
│   │
│   ├── test/
│   │   └── java/
│   │       └── com.jira/
│   │           └── JiraAPITest.java
│   │
│   ├── resources/
│       ├── config.properties               # Configuration file for base URL, credentials, etc.
│       └── log4j.properties                # Logging configuration
│
├── .env                                
├── .gitignore                              
├── pom.xml                                 
├── README.md                               
└── testng.xml                              



## **Setup Instructions**

### Prerequisites
1. **Java** 
2. **Maven** 
3. **TestNG**
4. **Jira API access**

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Prabhakar-Y/jira-api-automation.git
   ```

2. Navigate to the project directory:
  ```
  cd jira-api-automation.git
  ```
3. Install dependencies:
  ```
  nmvn clean install
  ```
## Running the Tests
  
  

```bash
mvn test

mvn test -DsuiteXmlFile=testng.xml

```
