import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITest {
    private static CloseableHttpClient httpClient;

    @BeforeAll
    public static void setUp() {
        httpClient = HttpClients.createDefault();
    }

    @AfterAll
    public static void tearDown() throws IOException {
        httpClient.close();
    }

    @Test
    public void testPut() throws IOException {
        HttpPut httpPut = new HttpPut("https://postman-echo.com/put");
        try (CloseableHttpResponse response = httpClient.execute(httpPut)) {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void testPostRawText() throws IOException {
        HttpPost httpPost = new HttpPost("https://postman-echo.com/post");

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testPostFormData() throws IOException {
        HttpPost httpPost = new HttpPost("https://postman-echo.com/post");
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testPatch() throws IOException {
        HttpPatch httpPatch = new HttpPatch("https://postman-echo.com/patch");
        try (CloseableHttpResponse response = httpClient.execute(httpPatch)) {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testGet() throws IOException {
        HttpGet httpGet = new HttpGet("https://postman-echo.com/get");
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testDelete() throws IOException {
        HttpDelete httpDelete = new HttpDelete("https://postman-echo.com/delete");
        try (CloseableHttpResponse response = httpClient.execute(httpDelete)) {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }
}
