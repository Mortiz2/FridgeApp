package com.krzpro.fridgeapp.repository;

import com.krzpro.fridgeapp.model.FridgeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeItemRepository extends JpaRepository<FridgeItem, Long> {

}
