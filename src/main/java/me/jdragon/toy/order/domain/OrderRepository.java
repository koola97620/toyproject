package me.jdragon.toy.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author choijaeyong on 2020/07/23.
 * @project toy
 * @description
 */

public interface OrderRepository extends Repository<Order,Long> {
  Order findById(Long id);
  Order save(Order order);
  Order deleteById(Long id);
}
