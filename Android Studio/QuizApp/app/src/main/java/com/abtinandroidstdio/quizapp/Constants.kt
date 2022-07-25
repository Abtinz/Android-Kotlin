package com.abtinandroidstdio.quizapp

class Constants {
    companion object {

        fun getQuestions(): ArrayList<Question> {
            var questionList = ArrayList<Question>()

            val question1 = Question(
                1, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_argentina,
                "ایران", "عربستان", "ترکیه", "آرژانتین", 4
            )

            val question2 = Question(
                2, "این پرچم متعلق به چه کشوری است  ؟", R.drawable.ic_flag_of_brazil,
                "آمریکا", "برزیل", "افغانستان", "آرژانتین", 2
            )

            val question3 = Question(
                3, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_india,
                "فرانسه", "دانمارک", "ترکیه", "هند", 4
            )

            val question4 = Question(
                4, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_germany,
                "ایران", "آلمان", "ترکیه", "آرژانتین", 2
            )

            val question5 = Question(
                5, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_denmark,
                "ایران", "دانمارک", "ترکیه", "آرژانتین", 2
            )

            val question6 = Question(
                6, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_new_zealand,
                "نیوزیلند", "دانمارک", "ترکیه", "آرژانتین", 1
            )

            val question7 = Question(
                7, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_kuwait,
                "ایران", "دانمارک", "کویت", "آرژانتین", 3
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