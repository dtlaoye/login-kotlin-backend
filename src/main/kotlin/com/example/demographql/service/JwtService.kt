import com.example.demographql.model.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService {
    private val secretKey = "your_secret_key"

    fun generateToken(user: User): String {
        return Jwts.builder()
            .setSubject(user.username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 864_000_000)) // 10 days
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact()
    }
}