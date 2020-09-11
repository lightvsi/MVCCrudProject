package ru.lightvsi.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lightvsi.springmvcapp.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
