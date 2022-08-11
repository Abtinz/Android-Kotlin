package com.abtinandroidstdio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.abtinandroidstdio.calculator.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding //because of scope var
    var isSomeDigitEntered = false
    var isDotButtonClicked = false
    var isSecondNumberEntered = false
    var isOperationEntered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding view for easily id access
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this)) // alt enter --> split properties
        setContentView(binding.root)
        // binding. root will help us to alter our views with building and its like R.layout.activity_main
    }

    /*
        in this function we are casting view to button and then we will append the text of button to textView
        this is how we add the new clicked number to calculator view
     */
    fun onclickDigit(clickedNumber : View){
        val clickedButton = clickedNumber as Button
        if (isSomeDigitEntered){
            binding.textView.append(clickedButton.text)
        }
        else {
            if(isOperationEntered){
                binding.textView.append(clickedButton.text)
                isSecondNumberEntered = true
            }
            else{
                binding.textView.text = clickedButton.text
            }

            isSomeDigitEntered = true
        }
    }

    /*
         in this function we are checking entered dot or new dot symbol for floating point number
     */
    fun onDotClicked(view : View) {
        if (!isDotButtonClicked && isSomeDigitEntered){
            binding.textView.append(".")
            isDotButtonClicked = true
        }

        else if(!isSomeDigitEntered){
            Toast.makeText(this,"You have not entered a number yet" , Toast.LENGTH_LONG).show()
        }

        else{
            Toast.makeText(this,"You have entered dot symbol" , Toast.LENGTH_LONG).show()

        }
    }

    /*
        in this fun we are clearing all numbers of calculator view
     */
    fun clearAllNumbers(view: View){
        binding.textView.text = ""
        isSomeDigitEntered = false
        isDotButtonClicked = false
        isOperationEntered = false
        isSecondNumberEntered = false
    }

    /*
        in this function we are adding operation to our calculator text view
     */
    fun onclickOperator(clickedNumber : View){
        val clickedButton = clickedNumber as Button
        if (!isSomeDigitEntered && !isOperationEntered){
            if(clickedNumber.text.equals("√")){
                binding.textView.text = clickedButton.text
                isOperationEntered = true
                isSomeDigitEntered = false
                isDotButtonClicked = false
            }
            else  {
                Toast.makeText(this,"You have not entered a number yet" , Toast.LENGTH_LONG).show()
            }
        }
        else {
            if(isOperationEntered){
                if(clickedNumber.text.equals("√")){
                    binding.textView.text = clickedButton.text
                    isOperationEntered = true
                    isSomeDigitEntered = false
                    isDotButtonClicked = false
                }
                else{
                    if(!isSecondNumberEntered){
                        val textViewString = binding.textView.text
                        //how to use substring in kotlin
                        binding.textView.text = textViewString.substring(0, textViewString.length - 1) + clickedButton.text
                    }
                }

            }
            else{
                if(clickedNumber.text.equals("√")){
                    binding.textView.text = clickedButton.text
                    isOperationEntered = true
                    isSomeDigitEntered = false
                    isDotButtonClicked = false
                }
                else{
                    binding.textView.append(clickedButton.text)
                    isOperationEntered = true
                    isSomeDigitEntered = false
                    isDotButtonClicked = false
                }


            }

        }
    }


    fun calculateTheOperation(view : View){

        if(isOperationEntered && isSecondNumberEntered){
            val calculatorText = binding.textView.text
            if(calculatorText.contains("+")){
                val addArray = calculatorText.split("+")
                val firstNumber = addArray[0]
                val secondNumber = addArray[1]
                val result = firstNumber.toDouble() + secondNumber.toDouble()
                binding.textView.text = result.toString()
                isOperationEntered = false
                isSecondNumberEntered = false
                isDotButtonClicked = true
            }

            else if(calculatorText.contains("/")){
                val divideArray = calculatorText.split("/")
                val firstNumber = divideArray[0]
                val secondNumber = divideArray[1]
                if(secondNumber.toDouble() != 0.0){
                    val result = firstNumber.toDouble() / secondNumber.toDouble()
                    binding.textView.text = result.toString()
                    isOperationEntered = false
                    isSecondNumberEntered = false
                    isDotButtonClicked = true
                }else{
                    Toast.makeText(this,"Cant Divide to zero!",Toast.LENGTH_SHORT).show()
                }

            }

            else if(calculatorText.contains("*")){
                val multiplicationArray = calculatorText.split("*")
                val firstNumber = multiplicationArray[0]
                val secondNumber = multiplicationArray[1]
                val result = firstNumber.toDouble() * secondNumber.toDouble()
                binding.textView.text = result.toString()
                isOperationEntered = false
                isSecondNumberEntered = false
                isDotButtonClicked = true
            }

            else if(calculatorText.contains("^")){
                val powArray = calculatorText.split("^")
                val firstNumber = powArray[0]
                val secondNumber = powArray[1]
                val result =  firstNumber.toDouble().pow(secondNumber.toDouble())
                binding.textView.text = result.toString()
                isOperationEntered = false
                isSecondNumberEntered = false
                isDotButtonClicked = true
            }
            else if(calculatorText.contains("%")){
                val reminderArray = calculatorText.split("%")
                val firstNumber = reminderArray[0].toDouble()
                val secondNumber = reminderArray[1].toDouble()
                val result =  firstNumber % secondNumber
                binding.textView.text = result.toString()
                isOperationEntered = false
                isSecondNumberEntered = false
                isDotButtonClicked = true
            }

            else if(calculatorText.contains("√")){
                val rootArray = calculatorText.substring(1,calculatorText.length).toDouble()
                val result = sqrt(rootArray)
                binding.textView.text = result.toString()
                isOperationEntered = false
                isSecondNumberEntered = false
                isDotButtonClicked = true
            }

            else{
                 val calculatorWithoutFirstChar = calculatorText.substring(1, calculatorText.length)
                 if(calculatorText[0] == '-'){

                     if(calculatorWithoutFirstChar.contains("-")){
                         val rootArray = calculatorWithoutFirstChar.split("-")
                         val firstNumber = rootArray[0].toDouble() * (-1.0)
                         val secondNumber = rootArray[1].toDouble()

                         val result = firstNumber - secondNumber
                         binding.textView.text = result.toString()
                         isOperationEntered = false
                         isSecondNumberEntered = false
                         isDotButtonClicked = true
                     }

                 }

                 else{
                     if(calculatorText.contains("-")){
                         val minusArray = calculatorText.split("-")
                         val firstNumber = minusArray[0].toDouble()
                         val secondNumber = minusArray[1].toDouble()

                         val result = firstNumber - secondNumber
                         binding.textView.text = result.toString()
                         isOperationEntered = false
                         isSecondNumberEntered = false
                         isDotButtonClicked = true
                     }
                 }

            }

        }
    }


    fun clearOneDigitOrNumber(view: View){
        if (!isSomeDigitEntered && !isOperationEntered){
            Toast.makeText(this,"You have not entered a number yet" , Toast.LENGTH_LONG).show()
        }
        else if(binding.textView.text.length == 1){
            binding.textView.text = "0"
            isSomeDigitEntered = false
            if(binding.textView.text.last() == '√'){
                isOperationEntered = false
            }
        }
        else{
            val textViewString = binding.textView.text.subSequence(0,binding.textView.text.length -1)
            val lastChar = binding.textView.text.last()
            if(isSecondNumberEntered){
                if(lastChar == '.'){
                    isDotButtonClicked = false
                }
                if(isTheLastCharOperation(textViewString.last())){
                    isSecondNumberEntered = false
                    isSomeDigitEntered = false
                }

                binding.textView.text = textViewString
            }

            else if(!isSomeDigitEntered && isOperationEntered){
                isOperationEntered = false
                if(lastChar != '√'){
                    isSomeDigitEntered = true
                    if(textViewString.contains(".")){
                        isDotButtonClicked = true
                    }
                }
                binding.textView.text = textViewString
            }

            else{
                if(lastChar == '.')
                    isDotButtonClicked = false
                binding.textView.text = textViewString
            }
        }



    }

    private fun isTheLastCharOperation(textViewTXT : Char) : Boolean{

        if ((textViewTXT == '+') or  (textViewTXT == '-') or (textViewTXT  == '*' ) or
            (textViewTXT=='/' )or (textViewTXT == '%' )or
            (textViewTXT == '√' )or (textViewTXT == '^'))
            return true

        return false
    }
}
