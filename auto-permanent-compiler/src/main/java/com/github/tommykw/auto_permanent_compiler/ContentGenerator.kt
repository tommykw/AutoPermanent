package com.github.tommykw.auto_permanent_compiler

internal interface ContentGenerator {
    fun generate(environment: String): Collection<String>
}
