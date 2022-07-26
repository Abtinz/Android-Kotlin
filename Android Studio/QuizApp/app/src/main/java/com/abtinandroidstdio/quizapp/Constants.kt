package com.abtinandroidstdio.quizapp

class Constants {
    companion object {

        fun getQuestions(): ArrayList<Question> {
            var questionList = ArrayList<Question>()

            val question1 = Question(
                1, "What country does this flag belong to?‌", R.drawable.ic_flag_of_argentina,
                "Iran", "Saudi Arabia", "Turkey", "Argentina", 4 , "Buenos Aires"
            )

            val question2 = Question(
                2, "What country does this flag belong to?", R.drawable.ic_flag_of_brazil,
                "United States", "Brazil", "Afghanistan", "Argentina", 2 , "Brasilia"
            )

            val question3 = Question(
                3, "What country does this flag belong to?", R.drawable.ic_flag_of_india,
                "France", "Denmark", "Turkey", "India", 4 , "New Delhi"
            )

            val question4 = Question(
                4, "What country does this flag belong to?", R.drawable.ic_flag_of_germany,
                "Iran", "Germany", "Turkey", "Argentina", 2 , "Berlin"
            )

            val question5 = Question(
                5, "What country does this flag belong to?", R.drawable.ic_flag_of_denmark,
                "Iran", "Denmark", "Turkey", "Argentina", 2 , "Copenhagen"
            )

            val question6 = Question(
                6, "What country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,
                "New Zealand", "Denmark", "Turkey", "Argentina", 1 , "Wellington"
            )

            val question7 = Question(
                7, "What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,
                "Iran", "Denmark", "Kuwait", "Argentina", 3 , "Kuwait City"
            )
            questionList.add(question1)
            questionList.add(question2)
            questionList.add(question3)
            questionList.add(question4)
            questionList.add(question5)
            questionList.add(question6)
            questionList.add(question7)
            return questionList

        }
    }
}