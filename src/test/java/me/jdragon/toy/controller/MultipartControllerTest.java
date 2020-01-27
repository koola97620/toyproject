package me.jdragon.toy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


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
  private MockMultipartFile mockMultipartFile;


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
    mockMultipartFile = new MockMultipartFile("file","orig",null,"bar".getBytes());

//    mockMultipartFile = new MockMultipartFile("test.txt",
//        new FileInputStream(
//            new File("/Users/choijaeyong/MyWorkspace/toy/src/test/java/me/jdragon/toy/resource/test.txt")));
//    File file = new File("/Users/choijaeyong/MyWorkspace/toy/src/test/java/me/jdragon/toy/resource/test.txt");
//    FileItem fileItem = new DiskFileItem("textfile", Files.probeContentType(file.toPath()),false,file.getName(),(int)file.length(),file.getParentFile());
//    IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
//    MultipartFile multi = new CommonsMultipartFile(fileItem);

  }

  @Test
  public void test() throws Exception {
    String inputJSON = "";

    mockMvc.perform(MockMvcRequestBuilders.multipart("/multipart")
        .file(mockMultipartFile)
    ).andDo(print());


//    mockMvc.perform(post(URI.create("/multipart"))
//        .contentType(MediaType.APPLICATION_JSON)
//        .accept(MediaType.APPLICATION_JSON)
//        .content(multipartFile.getBytes()))
//        .andExpect(status().isOk())
//        .andDo(print())
//        ;

  }


  @Autowired
  private WebApplicationContext wContext;

  @MockBean
  private MultipartController multipartController;

  @BeforeEach
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(wContext)
        .alwaysDo(MockMvcResultHandlers.print())
        .build();
  }
  @Test
  public void testnew() throws Exception {
    // Mock Request
    MockMultipartFile jsonFile = new MockMultipartFile("test.json", "", "application/json", "{\"key1\": \"value1\"}".getBytes());

    Mockito.when(multipartController.multipartTestHandler(Mockito.any(MultipartFile.class))).thenReturn(
        ResponseEntity.ok().build());

    mockMvc.perform(MockMvcRequestBuilders.multipart("/multipart")
        //.file("file", jsonFile.getBytes())
        .file(jsonFile)
        .characterEncoding("UTF-8"))
        .andExpect(status().isOk());

  }

}