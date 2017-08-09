package com.kupferwerk.carservice.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.kupferwerk.carservice.model.Car

/**
 * @author arnaud on 09.08.17.
 */
class CarResponse(
    @JsonProperty("cars")
    val cars: List<Car>
)