package com.tw.apistackbase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void should_return_expected_all_employees_when_call_get_all_employees() throws Exception {
//        when()
//        mockMvc.perform(get("/employees"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(content().json("[\n" +
//                        "{\n" +
//                        "    \"id\": 1,\n" +
//                        "    \"name\": \"sally\",\n" +
//                        "    \"age\": 22,\n" +
//                        "    \"gender\": \"Male\"\n" +
//                        "}"+
//                        "]"));
//    }

    @Test
    public void should_return_expected_employees_when_call_add_employees() throws Exception {
        mockMvc.perform(post("/employees").content("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"sally\",\n" +
                "    \"age\": 22,\n" +
                "    \"gender\": \"Male\"\n" +
                "}").contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"sally\",\n" +
                        "    \"age\": 22,\n" +
                        "    \"gender\": \"Male\"\n" +
                        "}"));
    }
}