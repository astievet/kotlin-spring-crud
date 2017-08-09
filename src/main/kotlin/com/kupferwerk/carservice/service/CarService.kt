package com.kupferwerk.carservice.service

import com.kupferwerk.carservice.model.Car
import com.kupferwerk.carservice.repository.CarRepository
import org.springframework.stereotype.Service

/**
 * @author arnaud on 09.08.17.
 */
@Service
class CarService(val carRepository: CarRepository) {

    fun get() = carRepository.findAll()

    fun getById(id: Long) = carRepository.findOne(id)

    fun save(car: Car) = carRepository.save(car)

    fun delete(id: Long) = carRepository.delete(id)
}