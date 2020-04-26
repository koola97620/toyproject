package me.jdragon.toy.tistory;

import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/04/26.
 * @project toy
 * @description
 */
@Repository
public interface PayRepository {
  void savePay(PayInfo payInfo);
  PayInfo getPayInfo(Long purchase_no);

}
