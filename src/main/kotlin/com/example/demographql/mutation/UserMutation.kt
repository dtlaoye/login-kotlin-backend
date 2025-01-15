package com.example.demographql.mutation

import com.example.demographql.model.User
import com.example.demographql.service.UserService
import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class UserMutation: Mutation {
    @Autowired
    private lateinit var userService: UserService

    fun register(username: String, password: String): Mono<User> {
        return userService.createUser(username, password)
    }

    fun login(username: String, password: String): Mono<User?> {
        return userService.findByUsername(username)
            .flatMap { user ->
                if (user != null && userService.verifyPassword(user, password)) {
                    Mono.just(user)
                } else {
                    Mono.empty()
                }
            }
    }
}
