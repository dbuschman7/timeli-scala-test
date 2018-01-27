package io.timeli.scala.test

class Scala {

  // document how your answers work with comments, be verbose

  // Returns the first N fibonacci numbers.
  def fibonacci(number: Int): Seq[Long] = {
    def accumulator(previous2: Int, previous1: Int, accumulated: Seq[Long]): Seq[Long] = {
      val next = previous2 + previous1

      // If we have already accumulated the correct number of fibonacci's, just return the values gathered
      if (accumulated.size == number) accumulated
      // Otherwise kick off the next iteration
      else accumulator(previous1, next, accumulated :+ next)
    }

    // Some edge case handling first
    if (number <= 0) Nil
    // Now some base case handling
    else if (number == 1) Seq(0)
    else {
      accumulator(0, 1, Seq(0, 1))
    }
  }

  // Split a sequence based on predicate. Returns 2 sequences: first return seq is positives, second is negatives.
  def split[A](list: Seq[A], predicate: A => Boolean): (Seq[A], Seq[A]) = {
    // Group by the result of predicate
    val results = list.groupBy(predicate)

    val passed = results.getOrElse(true, Nil)
    val failed = results.getOrElse(false, Nil)

    (passed, failed)
  }

  // Generate the first N primes.
  def primes(number: Int): Seq[Int] = {
    // First we generate an infinite stream of numbers which may/may not be primes
    val possiblePrimes = 2 #:: Stream.from(3).filter(_ % 2 != 0)

    def isPrime(number: Int): Boolean = {
      // We only need to attempt to divide by odd numbers (and 2) which are smaller than the sqrt of the number we are checking.
      val potentialDivisors = possiblePrimes.takeWhile(divisor => divisor <= Math.sqrt(number))

      // If the number we are checking does not cleanly divide by any of the potential divisors then it is prime, else not.
      potentialDivisors.forall(number % _ != 0)
    }

    // Since we now have the ability to determine if a number is prime or not,
    // we can generate an infinite stream of prime numbers and only take the number of items that we care about.
    Stream.from(2).filter(isPrime).take(number)
  }

  // This is really just a set union problem...
  def fibPrimes(fibs: Seq[Long], primes: Seq[Int]): Seq[Long] = {
    primes.toSet.union(fibs.toSet).toSeq
  }
}
