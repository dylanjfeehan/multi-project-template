package com.dcsg.pricing.multimoduletemplate.core

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import kotlin.random.Random


fun generateProductInfoCore(sku: String = randomString(),
                            upc: String = randomString()
): ProductInfoCore {
    return ProductInfoCore()
}

fun randomString() = UUID.randomUUID().toString().substring(0, 8)

fun randomInt() = Random.nextInt(1, 1000000)