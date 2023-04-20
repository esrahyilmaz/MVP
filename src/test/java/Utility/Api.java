package Utility;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Api extends BaseClass {
    DatabaseClass databaseClass = new DatabaseClass();
    public static String cookie = "";

    public String tokenforPeopleSearchPage() throws JSONException {
        String sponsor = URL.replaceAll("^(.*?)=", "");
        String requestURL = URL.replaceAll("/([^/]*)$", "");

        //RestAssured.baseURI = "https://qcsa.fadv.net";
        RestAssured.baseURI = requestURL;
        RequestSpecification request = given();
        JSONObject requestParams = new JSONObject();
             requestParams.put("username", userName);
             requestParams.put("password", password);
             requestParams.put("sponsor", sponsor);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post("/api/auth/jwt/issue-token");

        JsonPath jsonPathEvaluator = response.jsonPath();
        String token =  jsonPathEvaluator.get("accessToken");
        return token;
    }

    public void getTotalNumberOfPeopleWithoutFilter(String pageName) throws Exception {
        String token = tokenforPeopleSearchPage();

//        String providerId = "";
//        if (pageName.equalsIgnoreCase("Program Owner")) {
//            providerId = databaseClass.getProviderID();
//        }

        //RestAssured.baseURI = "https://qcsa.fadv.net/api";
        String requestURL = URL.replaceAll("/([^/]*)$", "");
        RestAssured.baseURI = requestURL;
        RestAssured.basePath = "/api/subjects";
        Integer totalNumberWithoutFilter = given()
               .param("size", "30")
               .header("Authorization", "Bearer "+token)
               .contentType(ContentType.JSON)
               .log()
               .all()
               .get()
               .then()
               .extract()
               .path("totalElements");
        peopleSearchWithoutFilter = totalNumberWithoutFilter.toString();
        System.out.println("Total Number is: " + peopleSearchWithoutFilter);
    }

    public void getTotalNumberOfPeopleWithFilter(String filter, String pageName) throws Exception {
        String token = tokenforPeopleSearchPage();

        String providerId = "";
//        if (pageName.equalsIgnoreCase("Program Owner")) {
//            providerId = databaseClass.getProviderID();
//        }
        String size = "30";
        String individualStatus = "";
        String complianceStatus = "";

          if (filter.equalsIgnoreCase("Active"))
                individualStatus = "610";
          else if (filter.equalsIgnoreCase("Inactive"))
                individualStatus = "630";
          else if (filter.equalsIgnoreCase("Terminated"))
              individualStatus = "650";
          else if (filter.equalsIgnoreCase("Compliant"))
              complianceStatus = "400";
          else if (filter.equalsIgnoreCase("Non-Compliant"))
              complianceStatus = "401";
          else if (filter.equalsIgnoreCase("Pending"))
              complianceStatus = "403";
          else if (filter.equalsIgnoreCase("Needs Review"))
              complianceStatus = "404";
          else if (filter.equalsIgnoreCase("Completed"))
              complianceStatus = "400,401";
          else if (filter.equalsIgnoreCase("Provider Name")){
              providerId = databaseClass.getProviderID();
          }

        //RestAssured.baseURI = "https://qcsa.fadv.net/api";
        String requestURL = URL.replaceAll("/([^/]*)$", "");
        RestAssured.baseURI = requestURL;
        RestAssured.basePath = "api/subjects";

        Integer totalNumberWithFilter = given()
                .param("size", size)
                .param("individualStatus", individualStatus)
                .param("complianceStatus", complianceStatus)
                .param("providerId", providerId)
                .header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get()
                .then()
                .extract()
                .path("totalElements");
        peopleSearchWithFilter = totalNumberWithFilter.toString();
        System.out.println("Total Number is: " + peopleSearchWithFilter);
    }
    public void getTotalNumberOfPeopleWithFilter(String status,String filter, String pageName) throws Exception {
        String token = tokenforPeopleSearchPage();

        String providerId = "";
//        if (pageName.equalsIgnoreCase("Program Owner")) {
//            providerId = databaseClass.getProviderID();
//        }
        String size = "1";
        String individualStatus = "";
        String complianceStatus = "";

        if (status.equalsIgnoreCase("Active"))
            individualStatus = "610";
        else if (status.equalsIgnoreCase("Inactive"))
            individualStatus = "630";
        else if (status.equalsIgnoreCase("Terminated"))
            individualStatus = "650";
        else if (status.equalsIgnoreCase("Compliant"))
            complianceStatus = "400";
        else if (status.equalsIgnoreCase("Non-Compliant"))
            complianceStatus = "401";
        else if (status.equalsIgnoreCase("Pending"))
            complianceStatus = "403";
        else if (status.equalsIgnoreCase("Needs Review"))
            complianceStatus = "404";
        else if (status.equalsIgnoreCase("Completed"))
            complianceStatus = "400,401";
        if (filter.equalsIgnoreCase("Provider Name")){
            providerId = databaseClass.getProviderID();
        }

        //RestAssured.baseURI = "https://qcsa.fadv.net/api";
        String requestURL = URL.replaceAll("/([^/]*)$", "");
        RestAssured.baseURI = requestURL;
        RestAssured.basePath = "api/subjects";

        Integer totalNumberWithFilter = given()
                .param("page", 0)
                .param("size", size)
                .param("providerId", providerId)
                .param("individualStatus", individualStatus)
//                .param("complianceStatus", complianceStatus)
                .header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON)
                .body("")
                .log()
                .all()
                .get()
                .then().assertThat().statusCode(200)
                .extract()
                .path("totalElements");
        peopleSearchWithFilter = totalNumberWithFilter.toString();
        System.out.println("Total Number is: " + peopleSearchWithFilter);
    }

    public String getAdminToolCookies() throws Exception {
        String requestURL = "https://qcsa-admin.fadv.net/veva_User/login";

        if (requestURL.contains("qcsa")) {
            DB = "QCSA";
        } else if (requestURL.contains("qcsb")) {
            DB = "QCSB";
        } else if (requestURL.contains("uaxtdforce")) {
            DB = "UAT";
        }

        RestAssured.baseURI = requestURL;
        Response response =
                given()
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "admin33")
                    .formParam("password", "Password123")
                .when()
                    .post()
                .then()
                    .extract()
                    .response();

        List<String> allValue1 = response.getHeaders().getValues("set-cookie");
        for (String value : allValue1) {
            String valueRegex = value.replaceAll("(?<=;).*", "");
            cookie = cookie + valueRegex + " ";
        }
        adminToolCookies =  cookie.substring(0, cookie.length() - 2);
