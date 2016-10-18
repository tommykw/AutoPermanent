package com.github.tommykw.auto_permanent_compiler

import android.graphics.BitmapFactory

class Compiler {
    fun compile(options: Options) {
        val grip = GripFactory.create(hashSetOf(options.project + options.subprojects + options.libraries + options.bootclasspath))
        val environment = GenerationEnvironment(grip)
        val parcelables = grip.select(classes)
            .from(options.project)
            .where(isAutoParcelable())

        options.project.forEach {
            it.copyRecursively(options.output, true)
        }

        parcelables.execute().classes.forEach {
            val spec = AutoParcelableClassSpecFactory.from(it)
            val generator = ParcelableContentGenerator(spec, ValueAdapterFactory.from(factory, spec))

            generator.generate(environment).forEach {
                File(options.output, it.path).writeBytes(it.content)
            }
        }
    }
}