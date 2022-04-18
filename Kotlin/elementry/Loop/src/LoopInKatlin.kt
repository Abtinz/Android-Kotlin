fun main() {
    
    println("Odd Numbers in (0,1000):\n//step by step")
    //show them with steps
    for(index in 1 until 1000 step 2){
        println(index)
    }

    println("Odd Numbers in (0,1000):\n//conditions")
    //show them with conditions
    for(index in 1 until 1000){
        if(index % 2 != 0)
                println(index)
    }
}