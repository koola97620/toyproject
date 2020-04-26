package me.jdragon.toy.tistory;

import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 2020/04/26.
 * @project toy
 * @description
 */

@Service
public class PayService {

  private PayRepository payRepository;
  private PayCalculator payCalculator;

  public PayService(PayRepository payRepository, PayCalculator payCalculator) {
    this.payRepository = payRepository;
    this.payCalculator = payCalculator;
  }

  public Integer calculateTotalPurchaseAmount(Long purchase_no) {
    PayInfo payInfo = payRepository.getPayInfo(purchase_no);
    // calculate
    return payCalculator.calculate(payInfo);
  }

}
