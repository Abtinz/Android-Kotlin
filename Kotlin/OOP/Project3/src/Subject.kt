open class Subject {
    var subjectName : String? = null
    var subjectField : String? = null

    open fun printDetails(){
        println("Subject Details:\nSubject Name:   $subjectName\n Subject Field:  $subjectField")
    }
}