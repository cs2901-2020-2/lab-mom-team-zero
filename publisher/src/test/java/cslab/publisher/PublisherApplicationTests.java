package cslab.publisher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class PublisherApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sendMessageSuccessTest() throws URISyntaxException {
        final String baseUrl = "http://localgost:8080/message";
        URI uri = new URI(baseUrl);

        HttpHeaders header = new HttpHeaders();
        header.set("X-COM-PERSIST", "true");

        HttpEntity<String> request = new HttpEntity<String>("message1", header);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Assertions.assertEquals(201, result.getStatusCodeValue());
    }
}
