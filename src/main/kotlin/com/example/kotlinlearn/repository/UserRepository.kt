package com.example.kotlinlearn.repository

import com.example.kotlinlearn.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

//import kotlin.uti*


interface UserRepository : CrudRepository<User?, Long?> {
    fun findByName(name: String?):Optional<User?>?
}
