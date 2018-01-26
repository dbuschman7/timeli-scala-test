package io.timeli.scala.test

class Scala {

  // document how your answers work with comments, be verbose
  
  def fibonacci(number: Int): Seq[Long] = ???

  def split[A](list: Seq[A], f: A => Boolean): (Seq[A], Seq[A]) = {
    val passed = list.filter(f)
    val failed = list.filter(!f(_))

    (passed, failed)
  }

  def primes(number: Int): Seq[Int] = ???

  def fibPrimes(fibs: Seq[Long], primes: Seq[Int]): Seq[Long] = ???
}
