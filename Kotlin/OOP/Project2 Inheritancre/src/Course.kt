class Course constructor(attenders:Int , status:String , courseName:String ,fullName:String , id:String ,
                         name:String , Location:String )
    : Teacher(fullName , id, courseName,name , Location){

    var CourseName:String? = null
        get() {
            return "\nCourse Name: ${field}\n"
        }
    var CourseAttendersCount:Int? = null
    var CourseStatus:String? = null
        get() {
            return "Course Status: ${field}\n"
        }

    init {

        super.schoolName = name
        super.schoolAddress = Location
        super.teacherName = fullName
        super.teacherId = id
        super.teacherCourseName = courseName
        CourseName = courseName
        CourseStatus = status
        CourseAttendersCount = attenders
    }

    fun printCourseDetails()
    {
        println("Course Details: "+ CourseName +"CourseAttendersCount " + CourseAttendersCount + "      "+ CourseStatus)
        super.superTeacherDetailsForLesson()
        super.printSchoolDetails("Course")
    }
}