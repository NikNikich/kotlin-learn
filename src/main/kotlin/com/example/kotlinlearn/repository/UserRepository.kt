package com.example.kotlinlearn.repository

import com.example.kotlinlearn.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

//import kotlin.uti*


interface UserRepository : CrudRepository<User?, Long?> {
    fun findByName(name: String?): Iterable<User?>?
}
