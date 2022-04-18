class Teacher constructor(fullName:String , id:String , courseName:String){

    var teacherName:String? = null
          get() {
              return "Teacher Name: ${field}"
          }
    var teacherId:String? = null
          get() {
              return "Teacher Id: ${field}"
          }
    var teacherCourseName:String?
        get() {
            return "Teacher Course Name: ${field}"
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