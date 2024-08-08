package io.youngwon.order.repository

import io.youngwon.order.domain.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long>
