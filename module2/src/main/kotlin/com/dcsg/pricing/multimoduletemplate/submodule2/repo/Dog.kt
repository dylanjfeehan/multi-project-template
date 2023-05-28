package com.dcsg.pricing.multimoduletemplate.submodule2.repo

import com.dcsg.pricing.multimoduletemplate.core.AnimalService
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Primary

@Primary
@Component
class Dog : AnimalService {
    override fun getSound(): String {
        return "woof"
    }
}