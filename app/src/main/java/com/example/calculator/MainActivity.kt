package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToInt
import kotlin.math.roundToLong

enum class Operation(val operand: String) {
    Plus("+"),
    Minus("-"),
    Multiply("*"),
    Divide("/"),
    NULL("NULL")
}
class MainActivity : AppCompatActivity() {
    lateinit var resultLabel: TextView
    lateinit var zero: Button
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var dot: Button
    lateinit var plus: Button
    lateinit var minus: Button
    lateinit var multiply: Button
    lateinit var divide: Button
    lateinit var clear: Button
    var startNumber = ""
    var num1 = ""
    var num2 = ""
    var result = ""
    var currentOperation = Operation.NULL
    val error = "На 0 делить нельзя!"
    var isDotPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultLabel = findViewById(R.id.tv_result)
        zero = findViewById(R.id.b_0)
        one = findViewById(R.id.b_1)
        two = findViewById(R.id.b_2)
        three = findViewById(R.id.b_3)
        four = findViewById(R.id.b_4)
        five = findViewById(R.id.b_5)
        six = findViewById(R.id.b_6)
        seven = findViewById(R.id.b_7)
        eight = findViewById(R.id.b_8)
        nine = findViewById(R.id.b_9)
        dot = findViewById(R.id.b_dot)
        plus = findViewById(R.id.b_plus)
        minus = findViewById(R.id.b_minus)
        multiply = findViewById(R.id.b_multiply)
        divide = findViewById(R.id.b_divide)
        clear = findViewById(R.id.b_clear)
    }
    fun zeroButton(view: View) {
        if (result != error) {
            if (startNumber != "0") {
                startNumber += "${zero.text}"
                resultLabel.text = startNumber
            }else {
                startNumber = "0." + "${zero.text}"
                resultLabel.text = startNumber
                isDotPressed = true
            }
        } else {
            return
        }
    }
    fun oneButton(view: View) {
        if (result != error) {
            startNumber += "${one.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun twoButton(view: View) {
        if (result != error) {
            startNumber += "${two.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun threeButton(view: View) {
        if (result != error) {
            startNumber += "${three.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun fourButton(view: View) {
        if (result != error) {
            startNumber += "${four.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun fiveButton(view: View) {
        if (result != error) {
            startNumber += "${five.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun sixButton(view: View) {
        if (result != error) {
            startNumber += "${six.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun sevenButton(view: View) {
        if (result != error) {
            startNumber += "${seven.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun eightButton(view: View) {
        if (result != error) {
            startNumber += "${eight.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun nineButton(view: View) {
        if (result != error) {
            startNumber += "${nine.text}"
            resultLabel.text = startNumber
        } else {
            return
        }
    }
    fun plusButton(view: View) {
        if (result != error) {
            if (resultLabel.text != ""){
                mathOperation(operation = Operation.Plus)
                plus.setBackgroundResource(R.color.orange)
                minus.setBackgroundResource(R.color.grey)
                multiply.setBackgroundResource(R.color.grey)
                divide.setBackgroundResource(R.color.grey)
            }else {
                return
            }
        } else {
            return
        }
    }
    fun minusButton(view: View) {
        if (result != error) {
            if (resultLabel.text != ""){
                mathOperation(operation = Operation.Minus)
                plus.setBackgroundResource(R.color.grey)
                minus.setBackgroundResource(R.color.orange)
                multiply.setBackgroundResource(R.color.grey)
                divide.setBackgroundResource(R.color.grey)
            }else {
                return
            }
        } else {
            return
        }
    }
    fun multiplyButton(view: View) {
        if (result != error) {
            if (resultLabel.text != "") {
                mathOperation(operation = Operation.Multiply)
                plus.setBackgroundResource(R.color.grey)
                minus.setBackgroundResource(R.color.grey)
                multiply.setBackgroundResource(R.color.orange)
                divide.setBackgroundResource(R.color.grey)
            }else{
                return
            }
        } else {
            return
        }
    }
    fun divideButton(view: View) {
        if (result != error) {
            if (resultLabel.text != "") {
                mathOperation(operation = Operation.Divide)
                plus.setBackgroundResource(R.color.grey)
                minus.setBackgroundResource(R.color.grey)
                multiply.setBackgroundResource(R.color.grey)
                divide.setBackgroundResource(R.color.orange)
            }else{
                return
            }
        } else {
            return
        }
    }
    fun dotButton(view: View) {
        if (result != error) {
            if (!isDotPressed) {
                if (startNumber != "") {
                    startNumber += "."
                } else {
                    startNumber = "0."
                }
                resultLabel.text = startNumber
                isDotPressed = true
            } else {
                return
            }
        }
    }
    fun clearButton(view: View) {
        num1 = ""
        num2 = ""
        result = ""
        startNumber = ""
        currentOperation = Operation.NULL
        resultLabel.text = ""
        isDotPressed = false
        plus.setBackgroundResource(R.color.grey)
        minus.setBackgroundResource(R.color.grey)
        multiply.setBackgroundResource(R.color.grey)
        divide.setBackgroundResource(R.color.grey)
    }
    fun mathOperation(operation: Operation) {
        if (currentOperation != Operation.NULL) {
            if (startNumber != "") {
                isDotPressed = false
                num2 = startNumber
                startNumber = ""
                if (currentOperation == Operation.Plus) {
                    result = "${num1.toFloat() + num2.toFloat()}"
                } else if (currentOperation == Operation.Minus) {
                    result = "${num1.toFloat() - num2.toFloat()}"
                } else if (currentOperation == Operation.Multiply) {
                    result = "${num1.toFloat() * num2.toFloat()}"
                } else if (currentOperation == Operation.Divide) {
                        result = "${num1.toFloat() / num2.toFloat()}"
                    if (num1 == "0" && num2 == "0"){
                        result = "Infinity"
                    }
                }
                if (result == "Infinity"){
                    result = error
                } else {
                    num1 = result
                    result = rightResult(arrResult(result))
                }
                resultLabel.text = result
            }
            currentOperation = operation
        } else {
            num1 = startNumber
            startNumber = ""
            currentOperation = operation
            isDotPressed = false
        }
    }
    fun equalityButton(view: View) {
        if (result != error) {
                isDotPressed = false
                mathOperation(operation = currentOperation)
        } else {
            return
        }
    }
    fun IsInteger(a: String) : Boolean {
        when (a) {
            "0" -> return true
            "1" -> return true
            "2" -> return true
            "3" -> return true
            "4" -> return true
            "5" -> return true
            "6" -> return true
            "7" -> return true
            "8" -> return true
            "9" -> return true
            else -> {
                return false
            }
        }
    }
    fun arrResult(result: String) : MutableList<String> {
            var arr: MutableList<String> = mutableListOf()
            var number = ""
            var count = 0
            for (i in result) {
                if (IsInteger(i.toString())) {
                    number += i
                    if (count == result.count() - 1) {
                        arr.add(number)
                    }
                } else {
                    arr.add(number)
                    arr.add(".")
                    number = ""
                }
                count += 1
            }
            return arr
    }
    fun rightResult(result: MutableList<String>) : String {
        if (result[2] == "0"){
            return  result[0]
        }else {
            return result[0] + result[1] + result[2]
        }

        return result.toString()
    }
}







