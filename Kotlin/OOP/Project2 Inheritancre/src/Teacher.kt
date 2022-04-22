open class Teacher constructor(fullName:String , id:String , courseName:String,name:String , Location:String)
    : School(name , Location){

    var teacherName:String? = null
          get() {
              return "\nTeacher Name: ${field}\n"
          }
    var teacherId:String? = null
          get() {
              return "Teacher Id: ${field}\n"
          }
    var teacherCourseName:String?
        get() {
            return "Teacher Course Name: ${field}\n"
        }

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

}