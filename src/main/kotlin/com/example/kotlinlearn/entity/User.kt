package com.example.kotlinlearn.entity

import javax.persistence.*


@Entity
@Table(name = "user", schema = "public")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null
    @Column(unique = true)
    public val name: String? = null
    @Column
    public val password: String? = null
    @Column(unique = true)
    public val email: String? = null //getters and setters
}