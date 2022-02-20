package web;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void homepage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("homepage");

    }

    @Test
    public void addressBookEmpty() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/book",
                String.class)).contains("No Buddies");

    }

    @Test
    public void addBuddy() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add/b1/a1/p1",
                String.class)).contains("b1");

    }

    @Test
    public void removeBuddy() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add/b1/a1/p1",
                String.class)).contains("b1");

        this.restTemplate.getForObject("http://localhost:" + port + "/delete/2",
                String.class);

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/book",
                String.class)).contains("No Buddies");

    }


}
