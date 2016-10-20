package com.github.tommykw.auto_permanent_compiler

import java.text.MessageFormat

open class CompilerException : RuntimeException {
    constructor(message: String, vararg args: Any?) : super(MessageFormat.format(message, *args))
}

open class InvalidTypeAdapterException : CompilerException {
    constructor(type: Type, message: String, vararg args: Any?) : super("Invalid TypeAdapter class ${type.className} $message", *args)
}
