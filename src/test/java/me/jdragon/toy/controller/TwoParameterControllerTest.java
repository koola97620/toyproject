package me.jdragon.toy.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author choijaeyong on 2020/01/26.
 * @project toy
 * @description
 */

@WebMvcTest(controllers = MultipartController.class)
@AutoConfigureMockMvc
class TwoParameterControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void given_two_parameters() throws Exception {
    RequestDTO requestDTO = new RequestDTO();
    requestDTO.setAge(100);
    requestDTO.setName("haha");

    mockMvc.perform(post(URI.create("two"))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
      .characterEncoding("utf-8")
      .content(objectMapper.writeValueAsBytes(requestDTO))
//        .content("str")
    )
      .andDo(print())
    ;
  }

}