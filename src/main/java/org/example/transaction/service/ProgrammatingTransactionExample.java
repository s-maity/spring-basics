package org.example.transaction.service;

import lombok.AllArgsConstructor;
import org.example.transaction.entities.InventoryEntity;
import org.example.transaction.entities.ShipmentEntity;
import org.example.transaction.respositories.InventoryJPARepository;
import org.example.transaction.respositories.ShipmentJPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@AllArgsConstructor
public class ProgrammatingTransactionExample {

    private final TransactionTemplate txTemplate;
    private final ShipmentJPARepository shipmentJPARepository;
    private final InventoryJPARepository inventoryJPARepository;

    //Not tested
    public void method() {
        var status = txTemplate.execute((tx) -> {

            var shipment = ShipmentEntity.builder()
                    .build();
            var inventory = InventoryEntity.builder()
                    .build();
            shipmentJPARepository.save(shipment);
            inventoryJPARepository.save(inventory);
            return true;
        });
        System.out.println(status);
    }
}
