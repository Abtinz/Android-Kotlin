fun main() {

    var fatherSalaryLastYear = 120000
    var fatherSalaryThisYear= 150000

    var sonSalaryLastYear = 80000
    var sonSalaryThisYear= 155000

    println("Last Year Salary:\nFather: ${fatherSalaryLastYear}\nSon: ${sonSalaryLastYear}")
    if(sonSalaryLastYear > fatherSalaryLastYear){
        println("The son's salary was higher than the father's salary in the previous year")
    }
    else if(sonSalaryLastYear < fatherSalaryLastYear){
        println("The son's salary was lower than the father's salary in the previous year")
    }
    else{
        println("The son's salary was equal with the father's salary in the previous year")
    }


    println("Current Year Salary:\nFather: ${fatherSalaryThisYear}\nSon: ${sonSalaryThisYear}")
    if(sonSalaryThisYear > fatherSalaryThisYear){
        println("The son's salary was higher than the father's salary in the current year")
    }
    else if(sonSalaryThisYear < fatherSalaryThisYear){
        println("The son's salary was lower than the father's salary in the current year")
    }
    else{
        println("The son's salary was equal with the father's salary in the current year")
    }

}