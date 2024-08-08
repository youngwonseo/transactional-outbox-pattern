package io.youngwon.order.api

import io.youngwon.order.api.request.OrderRequest
import io.youngwon.order.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
class OrderApiController(
    private val orderService: OrderService,
) {
    @PostMapping("/api/v1/orders")
    fun registerOrder(@RequestBody request: OrderRequest) {
        orderService.registerOrder(
            userId = request.userId,
            productId = request.productId,
            amount = request.amount,
        )
    }

    @DeleteMapping("/api/v1/orders/{id}")
    fun registerOrder(@PathVariable id: Long) {
        orderService.deleteOrder(orderId = id)
    }
}
