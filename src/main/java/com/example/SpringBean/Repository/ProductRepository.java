package com.example.SpringBean.Repository;

import com.example.SpringBean.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
