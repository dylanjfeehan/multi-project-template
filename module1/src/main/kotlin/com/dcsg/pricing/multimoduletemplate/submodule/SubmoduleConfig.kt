// ??
package com.dcsg.pricing.multimoduletemplate.submodule

import com.dcsg.pricing.multimoduletemplate.core.AnimalService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import com.dcsg.pricing.multimoduletemplate.core.Worker
import com.dcsg.pricing.multimoduletemplate.core.Farmer
import com.dcsg.pricing.multimoduletemplate.submodule2.repo.Duck
import com.dcsg.pricing.multimoduletemplate.core.FarmInterface
import org.springframework.util.backoff.FixedBackOff

// i need to figure out how to do it in the java context baby
@Configuration
@EnableAutoConfiguration
@ComponentScan
class SubmoduleConfig {

    @Bean
    fun farmer(): Worker {
        return Farmer()
    }
    @Bean
    fun duck(): AnimalService {
        return Duck()
    }

    @Bean
    fun farm(duck: AnimalService, farmer: Worker): FarmInterface {
        return Farm(duck, farmer)
    }

}