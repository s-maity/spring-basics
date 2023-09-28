package org.example.transaction.respositories;

import org.example.transaction.entities.InventoryEntity;
import org.example.transaction.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryJPARepository extends JpaRepository<InventoryEntity, Integer> {
    Optional<InventoryEntity> findByProductId(int productId);
}
