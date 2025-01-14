package com.example.demographql.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Configuration
class CorsConfig : WebFluxConfigurer {

    // General CORS settings
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Update with your frontend origin
            .allowedMethods("GET", "POST", "OPTIONS") // Allowed methods
            .allowedHeaders("*") // Allow all headers
            .allowCredentials(true) // Enable credentials
    }
}

@Configuration
class GlobalCorsFilter : WebFilter {

    // Specific handling for OPTIONS and dynamic cases
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val response = exchange.response
        val request = exchange.request

        // Add CORS headers dynamically
        response.headers.add("Access-Control-Allow-Origin", "http://localhost:3000") // Match frontend origin
        response.headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
        response.headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization")
        response.headers.add("Access-Control-Allow-Credentials", "true")

        // Handle preflight (OPTIONS) requests explicitly
        return if (request.method?.name.equals("OPTIONS", ignoreCase = true)) {
            response.setStatusCode(org.springframework.http.HttpStatus.OK)
            Mono.empty()
        } else {
            chain.filter(exchange)
        }
    }
}