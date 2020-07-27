package me.jdragon.toy.order.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import me.jdragon.toy.product.domain.Product;
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
  private Orderer orderer;
  private Integer productId;
  private LocalDateTime orderDate;
  private List<Product> productList;

}
