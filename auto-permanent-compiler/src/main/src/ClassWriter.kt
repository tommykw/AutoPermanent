
internal class ClassWriter(private val environment: GenerationEnvironment): ClassWriter((ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS)) {
    override fun getCommonSuperClass(left: String, right:String):String {

    }
}