package Utility;

import constants.AdminToolHeaders;
import constants.AdminToolURI;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class AdminToolApiQCSA {
    private String cookie;
    public AdminToolApiQCSA() {
        String cookies="";
        Response response=given().
                get(AdminToolURI.COOKIES_URI.toString()).
                then().log().all().
                assertThat().statusCode(200).
                extract().response();
        Headers headers=response.getHeaders();
        for (Header header:
                headers) {
            if (header.getName().contains("cookie")){
                cookies+=header.getValue().split(" ")[0]+" ";
            }
        }
        this.cookie=cookies;
    }
    public void getAdminToolPage()  {
        //TODO implement property delimiter class
            RequestSpecification request = RestAssured.given().log().all()
                    .header("cookie", cookie);
            request.get(AdminToolURI.BASE_URI.toString())
                    .then().assertThat().statusCode(200);

    }
    //todo See how this can be done better
    public void getCustomers()  {
    //TODO implement property delimiter class
        try {
        RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
                .formParam("username", PropertyFileReader.getProperty("QSCAAdminToolUserName"))
                .formParam("password", PropertyFileReader.getProperty("QSCAAdminToolPassword"))
//                .header("cookie", cookie)
                .header("cookie", cookie)
                .header("user-agent", AdminToolHeaders.USER_AGENT)
                .header("Host", AdminToolHeaders.HOST);
            request.get(AdminToolURI.LOGIN_URI.toString())
                    .then().assertThat().statusCode(200).log().all()
                    .extract()
                .response()
                .htmlPath().prettyPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
//                .extract()
//                .response()
//                .htmlPath().prettyPrint();
//        System.out.println(path);
    }
    public void postLogin()  {
        //TODO implement property delimiter class
        try {
            RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
                            .encoderConfig(EncoderConfig.encoderConfig()
                                    .encodeContentTypeAs("x-www-form-urlencoded",
                                            ContentType.URLENC)))
                    .contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
                    .formParam("username", PropertyFileReader.getProperty("QSCAAdminToolUserName"))
                    .formParam("password", PropertyFileReader.getProperty("QSCAAdminToolPassword"))
//                .header("cookie", cookie)
                    .header("cookie", cookie)
                    .header("user-agent", AdminToolHeaders.USER_AGENT)
                    .header("Host", AdminToolHeaders.HOST);
            request.post(AdminToolURI.POSTLOGIN_URI.toString())
                    .then().log().all().assertThat().statusCode(302)
                    .extract()
                    .response()
                    .htmlPath().prettyPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
//                .extract()
//                .response()
//                .htmlPath().prettyPrint();
//        System.out.println(path);
    }

    //todo See how this can be done better
    public void updateAdminToolProperty(String id, String custId, String propertyKey, String propertyValue) {
        RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
                .formParam("id", id)
                .formParam("CUST.id", custId)
                .formParam("VCP_KEY", propertyKey)
                .formParam("VCP_VALUE", propertyValue)
                .formParam("_action_update", AdminToolHeaders.ACTION_UPDATE)
                .header("cookie", cookie)
                .header("Host", AdminToolHeaders.HOST);
        request.post(AdminToolURI.UPDATE_URI.toString())
                .then().log().all().assertThat().statusCode(302);
    }
    //todo method for extracting headers by key value
    public String getCookesAdminToolQcsa(){
        String cookies="";
        Response response=given().
                get(AdminToolURI.COOKIES_URI.toString()).
                then().log().all().
                assertThat().statusCode(200).
                extract().response();
        Headers headers=response.getHeaders();
        for (Header header:
                headers) {
            if (header.getName().contains("cookie")){
                cookies+=header.getValue().split(" ")[0]+" ";
            }
        }
        return cookies;
    }
}
