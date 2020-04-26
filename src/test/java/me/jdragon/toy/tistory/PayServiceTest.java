package me.jdragon.toy.tistory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author choijaeyong on 2020/04/26.
 * @project toy
 * @description
 */

@SpringBootTest
public class PayServiceTest {

  @Autowired
  private PayService payService;

  @BeforeEach
  void setUp() {

  }

  @Test
  public void t() {
    Long purchase_no = 111L;
    Integer calculatedPurchaseAmount = payService.calculateTotalPurchaseAmount(purchase_no);
    assertThat(calculatedPurchaseAmount).isEqualTo(10_000);
  }

}
