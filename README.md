# Code Golf: Write a program that makes 2 + 2 = 5

This is my attempt to solve the [above challenge](http://codegolf.stackexchange.com/questions/28786/write-a-program-that-makes-2-2-5).

It uses Spring AOP to make 2 + 2 = 5

The executable code lies in the jUnit test: `CalculatorTest`

To run the single test directly from Gradle commandline passing in the following Java System property: `-Dtest.single=Calculator` (i.e. using the command: `gradle -Dtest.single=Calculator test`).

A specific Gradle task: `calculatorTest` has also been created which can be invoked as: `gradle calculatorTest` 


---- 

Author: henry.g.brown@gmail.com

Date: June 2014
