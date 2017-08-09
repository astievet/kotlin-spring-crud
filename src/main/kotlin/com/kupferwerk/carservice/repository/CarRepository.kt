package com.kupferwerk.carservice.repository

import com.kupferwerk.carservice.model.Car
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * @author arnaud on 09.08.17.
 */
interface CarRepository : PagingAndSortingRepository<Car, Long> {

}