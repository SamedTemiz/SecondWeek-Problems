import java.util.Scanner

class Calculator {

    private val scanner = Scanner(System.`in`)

    private val operationsChar = listOf('+', '-', '*', '/')

    private var num1: Int? = null
    private var num2: Int? = null

    private var selectedOperation: Char? = null

    init {
        greetingMessage()

        selectOperation()

        getNumbers()
    }

    fun calculate() {
        var result = 0

        when (selectedOperation) {
            '+' -> {
                result = num1!! + num2!!
                println("Sonuç: $result")
            }
            '-' -> {
                result = num1!! - num2!!
                println("Sonuç: $result")
            }
            '*' -> {
                result = num1!! * num2!!
                println("Sonuç: $result")
            }
            '/' -> {
                if (num2 != 0) {
                    result = num1!! / num2!!
                    println("Sonuç: $result")
                } else {
                    println("Bölen sıfır(0) olamaz.")
                    num2 = null

                    getNumbers()
                    calculate()
                }
            }
            else -> {
                println("Geçersiz işlem seçildi.")
            }
        }
    }


    private fun selectOperation() {
        while (selectedOperation !in operationsChar) {
            try {
                println("Lütfen yapmak istediğiniz işlemi seçiniz")
                print("'+' '-' '*' '/': ")

                val input = scanner.nextLine()

                if (input.isNotEmpty()) {
                    selectedOperation = input[0]

                    if (selectedOperation !in operationsChar) {
                        println("Geçersiz işlem seçildi.")
                    }
                } else {
                    println("Geçersiz giriş. Lütfen bir işlem seçiniz.")
                }
            } catch (e: Exception) {
                println("Bir hata oluştu: ${e.message}")
            }
        }
    }

    private fun getNumbers() {
        while (num1 == null || num2 == null) {
            try {
                print("İlk sayı: ")
                val firstNum = scanner.nextLine()

                print("İkinci sayı: ")
                val secondNum = scanner.nextLine()

                if (firstNum.isNotEmpty() && secondNum.isNotEmpty()) {
                    num1 = firstNum.toInt()
                    num2 = secondNum.toInt()
                } else {
                    println("Geçersiz giriş. Lütfen sayıları giriniz.")
                }

            } catch (e: NumberFormatException) {
                println("Geçersiz giriş. Lütfen sadece sayıları giriniz.")
            } catch (e: Exception) {
                println("Bir hata oluştu: ${e.message}")
            }
        }
    }

    private fun greetingMessage() {
        println(" _ _ _     _                   \n" +
                "| | | |___| |___ ___ _____ ___ \n" +
                "| | | | -_| |  _| . |     | -_|\n" +
                "|_____|___|_|___|___|_|_|_|___|\n" +
                "                               ")
    }

}

fun main(args: Array<String>) {

    val calculator = Calculator()
    calculator.calculate()

}