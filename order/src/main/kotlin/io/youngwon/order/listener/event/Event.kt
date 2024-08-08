package io.youngwon.order.listener.event

import io.youngwon.order.domain.OutboxType

interface Event {
    val type: OutboxType
    fun toMessage(): String
}
