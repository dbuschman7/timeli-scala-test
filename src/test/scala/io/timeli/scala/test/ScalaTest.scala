package io.timeli.scala.test

import org.scalatest.{FunSuite, Matchers}

class FibonacciTest extends FunSuite with Matchers {

  test("Fibonacci and Prime") {

    val sc = new Scala()

    // generate a list of the first 80 Fibonacci numbers
    val fibs = Time.repeated("Fibanacci", 100) {
      sc.fibonacci(80)
    }.head
    fibs should have size 80
    fibs.take(10) should be(List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))

    // split that list of fibonacci numbers into a list of 
    // even numbers and a list of odd numbers
    val results = Time.repeated("Fibanacci - Split", 100) {
      sc.split(fibs, sc.isEven)
    }.head

    val evens = results._1
    val odds = results._2

    evens should have size 27
    odds should have size 53
    evens.take(5) should be(List(0, 2, 8, 34, 144))
    odds.take(5) should be(List(1, 1, 3, 5, 13))

    // generate a list of the first 1000 prime numbers
    val primes = Time.repeated("Primes", 100) {
      sc.primes(1000)
    }.head
    primes should have size 1000
    primes.take(10) should be(List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))

    // generate a list of numbers, from the collections above, that are both
    // primes and fibonacci numbers and print them to the console 
    val fibPrimes = Time.repeated("Primes - Fibanacci", 100) {
      sc.fibPrimes(fibs, primes)
    }.head

    fibPrimes should be(List(2, 3, 5, 13, 89, 233, 1597))

    fibPrimes.foreach(println)
  }

}