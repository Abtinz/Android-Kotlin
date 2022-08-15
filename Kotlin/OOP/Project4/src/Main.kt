fun main() {

  val course = Course(2000 , "Finished" , "Android Studio" ,
    "Amir AHmad Adibie","99@%339","MaktabKhoneh","MaktabKhoneh.org Web School")
  course.printDetails("Teacher")

  //cast course to the teacher
  val castedCourse = course as Teacher
  println("Casted Teacher:")
  castedCourse.printTeacherDetails()




  var student = Student("Arash Moradi" , "200#489" , "19.5" ,
                        "202.B","MaktabKhoneh","MaktabKhoneh.org Web School")
  student.printDetails("Student")

  //cast student to school
  val castedStudent = student as School
  println("Casted School:")
  castedStudent.printDetails("Casted ")

  val book = Book("Android Studio" , "Programmers unity" , "Java Katlin FXML and Developing Android apps",
    "Nobody","Android Development","Programming")


  val classInfo = Class()

  //cast with condition
  caster(book)
  caster(classInfo)

}

fun caster(castingObject:Any){
  when(castingObject){
    is Book ->  castingObject.printDetails()
    is Class ->  castingObject.printLocation()
  }
}
