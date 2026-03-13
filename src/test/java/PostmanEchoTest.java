import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void getRequestTest(){
        given().baseUri("https://postman-echo.com")
                .when()
                .queryParam("foo1","bar1")//.queryParam("foo2","bar2")
                .get("/get?foo2=bar2")
                .then().log().body()
                .assertThat().statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.accept", equalTo("*/*"))
                //.body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
    @Test
    public void postRawText(){
        String bodyJson = "{\n   \"test\": \"value\" \n}";
        given().baseUri("https://postman-echo.com").log().body()
                .contentType("text/plain").body(bodyJson)
                .when().post("/post")
                .then().log().body()
                .assertThat().statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo("{\n   \"test\": \"value\" \n}"))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("23"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.accept", equalTo("*/*"))
                .body("content-type", equalTo("text/plain"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void postFormData(){
        given().baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1","bar1").formParam("foo2","bar2")
                //.contentType("multipart/form-data").multiPart("foo1","bar1").multiPart("foo2","bar2")
                .when().post("/post")
                .then().log().body()
                .assertThat().statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(""))
                .body("files.size()", equalTo(0))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.accept", equalTo("*/*"))
                //.body("content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

}
