package me.jdragon.toy.tistory;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java8.Pa;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/26.
 * @project toy
 * @description
 */
public class PayTest {

  private PayRepository payRepository = new FakePayRepository();
  private PayCalculator payCalculator = new StubPayRepository();
  private PayService payService;

  @BeforeEach
  void setUp() {
    //payService = new PayService(payRepository, payCalculator);
    PayInfo payInfo = new PayInfo(100L, 100_000);
    payRepository.savePay(payInfo);

    payService = new PayService(payRepository, payCalculator);
  }

  @Test
  public void given_purchase_no_get_pay_info() {
    Long purchase_no = 100L;
    PayInfo payInfo = payRepository.getPayInfo(purchase_no);
    assertThat(payInfo.getPurchase_no()).isEqualTo(100L);
    assertThat(payInfo.getPayAmount()).isEqualTo(100_000);
  }

  @Test
  public void given_pay_info_calculate_pay_total_price() {
    PayInfo payInfo = new PayInfo(100L,100_000);
    Integer calculate = payCalculator.calculate(payInfo);
    assertThat(calculate).isEqualTo(150_000);
  }

  @Test
  public void test3() {
    Long purchase_no = 100L;
    Integer calculateTotalPurchaseAmount = payService.calculateTotalPurchaseAmount(purchase_no);
    assertThat(calculateTotalPurchaseAmount).isEqualTo(150_000);
  }

  private class FakePayRepository implements PayRepository {

    private Map<Long, PayInfo> payMap = new HashMap<>();

    @Override
    public void savePay(PayInfo payInfo) {
      payMap.put(payInfo.getPurchase_no() , payInfo);
    }

    @Override
    public PayInfo getPayInfo(Long purchase_no) {
      return payMap.get(purchase_no);
    }
  }

  private class StubPayRepository extends PayCalculator {

    @Override
    public Integer calculate(PayInfo payInfo) {
      return 150_000;
    }
  }
}
