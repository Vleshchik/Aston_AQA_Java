import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {
    @Test
    public void testPut() {
        given()
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("status", equalTo(null));
    }

    @Test
    public void testPostRawText() {
        given()
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(500)
                .body("status", equalTo(null));
    }

    @Test
    public void testPostFormData() {
        given()
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(500)
                .body("status", equalTo(null));
    }

    @Test
    public void testPatch() {
        given()
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("status", equalTo(null));
    }

    @Test
    public void testGet() {
        given()
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .body("status", equalTo(null));
    }

    @Test
    public void testDelete() {
        given()
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("status", equalTo(null));
    }
}