package org.example.transaction;

import lombok.AllArgsConstructor;
import org.example.transaction.entities.InventoryEntity;
import org.example.transaction.service.InventoryAndShipmentService;
import org.example.transaction.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final InventoryAndShipmentService inventoryAndShipmentService;

    @GetMapping("/inventory")
    public List<InventoryEntity> getInventory() {
        return inventoryAndShipmentService.getAll();
    }

    @PostMapping("/place-order")
    public void placeOrder() {
        productService.placeOrder();
    }
}
