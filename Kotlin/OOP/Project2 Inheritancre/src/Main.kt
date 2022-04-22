fun main() {

  var course = Course(2000 , "Finished" , "Android Studio" ,
    "Amir AHmad Adibie","99@%339","MaktabKhoneh","MaktabKhoneh.org Web School")
  course.printCourseDetails()

  var teacher = Teacher("Amir AHmad Adibie","99@%339","Android std","MaktabKhoneh","MaktabKhoneh.org Web School")
  teacher.printTeacherDetails()


  var student = Student("Arash Moradi" , "200#489" , "19.5" ,
                        "202.B","MaktabKhoneh","MaktabKhoneh.org Web School")
  student.printStudentDetails()

  var book = Book("Android Studio" , "Programmers unity" , "Java Katlin FXML and Developing Android apps","Nobody")
  book.printBookDetails()

  var terms =Term()
  terms.term = "First"
  terms.printTerm()
}
