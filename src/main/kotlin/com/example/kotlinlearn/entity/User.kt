package com.example.kotlinlearn.entity

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "user", schema = "public")
@TableGenerator(name="tab", initialValue=72, allocationSize=1)
class User(
) {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
    @Column(name = "id", nullable = true, insertable = true, updatable = true)
    private val id: Long? = null
    @Column(unique = true)
     var name: String? = null
    @Column
    var password: String? = null
    @Column(unique = true)
    var email: String? = null //getters and setters
    fun getId(): Long? {
        return this.id
    }
}