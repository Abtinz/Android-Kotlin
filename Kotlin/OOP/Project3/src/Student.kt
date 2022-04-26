class Student constructor(fullName:String , id:String , Grade:String , StdclassId :String ,name:String , Location:String)
    : School(name , Location){

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
        super.schoolName = name
        super.schoolAddress = Location
        studentId = id
        studentName = fullName
        studentGrade = Grade
        studentclassId = StdclassId
    }

    fun printStudentDetails(){

        super.printSchoolDetails("Student")
        println("StudentDetails:\n" + studentName + studentId + studentclassId + studentGrade)
    }

    override fun printDetails(firstText: String) {
        super.printDetails(firstText)
        println("StudentDetails:\n" + studentName + studentId + studentclassId + studentGrade)
    }
}