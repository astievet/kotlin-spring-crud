package com.kupferwerk.carservice

import com.kupferwerk.carservice.model.Car
import com.kupferwerk.carservice.repository.CarRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CarServiceApplication {

    @Bean
    fun init(repository: CarRepository) = CommandLineRunner {
        repository.save(Car("intive_Kupferwerk 1", "Limousine with 5 Seats"))
        repository.save(Car("intive_Kupferwerk car 2", "2 seated car"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(CarServiceApplication::class.java, *args)
}
