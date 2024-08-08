package io.youngwon.order.repository

import io.youngwon.order.domain.OutboxEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OutboxRepository : JpaRepository<OutboxEntity, Long>
