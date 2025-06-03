package com.krzpro.fridgeapp.controller;

import com.krzpro.fridgeapp.model.FridgeItem;
import com.krzpro.fridgeapp.service.FridgeItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fridgeitem")
public class FridgeItemController {

    private final FridgeItemService fridgeItemService;

    public FridgeItemController(FridgeItemService fridgeItemService) {
        this.fridgeItemService = fridgeItemService;
    }

    @GetMapping
    public ResponseEntity<List<FridgeItem>> getAllFridgeItems() {
        List<FridgeItem> items = fridgeItemService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FridgeItem> getFridgeItemById(@PathVariable Long id) {
        Optional<FridgeItem> item = fridgeItemService.findById(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FridgeItem> createFridgeItem(@RequestBody FridgeItem fridgeItem) {
        FridgeItem savedItem = fridgeItemService.save(fridgeItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FridgeItem> updateFridgeItem(@PathVariable Long id, @RequestBody FridgeItem updatedFridgeItem) {
        Optional<FridgeItem> existingItem = fridgeItemService.findById(id);

        if (existingItem.isPresent()) {
            updatedFridgeItem.setId(id);
            FridgeItem savedItem = fridgeItemService.save(updatedFridgeItem);
            return ResponseEntity.ok(savedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFridgeItem(@PathVariable Long id) {
        Optional<FridgeItem> existingItem = fridgeItemService.findById(id);

        if (existingItem.isPresent()) {
            fridgeItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
