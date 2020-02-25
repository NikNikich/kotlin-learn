package com.example.kotlinlearn.repository

import com.example.kotlinlearn.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

//import kotlin.uti*


interface UserRepository : CrudRepository<User?, Long?> {
    fun findByName(name: String?):Optional<User?>?
    abstract fun findByNameOrEmailAndIdNot(name: String, email: String, id:Long): List<User?>
    abstract fun findByNameOrEmail(name: String, email: String): List<User?>
    abstract fun findByEmailAndPassword(email: String, password: String): List<User?>
}
