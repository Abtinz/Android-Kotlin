import java.util.*

fun main() {
   println("PLEASE ENTER YOUR SPECIAL DAY OF WEEK\nguid : Week indexes are starting of 0(saturday) to 6(friday)")
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

    if(dateIndex>6){
        var reminderOfDateIndex = dateIndex % 7
        var dateRes = ""
        dateRes = when (reminderOfDateIndex){
            0 -> "saturday"
            1 -> "sunday"
            2 -> "monday"
            3 -> "tuesday"
            4 -> "wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            else-> "This Branch wont be used! "
        }
        println("correct date of week: ${dateRes}")
    }


}