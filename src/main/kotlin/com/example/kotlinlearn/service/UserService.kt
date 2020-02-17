package com.example.kotlinlearn.service

import com.example.kotlinlearn.controller.UserDTO
import com.example.kotlinlearn.entity.User
import com.example.kotlinlearn.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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
    fun newUser(user:UserDTO):  Any {
        println("Сервис новый юзверь")
        val  userNew=User()
        userNew.name=user.name
        userNew.email=user.email
        userNew.password=user.password

        return repository.save(userNew)
    }
    fun renameUser(id:Long,user:UserDTO):  Any {
        println("Сервис изменить юзверя")
        val userFind=repository.findById(id)
        if (userFind.isEmpty) return ResponseEntity.notFound()
         else {
            val userFindSave=userFind.get()
            userFindSave.name=user.name
            userFindSave.email=user.email
            userFindSave.password=user.password

            return repository.save(userFindSave)
        }
    }
    fun deleteUser(id: Long):  Iterable<Any?> {
        println("Сервис удалить юзверя")
        return listOf(repository.deleteById(id))
    }
    //fun findUsers()= repository.findAll().toList()
}