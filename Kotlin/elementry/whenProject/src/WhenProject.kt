import java.util.*

fun main() {
   println("PLEASE ENTER YOUR SPECIAL DAY OF WEEK ")
   var scanner = Scanner(System.`in`)
   var dateIndex = scanner.nextInt()
   when (dateIndex){
       0 -> println("saturday")
       1 -> println("sunday")
       2 -> println("monday")
       3 -> println("tuesday")
       4 -> println("wednesday")
       5 -> println("Thursday")
       6 -> println("Friday")
       else -> println("LETS GO TO THE NEXT WEEK")
   }



}