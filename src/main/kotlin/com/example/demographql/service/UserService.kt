package com.example.demographql.service

import com.example.demographql.model.User
import com.example.demographql.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: UserRepository) {
    fun createUser(username: String, password: String): Mono<User> {
        val user = User(username = username, password = password)
        return userRepository.save(user)
    }

    fun findByUsername(username: String): Mono<User> {
        return userRepository.findByUsername(username)
    }
}