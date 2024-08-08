package io.youngwon.order.service

import io.kotest.core.spec.style.FreeSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderServiceTests @Autowired constructor(
    val orderService: OrderService
) : FreeSpec({

})
