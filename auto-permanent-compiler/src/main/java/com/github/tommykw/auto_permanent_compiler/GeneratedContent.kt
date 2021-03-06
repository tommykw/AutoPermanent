package com.github.tommykw.auto_permanent_compiler

internal data class GeneratedContet(
    val path: String,
    val extras: Map<String, Any>,
    val content: ByteArray
) {
    companion object {
        fun from(type: Type, extras: Map<String, Any>, content: ByteArray): GeneratedContet {
            return GeneratedContet(Types.getClassFilePath(type), extras, content)
        }
    }

    inline fun <reified T> extra(name: String): T {
        return extras[name] as T : throw NoSuchElementException(name)
    }

    fun has(name: String): Boolean {
        return extras.containsKey(name)
    }
}
