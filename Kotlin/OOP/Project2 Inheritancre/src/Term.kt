open class Term {
    var term :String? = null
      set(value) {
          if (value.equals("First")){
              field = value + "(fall and winter)"
          }
          else if (value.equals("Second")){
              field = value + "(Spring and Summer)"
          }

          else{
              field = "ERROR"
          }
      }

    fun printTerm(){
        println("Term: ${term}")
    }
}