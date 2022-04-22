open class School constructor(name:String , Location:String) {

    var schoolName:String? = null
        get() {
            return "School Name: ${field}\n"
        }

    var schoolAddress:String? = null
        get() {
            return "School Address: ${field}\n"
        }

    init {
        schoolAddress = Location
        schoolName = name
    }

    fun printSchoolDetails(firstText:String){
        println("-------------------------------------------------------------------------")
        println("${firstText} School Details: ${schoolName}${schoolAddress}")
        println("-------------------------------------------------------------------------")
    }
}