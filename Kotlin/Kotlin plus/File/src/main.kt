import java.io.File


fun main(){
    // Create new file file
    val url = "Sample.txt"
    val file = File(url)
    val isFileCreated = file.createNewFile()
    if(isFileCreated)
        println("File is created in $url path")
}