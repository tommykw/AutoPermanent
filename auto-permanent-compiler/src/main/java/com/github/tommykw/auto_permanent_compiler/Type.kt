package com.github.tommykw.auto_permanent_compiler

sealed class Type constructor(val type: AsmType) {
    val descriptor: String
        get() = type.descrptor
    open val internalName: String
        get() = type.internalName
    open val className: String
        get() = type.className

    override fun equals(other: Any?): Boolean {
        if (this == other) {
            return true
        }

        val that = other as Type? ?: return false
        return type == that.type
    }

    override fun hashCode(): Int = type.hashCode()
    override fun toString(): String = type.toString()

    sealed class Primitive(type: AsmType): Type(type) {
        override val internalName: String
            get() = throw UnsupportedOperationException("Cannnot get internalName for a primitive type")

        object Void : Primitive(AsmType.VOID_TYPE)
        object Boolean : Primitive(AsmType.BOOLEAN_TYPE)
        object Char : Primitive(AsmType.CHAR_TYPE)
        object Byte : Primitive(AsmType.BYTE_TYPE)
        object Short : Primitive(AsmType.SHORT_TYPE)
        object Int : Primitive(AsmType.INT_TYPE)
        object Float : Primitive(AsmType.FLOAT_TYPE)
        object Long : Primitive(AsmType.LONG_TYPE)
        object Double : Primitive(AsmType.DOUBLE_TYPE)
    }
}