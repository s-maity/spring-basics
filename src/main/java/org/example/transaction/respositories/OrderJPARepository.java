package org.example.transaction.respositories;

import org.example.transaction.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJPARepository extends JpaRepository<OrderEntity,Integer> {
}
