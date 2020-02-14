package com.example.kotlinlearn.entity
import com.example.kotlinlearn.entity.User

import org.hibernate.validator.HibernateValidator


class ValidateUser {
    fun UserAdd(obj: Any):Any {
        val userValid: User = obj as User
        if (userValid.name!!.isNotEmpty()&&userValid.email!!.isNotEmpty()&&userValid.password!!.isNotEmpty()){
            if((userValid.name as String).length<4||(userValid.name as String).length>200) return "Name >4 and < 200"
            if((userValid.email as String).length<4||(userValid.email as String).length>200) return "Email >4 and < 400"
        } else return false
        return -1
    }
    /**
     * This Validator validates *just* Person instances


    fun supports(clazz: Class<*>): Boolean {
        return Person::class.java == clazz
    }

    fun validate(obj: Any, e: Errors) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty")
        val p: Person = obj as Person
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativevalue")
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old")
        }
    }*/
}