package me.jdragon.toy.tistory;

/**
 * @author choijaeyong on 2020/04/26.
 * @project toy
 * @description
 */
public class PayInfo {

  private final Long purchase_no;
  private final Integer payAmount;

  public PayInfo(Long purchase_no , Integer payAmount) {
    this.purchase_no = purchase_no;
    this.payAmount = payAmount;
  }

  public Long getPurchase_no() {
    return purchase_no;
  }

  public Integer getPayAmount() {
    return payAmount;
  }
}
