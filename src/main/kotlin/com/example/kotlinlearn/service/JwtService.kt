package com.example.kotlinlearn.service


//import java.time.temporal.TemporalUnit
import com.auth0.jwt.algorithms.Algorithm
import io.jsonwebtoken.JwsHeader
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.crypto.MacProvider
import org.springframework.stereotype.Service
import java.security.Key
import javax.crypto.SecretKey


@Service
class JwtService() {
    private val algorithm: Algorithm=Algorithm.HMAC256("KuKaReKu")
    var key: Key = MacProvider.generateKey()

    fun create( id: Long?, secret: String?): String {
        //  return JWT.create().withClaim(ID_CLAIM, id)
        //        .withClaim(SECRET_CLAIM, secret).sign(algorithm)

        return Jwts.builder()
                .setSubject("verify")
                .claim("id", id.toString())
                .setHeaderParam(JwsHeader.KEY_ID, id) // 1
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    fun verify(jwt: String):String {
       return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody().get("id").toString()

        //return  JWT.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJJRCI6NzIsIlNFQ1JFVCI6InNlY3JldCJ9.6Cvl29soz9IIsroefM8tBa-F6s0oTIW-a1xmBlBpnw0").algorithm
    }


    companion object {
        const val ROLE_CLAIM = "ROLE"
        const val ID_CLAIM = "ID"
        const val CODE_CLAIM = "CODE"
        const val SECRET_CLAIM = "SECRET"
    }


}