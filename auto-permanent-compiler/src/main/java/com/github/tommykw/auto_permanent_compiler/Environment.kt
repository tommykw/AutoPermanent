package com.github.tommykw.auto_permanent_compiler

internal class Environment(val grip: Grip) {
    fun newClassWriter(): ClassWriter {
        return ClassWriter(this)
    }

    fun newClass(visitor: ClassWriter.() -> Unit): ByteArray {
        return newClassWriter().apply(visitor).toByteArray()
    }
}