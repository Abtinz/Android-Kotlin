class Book constructor(Name:String , publisher:String , description:String , wrieter:String){

    var bookName:String? = null
        get() {
            return "\nBook Name: ${field}\n"
        }
    var bookPublisher:String? = null
        get() {
            return "Book Publisher: ${field}\n"
        }
    var bookDescription:String? = null
        get() {
            return "Book Description: ${field}\n"
        }
    var bookWriter:String? = null
        get() {
            return "Book Writer: ${field}\n"
        }

    init {

        bookDescription = description
        bookName = Name
        bookPublisher = publisher
        bookWriter = wrieter

    }

    fun printBookDetails()
    {
        println("Book Details: "+ bookName + bookWriter + bookPublisher + bookDescription)
    }

}