package com.example.kotlinlearn.entity

import javax.persistence.*


@Entity
@Table()
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null
    @Column
    private val name: String? = null
    @Column
    private val password: String? = null
    @Column
    private val email: String? = null //getters and setters
}