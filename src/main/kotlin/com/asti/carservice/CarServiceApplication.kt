package com.asti.carservice

import com.asti.carservice.model.Car
import com.asti.carservice.repository.CarRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CarServiceApplication {

//    @Bean
//    fun init(repository: CarRepository) = CommandLineRunner {
//        repository.save(Car("intive_Kupferwerk 1", "Limousine with 5 Seats"))
//        repository.save(Car("intive_Kupferwerk car 2", "2 seated car"))
//    }
}

fun main(args: Array<String>) {
    SpringApplication.run(CarServiceApplication::class.java, *args)
}
