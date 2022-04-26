open class Teacher constructor(fullName:String , id:String , courseName:String,name:String , Location:String)
    : School(name , Location) ,Person{

    var teacherName:String? = null

    var teacherId:String? = null

    var teacherCourseName:String?
        get() {
            return "Teacher Course Name: ${field}\n"
        }

    val TeacherJob = "Teacher"

    init {

        super.schoolName = name
        super.schoolAddress = Location
        teacherName = fullName
        teacherId = id
        teacherCourseName = courseName

    }

    fun printTeacherDetails()
    {
        super.printSchoolDetails("Teacher")
        println("Teacher Details: "+ teacherName + teacherId + teacherCourseName)
    }

    fun superTeacherDetailsForLesson(){
        println("-------------------------------------------------------------------------")
        println("Teacher Details: "+ teacherName + teacherId + teacherCourseName)
    }

    override fun printDetails(firstText: String) {
        super.printDetails(firstText)
        println("${printPersonJob(TeacherJob)} Details: "+ printFullname(teacherName)
                 + printPersonId(teacherId) + teacherCourseName)
    }

    override fun printFullname(fullName: String?): String {
        return  "\n${printPersonJob(TeacherJob)} Name: ${fullName}\n"
    }

    override fun printPersonId(personId: String?): String {
        return "${printPersonJob(TeacherJob)} Id: ${personId}\n"
    }

    override fun printPersonJob(personJob: String?): String {
        return personJob!!
    }

}