package me.jdragon.toy.order.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import org.springframework.data.annotation.Id;

/**
 * @author choijaeyong on 2020/07/16.
 * @project toy
 * @description
 */
@Getter
@Entity
@Table
public class Order {

  @Id
  private Long id;

}
