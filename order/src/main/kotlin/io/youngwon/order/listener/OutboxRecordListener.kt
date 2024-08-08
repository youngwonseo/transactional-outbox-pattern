package io.youngwon.order.listener

import io.youngwon.order.domain.OutboxEntity
import io.youngwon.order.listener.event.Event
import io.youngwon.order.repository.OutboxRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class OutboxRecordListener(
    private val outboxRepository: OutboxRepository,
) {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    fun recordEventHandler(event: Event) {
        outboxRepository.save(
            OutboxEntity(
                type = event.type,
                message = event.toMessage()
            )
        )
    }
}
