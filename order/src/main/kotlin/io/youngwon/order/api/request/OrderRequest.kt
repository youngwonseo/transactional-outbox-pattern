package io.youngwon.order.api.request

data class OrderRequest(
    val userId: Long,
    val productId: Long,
    val amount: Int
)
