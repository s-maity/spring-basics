package org.example.transaction.service;

import lombok.AllArgsConstructor;
import org.example.transaction.entities.InventoryEntity;
import org.example.transaction.entities.OrderEntity;
import org.example.transaction.entities.ShipmentEntity;
import org.example.transaction.respositories.InventoryJPARepository;
import org.example.transaction.respositories.ShipmentJPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryAndShipmentService {
    private final InventoryJPARepository inventoryJPARepository;
    private final ShipmentJPARepository shipmentJPARepository;


    @Transactional
    public void updateInventoryAndShipment(OrderEntity order) {
        var inventory = inventoryJPARepository.findByProductId(order.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        int productQuantity = inventory.getQuantity();

        if (productQuantity < order.getQuantity()) {
            throw new RuntimeException("Inventory out of stock");
        }

        productQuantity = productQuantity - order.getQuantity();

        inventory.setQuantity(productQuantity);
        inventoryJPARepository.save(inventory);
        var shipment = ShipmentEntity.builder()
                .orderId(order.getOrderId())
                .build();
        shipmentJPARepository.save(shipment);
    }

    public List<InventoryEntity> getAll() {
        return inventoryJPARepository.findAll();
    }
}
