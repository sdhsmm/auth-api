package com.example.auth_api

interface TokenBlacklistService {
    fun blacklistToken(token: String)

    fun isTokenBlacklisted(token: String): Boolean
}