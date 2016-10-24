package com.github.tommykw.auto_permanent_compiler.model

import kotlin.reflect.KClass

internal sealed class AutoPermanentClassSpec(val clazz: KClass) {
    class Object(clazz: KClass, val name: String) : AutoPermanentClassSpec(clazz)
    class Data(clazz: KClass, val properties: List<AutoPermanentClassSpec>)
}

internal data class AutoPermanentPropertySpec(
    val name: String,
    val type: Int
)