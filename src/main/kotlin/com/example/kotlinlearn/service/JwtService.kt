package com.example.kotlinlearn.service


//import java.time.temporal.TemporalUnit
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.temporal.TemporalUnit
import java.util.*

@Service
class JwtService() {
    private val algorithm: Algorithm=Algorithm.HMAC256("KuKaReKu")
    fun create( id: Long?, secret: String?): String {
        return JWT.create().withClaim(ID_CLAIM, id)
                .withClaim(SECRET_CLAIM, secret).sign(algorithm)
    }

    fun verify(jwt: String?): DecodedJWT {
        return JWT.require(algorithm).build().verify(jwt)
    }


    companion object {
        const val ROLE_CLAIM = "ROLE"
        const val ID_CLAIM = "ID"
        const val CODE_CLAIM = "CODE"
        const val SECRET_CLAIM = "SECRET"
    }


}