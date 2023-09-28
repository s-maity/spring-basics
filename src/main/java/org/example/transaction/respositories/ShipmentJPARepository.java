package org.example.transaction.respositories;

import org.example.transaction.entities.OrderEntity;
import org.example.transaction.entities.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentJPARepository extends JpaRepository<ShipmentEntity,Integer> {
}
