package com.dcsg.pricing.multimoduletemplate.submodule2.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

// you can test all of the code that you write :)
// also, you can refactor.. think about the responsibility of each module... interesting....
// what am i going to do right now.. output? write to something? eventually a kafka topic but that'll change
@ActiveProfiles("test")
class PostgresProductInfoWriterTest {

    @Test
    fun `if this fails we are all doomed`() {
        assertThat(true).isEqualTo(true)
    }
}
