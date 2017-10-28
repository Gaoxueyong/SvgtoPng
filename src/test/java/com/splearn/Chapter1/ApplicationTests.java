package com.splearn.Chapter1;


import com.splearn.svgtopng.entity.BlogProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void testApplicationProperties() throws JSONException {

        System.out.println("blogProperties.getName()-->>" + blogProperties.getName());

        System.out.println("blogProperties.getTitle()-->>" + blogProperties.getTitle());

        Assert.assertEquals(blogProperties.getName(), "程序猿DD");

        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");


        JSONObject json = new JSONObject();
        json.put("age",45);
        System.out.println(json.get("age"));





    }


}
