package io.youngwon.order.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@Table(name = "outbox")
@Entity
class OutboxEntity(
    @Enumerated(EnumType.STRING) val type: OutboxType,
    val message: String,
    @CreatedDate var createdAt: LocalDateTime? = null,
    var last_published_at: LocalDateTime? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
) {

}

enum class OutboxType {
    OrderRegister, OrderCancel
}

