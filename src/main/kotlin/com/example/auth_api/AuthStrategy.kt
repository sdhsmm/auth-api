package com.example.auth_api

import jakarta.servlet.http.HttpServletRequest

interface AuthStrategy {
    fun authenticate(request: HttpServletRequest): AuthenticationResult
    fun type(): AuthType
}

enum class AuthType{
    JWT,
    SSO,
    BASIC,
    COMPOSITE
}
