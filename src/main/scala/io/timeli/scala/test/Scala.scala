package io.timeli.scala.test

class Scala {

  // document how your answers work with comments, be verbose

  // Start stream with 0 and 1, recursively add those two together and append to end of stream
  // Take specified count from list
  def fibonacci(number: Int): Seq[Long] = {
    lazy val fib: Stream[Long] = 0L #:: fib.scanLeft(1L)(_ + _)

    fib.take(number)
  }

  // Passed a method that turns a long into a boolean
  // Receiving list of sequences, partition based on whether even
  def split[A](list: Seq[A], f: A => Boolean): (Seq[A], Seq[A]) = {
    list.partition(f)
  }

  def isEven(a: Long): Boolean = {
    if (a % 2 == 0) true
    else false
  }

  // Stream of primes is found by doing modulo on each number proceeding it in stream
  // * primes function is passed a stream of all ints starting at 2
  // * for each number until number, primes does mod op on the highest number using each number
  //   before in int stream
  // Take specified amount from list
  def primes(number: Int): Seq[Int] = {
    lazy val primes: Stream[Int] => Stream[Int] = (s: Stream[Int]) =>
      s.head #:: primes(s.tail.filter(_ % s.head != 0))

    primes(Stream.from(2)).take(number)
  }

  // Maps over fibs, only allows values that are within primes
  def fibPrimes(fibs: Seq[Long], primes: Seq[Int]): Seq[Long] = fibs.filter(primes.contains)
}
