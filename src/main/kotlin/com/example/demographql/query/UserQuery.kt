package com.example.demographql.query

import com.example.demographql.model.User
import com.example.demographql.service.UserService
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono


@Controller
class UserQuery: Query {
    @Autowired
    private lateinit var userService: UserService

    fun login(username: String): Mono<User> {
        return userService.findByUsername(username)
    }
}