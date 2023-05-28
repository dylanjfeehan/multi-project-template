package com.dcsg.pricing.multimoduletemplate

import com.dcsg.pricing.multimoduletemplate.core.AnimalService
import com.dcsg.pricing.multimoduletemplate.core.FarmInterface
import org.springframework.context.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.dcsg.pricing.multimoduletemplate.submodule.Farm
import org.springframework.stereotype.Component

@SpringBootApplication
class MainApp

fun main(args: Array<String>) {
    val context: ApplicationContext = runApplication<MainApp>(*args)
    val duck: FarmInterface = context.getBean(Farm::class.java)
    println(duck.greetAnimal())
    println("Hello world!")
    println("APPLICATION SUCCEEDED")
}