import java.io.File


fun main(){
    // Create new file file
    val url = "Sample.txt"
    val file = File(url)
    val isFileCreated = file.createNewFile()
    if(isFileCreated)
        println("File is created in $url path")

    //write and append
    file.writeText("Test 01\n")
    file.appendText("Test 02")

    //reading from file
    var index = 1
    file.forEachLine {
        println("Line$index :$it")
        index -=-1
    }

    //read all text
    val data = file.readText()
    println(data)
    
}