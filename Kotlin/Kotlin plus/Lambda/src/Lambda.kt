import java.util.Scanner

fun main(){
    //cast lambda
    val lambda_function = {stringKey : String  ->
        println(stringKey.toInt())
    }
    getInput(lambda_function)

}
fun getInput(lambda_function: (String) -> Unit){
    print("Please enter your string to cast: ")
    val scanner = Scanner(System.`in`)
    var casting_string = scanner.next()
    lambda_function(casting_string)
}