package com.example.kotlinlearn.repository

import com.example.kotlinlearn.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserRepository : JpaRepository<User?, Long?> {
    fun findByName(name: String?): Optional<User?>?
}
