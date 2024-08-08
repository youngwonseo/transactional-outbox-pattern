package io.youngwon.order.listener.event

import io.youngwon.order.domain.OutboxType
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class OrderRegisterEvent(
    override val type: OutboxType,
    val orderId: Long,
    val productId: Long,
    val amount: Int,
    val userId: Long,
) : Event {

    override fun toMessage(): String {
        return Json.encodeToString(this)
    }
}
