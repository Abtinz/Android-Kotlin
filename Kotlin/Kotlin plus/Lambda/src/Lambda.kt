import java.util.Scanner

fun main(){
    //cast lambda
    val lambda_function = {stringKey : String  ->
        val text_len = stringKey.length
        println("your text length: $text_len")
    }
    getInput(lambda_function)

}
fun getInput(lambda_function: (String) -> Unit){
    print("Please enter your string to calculate the length of your text: ")
    val scanner = Scanner(System.`in`)
    val casting_string = scanner.next()
    lambda_function(casting_string)
}