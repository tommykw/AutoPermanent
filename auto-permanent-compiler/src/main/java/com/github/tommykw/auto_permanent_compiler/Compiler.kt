package com.github.tommykw.auto_permanent_compiler

import android.graphics.BitmapFactory

class Compiler {
    fun compile(options: Options) {
        val grip = GripFactory.create(hashSetOf(options.project + options.subprojects + options.libraries + options.bootclasspath))
        val environment = GenerationEnvironment(grip)
        val parcelables = grip.select(classes)
            .from(options.project)
            .where(isAutoParcelable())
    }
}