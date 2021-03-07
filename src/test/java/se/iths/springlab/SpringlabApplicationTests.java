package se.iths.springlab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import se.iths.springlab.dto.FootBallPlayerDto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

class SpringlabApplicationTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application.xml");
        var result = restTemplate.getForEntity("http://localhost:" + port + "/footballplayers", FootBallPlayerDto[].class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertTrue(result.hasBody());
        assertThat(result.getBody().length).isGreaterThan(0);
        assertThat(result.getBody().length).isEqualTo(3);
        System.out.println("1: FIRST: " + Arrays.stream(result.getBody()).findFirst().get().getFirstName());
    }




}
