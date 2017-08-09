package com.kupferwerk.carservice.controller

import com.kupferwerk.carservice.model.Car
import com.kupferwerk.carservice.repository.CarRepository
import com.kupferwerk.carservice.service.CarService
import org.springframework.web.bind.annotation.*
import javax.management.loading.ClassLoaderRepository

/**
 * @author arnaud on 09.08.17.
 */

@RestController
class CarController(val carService: CarService) {

    @GetMapping("/")
    fun get() = carService.get()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = carService.getById(id)

    @PostMapping
    fun add(@RequestBody car: Car) = carService.save(car)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody car: Car) {
        assert(car.id == id)
        carService.save(car)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = carService.delete(id)
}