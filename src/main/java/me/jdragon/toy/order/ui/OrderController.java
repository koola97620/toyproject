package me.jdragon.toy.order.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 2020/07/28.
 * @project toy
 * @description
 */

@RestController
public class OrderController {

  @GetMapping
  public ResponseEntity placeOrder() {

    return null;
  }

}
