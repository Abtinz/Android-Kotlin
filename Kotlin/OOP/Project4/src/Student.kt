class Student constructor(fullName:String , id:String , Grade:String , StdclassId :String ){

    var studentName:String? = null
        get() {
            return "Student Name: ${field}\n"
        }
    var studentId:String? = null
        get() {
            return "Student Id: ${field}\n"
        }
    var studentGrade:String? = null
         get() {
             return "Student Grade: ${field}\n"
         }
    var studentclassId:String? = null
        get() {
            return "student Class Id: ${field}\n"
        }
    init {
        studentId = id
        studentName = fullName
        studentGrade = Grade
        studentclassId = StdclassId
    }

    fun printStudentDetails(){
        println("StudentDetails:\n" + studentName + studentId + studentclassId + studentGrade)
    }
}