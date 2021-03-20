import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BitcoinResourceTest {

    /**
     * Faz a request na página http://localhost:8080/bitcoins
     */
    @Test
    public void statusCodeResquestEquals200() {
        RestAssured
                .given()
                .get("bitcoins")
                .then()
                .statusCode(200);
    }
}