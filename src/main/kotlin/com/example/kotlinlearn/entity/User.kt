package com.example.kotlinlearn.entity

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


@Entity
@Table(name = "user", schema = "public")
class User(
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null
    @Column(unique = true)
     var name: String? = null
    @Column
    var password: String? = null
    @Column(unique = true)
    var email: String? = null //getters and setters
}