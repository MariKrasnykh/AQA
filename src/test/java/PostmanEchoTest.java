import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    RequestSpecification requestSpecification = given().baseUri("https://postman-echo.com");
    ResponseSpecification responseSpecification = expect()
            .statusCode(200)
            .body("args.size()", equalTo(0))
            .body("files.size()", equalTo(0))
            .body("form.size()", equalTo(0))
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.accept-encoding", equalTo("gzip, br"))
            .body("headers.x-forwarded-proto", equalTo("https"))
            .body("headers.accept", equalTo("*/*"))
            //.body("content-type", equalTo("text/plain"))
            .body("json", equalTo(null));


    @Test
    public void getRequestTest(){
        requestSpecification
                .when()
                .queryParam("foo1","bar1")//.queryParam("foo2","bar2")
                .get("/get?foo2=bar2")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("args.foo1", equalTo("bar1"),"args.foo2", equalTo("bar2"),
                        "headers.host", equalTo("postman-echo.com"),
                        "headers.accept-encoding", equalTo("gzip, br"),
                        "headers.x-forwarded-proto", equalTo("https"),
                        "headers.accept", equalTo("*/*"),
                        "url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
                //.body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"));
    }
    @Test
    public void postRawText(){
        String bodyJson = "{\n   \"test\": \"value\" \n}";
        requestSpecification.log().body()
                .contentType("text/plain").body(bodyJson)
                .expect().spec(responseSpecification)
                .when().post("/post")
                .then().log().body()
                .body("data", equalTo("{\n   \"test\": \"value\" \n}"))
                .body("headers.content-length", equalTo("23"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void postFormData(){
        requestSpecification
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1","bar1").formParam("foo2","bar2")
                //.contentType("multipart/form-data").multiPart("foo1","bar1").multiPart("foo2","bar2")
                .when().post("/post")
                .then().log().body()
                .assertThat().statusCode(200)
                .body("data", equalTo(""),
                "files.size()", equalTo(0),
                        "form.foo1", equalTo("bar1"),
                        "form.foo2", equalTo("bar2"),
                        "headers.host", equalTo("postman-echo.com"),
                        "headers.content-length", equalTo("19"),
                        "headers.accept-encoding", equalTo("gzip, br"),
                        "headers.x-forwarded-proto", equalTo("https"),
                        "headers.accept", equalTo("*/*"),
                        //"content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"),
                        "json.foo1", equalTo("bar1"),
                        "json.foo2", equalTo("bar2"),
                        "url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void putRequest(){
       requestSpecification.log().body()
                .contentType("text/plain").body("This is expected to be sent back as part of response body.")
                .expect().spec(responseSpecification)
                .when().put("/put")
                .then().log().body()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.content-length", equalTo("58"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
    @Test
    public void patchRequest(){
        requestSpecification.log().body()
                .contentType("text/plain").body("This is expected to be sent back as part of response body.")
                .expect().spec(responseSpecification)
                .when().patch("/patch")
                .then().log().body()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.content-length", equalTo("58"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
    @Test
    public void deleteRequest(){
        requestSpecification.log().body()
                .contentType("text/plain").body("This is expected to be sent back as part of response body.")
                .expect().spec(responseSpecification)
                .when().delete("/delete")
                .then().log().body()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.content-length", equalTo("58"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
