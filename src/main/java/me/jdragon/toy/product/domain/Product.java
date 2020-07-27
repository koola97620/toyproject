package me.jdragon.toy.product.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

/**
 * @author choijaeyong on 2020/07/24.
 * @project toy
 * @description
 */

@Getter
public class Product {
  @Id
  private Integer id;
  private String name;


}
