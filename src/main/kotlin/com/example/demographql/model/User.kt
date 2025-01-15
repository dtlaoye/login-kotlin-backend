package com.example.demographql.model

import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.annotations.GraphQLIgnore
import org.springframework.data.annotation.Id
import java.util.*

data class User(
    val username: String,

    @GraphQLIgnore
    val password: String
) {
    @GraphQLID @Id
    var id: String = UUID.randomUUID().toString()
}

