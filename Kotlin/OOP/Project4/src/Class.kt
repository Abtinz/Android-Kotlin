class Class : Location {
    val location = "Maktabkhoneh //Android Studio - Elementary to pro"
    val className = "Android Studio"

    fun printLocation(){
        println(printClassName() +"\n" + printAddreass())
    }

    override fun printAddreass(): String{
        return "Class Address: ${location}"
    }

    override fun printClassName(): String {
        return  "Class Name: ${className}"
    }
}