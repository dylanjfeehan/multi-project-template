package com.dcsg.pricing.multimoduletemplate.submodule

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import com.dcsg.pricing.multimoduletemplate.submodule.SubmoduleConfig
import com.dcsg.pricing.multimoduletemplate.core.FarmInterface
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ContextConfiguration(classes=[SubmoduleConfig::class])
class FarmUnitTest() {

    @Autowired
    private lateinit var farm: FarmInterface

    @Test
    fun `same as other`() {
        assertEquals("Howdyquack", farm.greetAnimal())
    }
}