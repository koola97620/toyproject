package me.jdragon.toy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author choijaeyong on 2020/01/18.
 * @project toy
 * @description
 */

@WebMvcTest(controllers = MultipartController.class)
@AutoConfigureMockMvc
class MultipartControllerTest {

  @Autowired
  private MockMvc mockMvc;
  private MultipartFile multipartFile;

  @MockBean
  private FileConverter fileConverter;

  @BeforeEach
  void setUp() {
    try {
      createMultipartFile();
      printFile();
      // test.txt 출력하는 코드도 작성해보기
    } catch(IOException e) {

    }

  }

  private void printFile() throws IOException {

  }

  private void createMultipartFile() throws IOException {
    multipartFile = new MockMultipartFile("test.txt",
        new FileInputStream(
            new File("/Users/choijaeyong/MyWorkspace/toy/src/test/java/me/jdragon/toy/resource/test.txt")));
  }

  @Test
  public void test() throws Exception {
    String inputJSON = "";

    mockMvc.perform(post(URI.create("/multipart"))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(multipartFile.getBytes()))
        .andExpect(status().isOk())
        .andDo(print())
        ;

  }
}