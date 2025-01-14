package com.example.demographql.model

import com.expediagroup.graphql.annotations.GraphQLID
import org.springframework.data.annotation.Id
import java.util.*

data class User(
    val username: String,
    val password: String
) {
    @GraphQLID @Id
    var id: String = UUID.randomUUID().toString()
}

