package com.example.kotlinlearn.controller

import javax.persistence.UniqueConstraint
import javax.swing.SpringLayout
import javax.validation.constraints.*

class UserDTO (
    @get: NotBlank(message="{email.required}")
    @get: Email(message = "{email.invalid}")
    @get: Size( max=400, message = "{email.size}")
    var email : String = "",

    @get: NotBlank(message="{name.required}")
    @get: Size(min=4, max=200, message = "{name.size}")
    var name : String = "",

    @get: NotBlank(message="{password.required}")
    @get: Size(min=6, max=100, message = "{password.size}")
    var password : String = ""
){
}

class UserSignDTO (
        @get: NotBlank(message="{email.required}")
        @get: Email(message = "{email.invalid}")
        @get: Size( max=400, message = "{email.size}")
        var email : String = "",

      /*  @get: NotBlank(message="{name.required}")
        @get: Size(min=4, max=200, message = "{name.size}")
        var name : String = "",*/

        @get: NotBlank(message="{password.required}")
        @get: Size(min=6, max=100, message = "{password.size}")
        var password : String = ""
){
}