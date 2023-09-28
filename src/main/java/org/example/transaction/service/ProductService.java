package org.example.transaction.service;

import lombok.AllArgsConstructor;
import org.example.transaction.entities.OrderEntity;
import org.example.transaction.respositories.OrderJPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
    private OrderJPARepository orderJPARepository;
    private final InventoryAndShipmentService inventoryAndShipmentService;

    @Transactional
    public void placeOrder() {
        // Insert into order table (tx1)
        // Update inventory and shipment  (tx-2)

        /* case1 : execute both tx in same transaction. rollback all transaction if something goes wrong

           case2: execute tx2 in separate tx. don't roll back tx1 event if something goes wrong in tx2
                  but tx2 should be maintained transaction

           case3: tx2 should be called from transaction method, otherwise throw error

           case4: tx2 runs in transaction only if its called from another transaction method
           otherwise it does not run in transaction

           case5:  tx2 never runs in transaction . don't throw error

           case 6:  Use savepoints

         */

        var order = OrderEntity.builder()
                .orderId(1)
                .appUserId(1)
                .productId(1)
                .quantity(100)
                .status("NA")
                .build();

        orderJPARepository.save(order);
        inventoryAndShipmentService.updateInventoryAndShipment(order);
    }
}
