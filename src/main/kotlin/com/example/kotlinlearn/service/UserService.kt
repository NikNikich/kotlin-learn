package com.example.kotlinlearn.service

import com.example.kotlinlearn.entity.User
import com.example.kotlinlearn.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*


@Service
open class UserService {
   // private val repository: UserRepository? = null
   @Autowired
    lateinit var repository: UserRepository
    fun findUsers():  Iterable<User?> {
        println("Сервис все юзвери")
        return repository.findAll().toList()
    }
    fun findOneUser(id:Long):  Optional<User?> {
        println("Сервис один юзверь")
        return repository.findById(id)
    }
    fun newUser(user:User):  Iterable<User?> {
        println("Сервис новый юзверь")
        return repository.findAll().toList()
    }
    fun renameUser(user:User):  Iterable<User?> {
        println("Сервис изменить юзверя")
        return repository.findAll().toList()
    }
    fun deleteUser(int: Long):  Iterable<Any?> {
        println("Сервис удалить юзверя")
        return repository.findAll().toList()
    }
    //fun findUsers()= repository.findAll().toList()
}