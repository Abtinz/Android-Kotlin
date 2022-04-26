fun main() {

  var course = Course(2000 , "Finished" , "Android Studio" ,
    "Amir AHmad Adibie","99@%339","MaktabKhoneh","MaktabKhoneh.org Web School")
  course.printDetails("Teacher")

  var student = Student("Arash Moradi" , "200#489" , "19.5" ,
                        "202.B","MaktabKhoneh","MaktabKhoneh.org Web School")
  student.printDetails("Student")

  var book = Book("Android Studio" , "Programmers unity" , "Java Katlin FXML and Developing Android apps",
    "Nobody","Android Development","Programming")
  book.printDetails()
}
