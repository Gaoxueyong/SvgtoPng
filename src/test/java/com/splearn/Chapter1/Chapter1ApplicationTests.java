package com.splearn.Chapter1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;





@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter1ApplicationTests {



    private MockMvc mvc;
    @Autowired
    private TestRestTemplate restTemplate;
    @Before
    public  void setup() throws  Exception{

    }

	@Test
	public void contextLoads() {

        String body = this.restTemplate.getForObject("/hello", String.class);
        assertThat(body).isEqualTo("Hello World");

    }

}
