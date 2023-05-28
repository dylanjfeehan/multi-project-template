package com.dcsg.pricing.multimoduletemplate.submodule2.repo

//import com.dcsg.pricing.productinfosink.core.ProductInfoCore
//import com.dcsg.pricing.productinfosink.core.ProductInfoWriter
import com.dcsg.pricing.multimoduletemplate.core.AnimalService
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Component

//@Component
class Duck: AnimalService {
    override fun getSound(): String {
        return "quack"
    }
}