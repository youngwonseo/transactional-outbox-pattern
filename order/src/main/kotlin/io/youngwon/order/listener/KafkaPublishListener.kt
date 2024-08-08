package io.youngwon.order.listener

import io.youngwon.order.listener.event.Event
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

const val OrderTopic = "ORDER"

@Component
class KafkaPublishListener(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun publishEventHandler(event: Event) {
        val future = kafkaTemplate.send(OrderTopic, event.toMessage())
        future.whenComplete { result, ex ->
            if (ex == null) {
                // TODO outbox published_at 할당
            }
        }
    }
}
