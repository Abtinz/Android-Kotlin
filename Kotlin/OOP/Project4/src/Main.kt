fun main() {

  var teacher = Teacher("Amir AHmad Adibie","99@%339","Android Studio","MaktabKhoneh","MaktabKhoneh.org Web School")
  val course = Course(2000 , "Finished" , "Android Studio" ,
    "Amir AHmad Adibie","99@%339","MaktabKhoneh","MaktabKhoneh.org Web School")
  course.printDetails("Teacher")

  //cast course to the teacher
  val castedCourse = course as Teacher
  println("Casted Teacher:")
  castedCourse.printTeacherDetails()

  //cast teacher to course
  val castedTeacher = teacher as Course
  castedTeacher.CourseAttendersCount = 20000
  castedTeacher.CourseStatus = "Ongoing"
  castedCourse.printDetails("Teacher")

  var student = Student("Arash Moradi" , "200#489" , "19.5" ,
                        "202.B","MaktabKhoneh","MaktabKhoneh.org Web School")
  student.printDetails("Student")

  var book = Book("Android Studio" , "Programmers unity" , "Java Katlin FXML and Developing Android apps",
    "Nobody","Android Development","Programming")
  book.printDetails()

  var classIntf = Class()
  classIntf.printLocation()
}
