class Teacher constructor(fullName:String , id:String , courseName:String){

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

        teacherName = fullName
        teacherId = id
        teacherCourseName = courseName

    }

    fun printTeacherDetails()
    {
        println("Teacher Details: "+ teacherName + teacherId + teacherCourseName)
    }

}