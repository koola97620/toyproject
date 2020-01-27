package me.jdragon.toy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author choijaeyong on 2020/01/18.
 * @project toy
 * @description
 */

@RestController
public class MultipartController {

  @PostMapping("/multipart")
  public ResponseEntity multipartTestHandler(MultipartFile multipartFile) throws Exception {

    // multipartfile 을 여기서 가공한다 치고!
    FileConverter fileConverter = new FileConverter();
    System.out.println("=====================================");
    System.out.println(multipartFile.getName());
    List<Map<Integer,Object>> result = fileConverter.convert(multipartFile.getInputStream());

    return ResponseEntity.ok().body(result);
  }

  @PostMapping("/two")
  public ResponseEntity postTwoParameter(@RequestBody RequestDTO requestDTO, String str, Integer num) {

    System.out.println(requestDTO.getName());
    System.out.println(requestDTO.getAge());
    System.out.println(str);

    return ResponseEntity.ok().build();

  }

  @GetMapping("/twoget")
  public ResponseEntity getTwoParameter(@RequestBody RequestDTO requestDTO, @RequestParam(name = "str") String str, Integer num) {

    System.out.println(requestDTO.getName());
    System.out.println(requestDTO.getAge());
    System.out.println(str);

    return ResponseEntity.ok().build();

  }

}
