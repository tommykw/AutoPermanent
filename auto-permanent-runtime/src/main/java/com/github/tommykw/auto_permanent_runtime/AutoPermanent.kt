package com.github.tommykw.auto_permanent_runtime

interface AutoPermanent {
    companion object {
        private val CREATOR = null
        inline fun <reified T : AutoPermanent> create(): AutoPermanent {
            return creator(T::class.java)
        }

        fun <T : AutoPermanent> creator(clazz: Class<T>): AutoPermanent {
            return synchronized(CREATOR) {
            }
        }
    }
}