//        System.out.println("Admin Tool AdminToolCookiesQCSA: " + adminToolCookies);
        return adminToolCookies;
    }

    public void setAdminToolProperty(String property, String value, String custID) throws Exception {
        String cookies = getAdminToolCookies();
        String propertyID = databaseClass.getPropertyID(custID, property);
        String requestURL = "https://qcsa-admin.fadv.net";
        RestAssured.baseURI = requestURL;
        Response response =
                given()
                    .contentType("application/x-www-form-urlencoded")
                    .cookie(cookies)
                    .formParam("id", propertyID)
                    .formParam("CUST.id", custID)
                    .formParam("VCP_KEY", property)
                    .formParam("VCP_VALUE", value)
                    .formParam("_action_update", "Update+Property")
                .when()
                    .post("veva_Cust_Property/save")
                .then()
                    .extract()
                    .response();
    }

    public void getDataForUser(String value) throws Exception {
        String token = tokenforPeopleSearchPage();
        String responseValue = "";
        String requestURL = URL.replaceAll("/([^/]*)$", "");
        RestAssured.baseURI = requestURL;

        if (value.equalsIgnoreCase("Cust_ID"))
            responseValue = "sponsorId";
        else
            responseValue = "entityId";

        Integer response = given()
                .header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON)
                .get("api/user/current")
                .then()
                .extract()
                .path(responseValue);
        System.out.println("Response Value is: " + response);

        if (value.equalsIgnoreCase("Cust_ID"))
            CustID = response.toString();
        else
            VendorID = response.toString();

        System.out.println("CustID: " + CustID);
        System.out.println("VendorID: " + VendorID);
    }

    /**
     * @author prsatomi
     * Gets total number of stauts in question displayed on the Dashboard Page
     * @throws Exception
     * @param personStatus -to discern which status is going to be returned, options are: "needsReview", "nonCompliant",
     * "compliant","inProgress"
     */
    public void getDasboardResults(String personStatus) throws Exception {
        String token = tokenforPeopleSearchPage();
        //RestAssured.baseURI = "https://qcsa.fadv.net/api";
        String requestURL = URL.replaceAll("/([^/]*)$", "");
        System.out.println(requestURL);
        RestAssured.baseURI = requestURL;
        RestAssured.basePath = "api/dashboard/manage-people/stats";

        Integer totalNumberWithFilter = given()
                .header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get()
                .then()
                .extract()
                .path(personStatus);
        peopleSearchWithFilter = totalNumberWithFilter.toString();
        logStepInfo("Total Number is: " + peopleSearchWithFilter);
        if (peopleSearchWithFilter!=null) {
            reportLog(Status.PASS, "Total Number is: " + peopleSearchWithFilter, false);
        }else{
            logStepInfo("Total Number is null");
            reportLog(Status.INFO, "Total Number is null", false);
        }
    }
}
