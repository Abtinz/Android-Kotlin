fun main() {
  var teacher = Teacher("Amir AHmad Adibie","9920339","Android std")
  teacher.printTeacherDetails()

  var student = Student("Arash Moradi" , "2003489" , "19.5" , "202.B")
  student.printStudentDetails()

  var book = Book("Android Studio" , "Programmers unity" , "Java Katlin FXML and Developing Android apps","Nobody")
  book.printBookDetails()

  var terms =Term()
  terms.term = "First"
  terms.printTerm()
}
