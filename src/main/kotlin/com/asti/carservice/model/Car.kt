package com.asti.carservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author arnaud on 09.08.17.
 */

@Entity
data class Car(
    var name: String = "",
    var shortDescription: String? = null,
    var description: String? = null,
    var image: String? = "",
    @Id @GeneratedValue
    var id: Long = 0
)