package com.kupferwerk.carservice.controller

import com.jayway.restassured.RestAssured.given
import com.kupferwerk.carservice.CarServiceApplication
import com.kupferwerk.carservice.model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author arnaud on 09.08.17.
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(CarServiceApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @LocalServerPort
    var port: Int = 0

    @Test
    fun `GET all cars returns 2 cars`() {
        val body = testRestTemplate.getForObject("/", String::class.java)
        assertThat(body)
    }

    // rest assured
    // Vorsicht mit when!
    @Test
    fun getAll_OK() {

        given().
                auth().
                preemptive().
                basic("admin","12345").
                port(port).
                `when`().
                get("/").
                then().
                statusCode(200)
    }

    @Test
    fun `GET car with id 1`() {
        val id = 1
        val body = testRestTemplate.getForObject("/{id}", Car::class.java, id)
        assertThat(body).hasFieldOrProperty("shortDescription")
    }
}