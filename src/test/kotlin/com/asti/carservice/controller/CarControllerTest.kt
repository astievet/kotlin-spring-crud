package com.asti.carservice.controller

import com.jayway.restassured.RestAssured.basic
import com.jayway.restassured.RestAssured.given
import com.jayway.restassured.builder.RequestSpecBuilder
import com.jayway.restassured.http.ContentType
import com.jayway.restassured.specification.RequestSpecification
import com.asti.carservice.CarServiceApplication
import com.asti.carservice.model.Car
import com.asti.carservice.repository.CarRepository
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.BeforeClass
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
    lateinit var carRepository: CarRepository

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @LocalServerPort
    var port: Int = 0

    // TODO SAD: quite verbose
    companion object {

        var initSpec : RequestSpecification? = null

        @BeforeClass @JvmStatic
        fun setup() {
            initSpec = RequestSpecBuilder().
                    setContentType(ContentType.JSON).
                    setAuth(basic("admin", "12345")).
                    build()
        }
    }

    @Test
    fun getAll_OK() {
        given()
            .spec(initSpec)
            .port(port)
            .`when`()
            .get("/")
            .then()
            .statusCode(200)
    }

    @Test
    fun createCar_OK() {
        val aCar: Car = Car("aNewCar", "shortDesc")
        given()
            .spec(initSpec)
            .port(port)
            .body(aCar)
        .`when`()
            .post("/")
        .then()
            .statusCode(200)
            .extract().header("location")
    }

    @Test
    fun getOne_OK() {
        val testCar = Car("testCar", "testShortDescription")
        carRepository.deleteAll()
        carRepository.save(testCar)

        given()
            .spec(initSpec)
            .port(port)
        .`when`()
            .get("/1")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("name", `is`(testCar.name))
    }

    @Test
    fun `GET car with id 1`() {
        val id = 1
        val body = testRestTemplate.getForObject("/{id}", Car::class.java, id)
        assertThat(body).hasFieldOrProperty("shortDescription")
    }
}