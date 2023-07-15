package com.example.pipefywebhook.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity

class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { auth ->
                auth.antMatchers("/").permitAll()
                auth.antMatchers("/user").hasRole("USER")
                auth.antMatchers("/webhook").hasRole("apiKEY")
            }
            .httpBasic(Customizer.withDefaults())
            .build()
    }

    @Bean
    fun userDetailsManager() : InMemoryUserDetailsManager {
        val user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("123")
            .roles("USER")
            .build()

        val apiKey = User.withDefaultPasswordEncoder()
            .username("apiKEY")
            .password("APIWEBHOOK")
            .roles("apiKEY")
            .build()
        return InMemoryUserDetailsManager(user,apiKey)
    }
}