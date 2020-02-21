package com.example.kotlinlearn.controller

import com.example.kotlinlearn.repository.UserRepository
import com.example.kotlinlearn.controller.UserDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.kotlinlearn.service.UserService
import com.example.kotlinlearn.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import javax.validation.Valid
import com.example.kotlinlearn.service.JwtService

@RestController // Сообщаем как обрабатывать http запросы и в каком виде отправлять ответы (сериализация в JSON и обратно)
@RequestMapping("products") // Указываем префикс маршрута для всех экшенов
//class ProductsController(private val productService: ProductService) { // Внедряем наш сервис в качестве зависимости
 class UserController() { // Внедряем наш сервис в качестве зависимости
    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var repository: UserRepository
    @Autowired
    lateinit var jwtService: JwtService

    @GetMapping // Говорим что экшен принимает GET запрос без параметров в url
  //  fun index() = productService.all() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа
    fun findAll() = ( userService.findUsers()) // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа

  //  @PostMapping(consumes = ["multipart/form-data;boundary=--------------------------630473317876922893239348;charset=UTF-8","application/octet-stream","application/x-www-form-urlencoded"]) // Экшен принимает POST запрос без параметров в url
  @PostMapping // Экшен принимает POST запрос без параметров в url
  //  @ResponseStatus(HttpStatus.CREATED) // Указываем специфический HttpStatus при успешном ответе
    //   fun create(@RequestBody product: Product) = productService.add(product) // Принимаем объект Product из тела запроса и передаем его в метод add нашего сервиса
    fun create(@RequestBody @Valid user: UserDTO):Any {
      if(repository.findByNameOrEmail(user.name,user.email).isNotEmpty()){
          ResponseEntity.status(HttpStatus.IM_USED)
          return ResponseEntity.status(HttpStatus.IM_USED)
                  .body("Double " );}
      else return userService.newUser(user) }// Принимаем объект Product из тела запроса и передаем его в метод add нашего сервиса

    @GetMapping("{id}") // Тут мы говорим что это GET запрос с параметром в url (http://localhost/products/{id})
   // @ResponseStatus(HttpStatus.FOUND)
    //fun read(@PathVariable id: Long) = productService.get(id) // Сообщаем что наш id типа Long и передаем его в метод get сервиса
    fun read(@PathVariable id: Long) =if (!userService.findOneUser(id).isEmpty) ResponseEntity.ok(userService.findOneUser(id))  else "noContent" // Сообщаем что наш id типа Long и передаем его в метод get сервиса

    @PutMapping("{id}")
    fun update( @PathVariable id: Long,@RequestBody @Valid user: UserDTO) :Any {
        var jwtId=jwtService.create(id,"secret")
        println("jwt");
        println(id);
        println(jwtId);
       // println(jwtService.verify(jwtId));
        return jwtService.verify(jwtId)
        val findUserNameOrEmail=repository.findByNameOrEmailAndIdNot(user.name,user.email,id)

        if(findUserNameOrEmail.isNotEmpty()){
            ResponseEntity.status(HttpStatus.IM_USED)
            return ResponseEntity.status(HttpStatus.IM_USED)
                    .body("Double element " );
        }
        else return userService.renameUser(id,user)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long):Any  {
         if (repository.findById(id).isEmpty) {
             println("Not found")
             return ResponseEntity.notFound()
         } else return userService.deleteUser(id)
    }
}