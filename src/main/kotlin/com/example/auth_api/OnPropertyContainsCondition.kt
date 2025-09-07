package com.example.auth_api

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

class OnPropertyContainsCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val attributes = metadata.getAnnotationAttributes(
            ConditionalOnPropertyContains::class.java.name
        ) ?: return false

        val prefix = attributes["prefix"] as String
        val name = attributes["name"] as String
        val requiredValues = attributes["havingValues"] as Array<*>

        val propertyKey = "$prefix.$name"
        val propertyValue = context.environment.getProperty(propertyKey) ?: return false

        val configuredValues = propertyValue.split(",").map { it.trim() }

        // ✅ OR-condition: true if any match
        return requiredValues.any { configuredValues.contains(it) }
    }
}

