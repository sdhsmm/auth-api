package com.example.auth_api

import org.springframework.context.annotation.Conditional

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Conditional(OnPropertyContainsCondition::class)
annotation class ConditionalOnPropertyContains(
    val prefix: String,
    val name: String,
    vararg val havingValues: String
)

