package com.enigma.gold.market.repository;

import com.enigma.gold.market.entity.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<EntityProduct, String> {
}
