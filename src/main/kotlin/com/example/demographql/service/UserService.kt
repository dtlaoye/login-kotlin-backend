package com.example.demographql.service

import com.example.demographql.model.User
import com.example.demographql.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: UserRepository) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun createUser(username: String, password: String): Mono<User> {
        val encodedPassword = passwordEncoder.encode(password)
        val user = User(username = username, password = encodedPassword)
        return userRepository.save(user)
    }

    fun findByUsername(username: String): Mono<User> {
        return userRepository.findByUsername(username)
    }

    fun verifyPassword(user: User, rawPassword: String): Boolean {
        return passwordEncoder.matches(rawPassword, user.password)
    }
}