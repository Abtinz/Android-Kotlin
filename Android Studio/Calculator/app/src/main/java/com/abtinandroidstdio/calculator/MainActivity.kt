package com.abtinandroidstdio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.abtinandroidstdio.calculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding //because of scope var
    var isSomeDigitEntered = false
    var isDotButtonClicked = false
    var isSecondNumberEntered = false
    var isOperatoinEntered = false

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
            if(isOperatoinEntered){
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
        isOperatoinEntered = false
        isSecondNumberEntered = false
    }

    /*
        in this function we are adding operation to our calculator text view
     */
    fun onclickOperator(clickedNumber : View){
        val clickedButton = clickedNumber as Button
        if (!isSomeDigitEntered && !isOperatoinEntered){
            Toast.makeText(this,"You have not entered a number yet" , Toast.LENGTH_LONG).show()
        }
        else {
            if(isOperatoinEntered){
                if(!isSecondNumberEntered){
                    val textViewString = binding.textView.text
                    //how to use substring in kotlin
                    binding.textView.text = textViewString.substring(0, textViewString.length - 1) + clickedButton.text
                }
            }
            else{
                binding.textView.append(clickedButton.text)
                isOperatoinEntered = true
                isSomeDigitEntered = false
                isDotButtonClicked = false

            }

        }
    }


    fun calculateTheOperation(view : View){

        if(isOperatoinEntered && isSecondNumberEntered){
            val calculetorText = binding.textView.text
            if(calculetorText.contains("+")){
                val addArray = calculetorText.split("+")
                val firstNumber = addArray[0]
                val secondNumber = addArray[1]
                val result = firstNumber.toDouble() + secondNumber.toDouble()
                binding.textView.text = result.toString()
                isOperatoinEntered = false
                isSecondNumberEntered = false
            }

            else if(calculetorText.contains("/")){
                val devideArray = calculetorText.split("/")
                val firstNumber = devideArray[0]
                val secondNumber = devideArray[1]
                if(secondNumber.toDouble() != 0.0){
                    val result = firstNumber.toDouble() / secondNumber.toDouble()
                    binding.textView.text = result.toString()
                    isOperatoinEntered = false
                    isSecondNumberEntered = false
                }

            }

            else if(calculetorText.contains("*")){
                val multipactionArray = calculetorText.split("*")
                val firstNumber = multipactionArray[0]
                val secondNumber = multipactionArray[1]
                val result = firstNumber.toDouble() * secondNumber.toDouble()
                binding.textView.text = result.toString()
                isOperatoinEntered = false
                isSecondNumberEntered = false
            }

            else if(calculetorText.contains("^")){
                val powArray = calculetorText.split("^")
                val firstNumber = powArray[0]
                val secondNumber = powArray[1]
                val result =  firstNumber.toDouble().pow(secondNumber.toDouble())
                binding.textView.text = result.toString()
                isOperatoinEntered = false
                isSecondNumberEntered = false
            }


        }
    }


}
