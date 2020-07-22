package me.jdragon.toy.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author choijaeyong on 2020/07/23.
 * @project toy
 * @description
 */
public interface OrderRepository extends JpaRepository<Long,Order> {
  Order findById(Long id);
  Order save(Order order);
  Order deleteById(Long id);
}
