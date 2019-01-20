package com.example.one.code;

import com.example.one.util.MockMvcUtil;
import com.example.one.web.UserController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class WebControllerTest {

    /*@Test
    public void userTest() throws Exception {
        MockMvcUtil.printMockMvcListByPost(MockMvcUtil.getMockMvc(new UserController()),"/getUser");
    }*/

   /* @Test
    public void userListTest() throws Exception {
        MockMvcUtil.printMockMvcListByPost(MockMvcUtil.getMockMvc(new UserController()),"/getUserList");
    }*/

    @Test
    public void saveUsers() throws Exception {
        MockMvc mvc = MockMvcUtil.getMockMvc(new UserController());
        mvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name","")
                .param("age","200")
                .param("pass","ceshi"));
    }
}
