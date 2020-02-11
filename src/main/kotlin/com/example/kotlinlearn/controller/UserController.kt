package com.example.kotlinlearn.controller

import com.example.kotlinlearn.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.kotlinlearn.service.UserService
import org.springframework.beans.factory.annotation.Autowired

@RestController // Сообщаем как обрабатывать http запросы и в каком виде отправлять ответы (сериализация в JSON и обратно)
@RequestMapping("products") // Указываем префикс маршрута для всех экшенов
//class ProductsController(private val productService: ProductService) { // Внедряем наш сервис в качестве зависимости
class UserController() { // Внедряем наш сервис в качестве зависимости
    private val userService: UserService? = null
    @Autowired
    lateinit var repository: UserRepository

    @GetMapping // Говорим что экшен принимает GET запрос без параметров в url
  //  fun index() = productService.all() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа
    fun findAll() = (repository.findAll()) // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа

    @PostMapping // Экшен принимает POST запрос без параметров в url
    @ResponseStatus(HttpStatus.CREATED) // Указываем специфический HttpStatus при успешном ответе
 //   fun create(@RequestBody product: Product) = productService.add(product) // Принимаем объект Product из тела запроса и передаем его в метод add нашего сервиса
    fun create() = '3' // Принимаем объект Product из тела запроса и передаем его в метод add нашего сервиса

    @GetMapping("{id}") // Тут мы говорим что это GET запрос с параметром в url (http://localhost/products/{id})
    @ResponseStatus(HttpStatus.FOUND)
    //fun read(@PathVariable id: Long) = productService.get(id) // Сообщаем что наш id типа Long и передаем его в метод get сервиса
    fun read(@PathVariable id: Long) = '3' // Сообщаем что наш id типа Long и передаем его в метод get сервиса

  /*  @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product) = productService.edit(id, product) // Здесь мы принимаем один параметр из url, второй из тела PUT запроса и отдаем их методу edit

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = productService.remove(id)*/
}