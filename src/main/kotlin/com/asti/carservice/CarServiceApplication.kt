package com.asti.carservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CarServiceApplication {

}

fun main(args: Array<String>) {
    SpringApplication.run(CarServiceApplication::class.java, *args)
}
