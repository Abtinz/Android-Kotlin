fun main() {

    var fatherName = "Mack"
    var fatherSallaryPerMonth = 20000

    var motherName = "Rose"
    var motherSallaryPerMonth = 12000

    var sonName : String
    sonName = "James"
    var sonSallaryPerMonth = 12000


    var uncleName = "Xavi"
    var uncleSallaryPerMonth = 150000

    var fatherSallaryPerYear : Int
    var motherSallaryPerYear : Int
    var sonSallaryPerYear : Int
    var uncleSallaryPerYear : Int

    //calculate year salary
    //we have tax for salary (100$ per month)
    val taxPerMonth = 100
    fatherSallaryPerYear = (fatherSallaryPerMonth  - taxPerMonth)* 12
    motherSallaryPerYear = (motherSallaryPerMonth  - taxPerMonth)* 12
    sonSallaryPerYear = (sonSallaryPerMonth  - taxPerMonth)* 12
    uncleSallaryPerYear = (uncleSallaryPerMonth  - taxPerMonth)* 12

    //show salaries
    println(
        "Name: " + fatherName +
                "\nSalary per Month: " + fatherSallaryPerMonth +
                "\nSalary per Year: " + fatherSallaryPerYear
    )

    println(
        "Name: " + motherName +
                "\nSalary per Month: " + motherSallaryPerMonth +
                "\nSalary per Year: " + motherSallaryPerYear
    )

    println(
        "Name: " + sonName +
                "\nSalary per Month: " + sonSallaryPerMonth +
                "\nSalary per Year: " +sonSallaryPerYear
    )

    println(
        "Name: " + uncleName +
                "\nSalary per Month: " + uncleSallaryPerMonth +
                "\nSalary per Year: " + uncleSallaryPerYear
    )
}