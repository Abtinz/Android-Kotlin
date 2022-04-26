class Student constructor(fullName:String , id:String , Grade:String ,
                          StdclassId :String ,name:String , Location:String)
    : School(name , Location) , Person{

    var studentName:String? = null

    var studentId:String? = null

    var studentGrade:String? = null
         get() {
             return "Student Grade: ${field}\n"
         }
    var studentclassId:String? = null
        get() {
            return "student Class Id: ${field}\n"
        }

    val studentJob = "Student"

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
        println("${printPersonJob(studentJob)}Details:\n" +printFullname(studentName) +
                printPersonId(studentId) + studentclassId + studentGrade)
    }

    //interface part
    override fun printFullname(fullName: String?): String {
        return return "${printPersonJob(studentJob)} Name: ${fullName}\n"
    }

    override fun printPersonId(personId: String?): String {
        return "${printPersonJob(studentJob)} Id: ${personId}\n"
    }

    override fun printPersonJob(personJob:String?): String {
        return personJob!!
    }
}