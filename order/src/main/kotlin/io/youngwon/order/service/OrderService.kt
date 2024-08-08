package io.youngwon.order.service

import io.youngwon.order.domain.OrderEntity
import io.youngwon.order.domain.OutboxType
import io.youngwon.order.listener.event.OrderDeleteEvent
import io.youngwon.order.listener.event.OrderRegisterEvent
import io.youngwon.order.repository.OrderRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Transactional
    fun registerOrder(
        userId: Long,
        productId: Long,
        amount: Int,
    ) {

        // 주문 처리
        val order: OrderEntity = orderRepository.save(
            OrderEntity(
                productId = productId,
                amount = amount,
                userId = userId
            )
        )

        // 이벤트 발행
        applicationEventPublisher.publishEvent(
            OrderRegisterEvent(
                type = OutboxType.OrderRegister,
                orderId = order.id,
                productId = productId,
                amount = amount,
                userId = userId,
            )
        )
    }

    @Transactional
    fun deleteOrder(
        orderId: Long,
    ) {
        // 주문 삭제
        val order: OrderEntity = orderRepository.findByIdOrNull(orderId) ?: throw EntityNotFoundException()
        orderRepository.delete(order)

        // 이벤트 발행
        applicationEventPublisher.publishEvent(
            OrderDeleteEvent(
                type = OutboxType.OrderRegister,
                orderId = order.id,
            )
        )
    }
}
