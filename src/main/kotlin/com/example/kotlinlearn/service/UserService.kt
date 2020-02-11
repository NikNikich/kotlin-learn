package com.example.kotlinlearn.service

import com.example.kotlinlearn.entity.User
import com.example.kotlinlearn.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserService {
    private val repository: UserRepository? = null
    fun findUsers():  Iterable<User?> {
        return repository!!.findAll()
    }
}