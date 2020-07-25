package me.jdragon.toy.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author choijaeyong on 2020/07/25.
 * @project toy
 * @description
 */


public interface ProductRepository extends Repository<Product,Integer> {
  Product findById(Integer id);
  Product save(Product product);
  Product deleteById(Integer id);

}
