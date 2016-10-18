package com.github.tommykw.auto_permanent_compiler

import java.io.File

data class Options(
    val project: Collection<File>,
    val subProjects: Collection<File>,
    val libraries: Collection<File>,
    val bootClassPath: Collection<File>,
    val output: File
) {
    class Builder(val output: File) {
        private val project = arrayListOf<File>()
        private val subProjects = arrayListOf<File>()
        private val bootClassPath = arrayListOf<File>()
        private val libraries = arrayListOf<File>()

        fun project(files: Collection<File>) = apply {
            project.addAll(files)
        }

        fun subProjects(files: Collection<File>) = apply {
            project.addAll(files)
        }

        fun bootClassPath(files: Collection<File>) = apply {
            libraries.addAll(files)
        }

        fun libraries(files: Collection<File>) = apply {
            libraries.addAll(files)
        }

        fun build() = Options(
            project,
            subProjects,
            libraries,
            bootClassPath,
            output
        )
    }
}
