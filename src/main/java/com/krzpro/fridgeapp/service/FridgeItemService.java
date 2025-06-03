package com.krzpro.fridgeapp.service;

import com.krzpro.fridgeapp.model.FridgeItem;
import com.krzpro.fridgeapp.model.Product;
import com.krzpro.fridgeapp.repository.FridgeItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FridgeItemService {

    private final FridgeItemRepository repository;

    public FridgeItemService(FridgeItemRepository repository) {
        this.repository = repository;
    }

    public FridgeItem save(FridgeItem item) {
        return repository.save(item);
    }

    public List<FridgeItem> findAll() {
        return repository.findAll();
    }

    public Optional<FridgeItem> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
