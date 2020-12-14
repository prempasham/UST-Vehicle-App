package com.ust.pms.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.pms.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	public List<Product> findByProductName(String productName);
    public List<Product> findByPrice(int price);
    public List<Product> findByPriceGreaterThan(int price);

}
