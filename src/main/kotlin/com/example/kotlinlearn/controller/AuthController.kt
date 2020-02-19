package com.example.kotlinlearn.controller

import com.example.kotlinlearn.service.JwtService
import com.example.kotlinlearn.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.temporal.ChronoUnit

@RestController
class AuthController : UserController() {
   @Value("\${adminUsername:admin}")
    private val adminUsername: String? = null
    @Autowired
    private val jwtService: JwtService? = null
    @Autowired
    override lateinit var userService: UserService
    @get:GetMapping("/token")
    val token: ResponseEntity<*>
        get() {
            val principal: Any = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
            /*if (principal is Client) {
                return ResponseEntity.ok(jwtService.create(Role.CLIENT, (principal as Client).getId()))
            }
            return if (principal.equals(adminUsername)) {
                ResponseEntity.ok(jwtService.create(Role.ADMIN, 0L, 1, ChronoUnit.HOURS))
            } else*/ return ResponseEntity.status(403).body(principal)
        }
}
