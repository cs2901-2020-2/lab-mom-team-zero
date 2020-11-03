package cslab.publisher;

import cslab.publisher.controller.PublisherController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @ContextConfiguration(classes=PublisherApplication.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers=PublisherController.class)
class PublisherApplicationTests {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Test
    public void sendMessageSuccessTest() throws Exception {
        this.mockMvc.perform(post("/publish/message/test")).andExpect(status().isOk());
    }


//    @Test
//    public void sendMessageSuccessTest() throws URISyntaxException {
//        final String baseUrl = "http://localgost:8080/message";
//        URI uri = new URI(baseUrl);
//
//        HttpHeaders header = new HttpHeaders();
//        header.set("X-COM-PERSIST", "true");
//
//        HttpEntity<String> request = new HttpEntity<String>("message1", header);
//
//        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//
//        Assertions.assertEquals(201, result.getStatusCodeValue());
//    }
}
