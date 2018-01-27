package io.timeli.scala.test

class Scala {

  // document how your answers work with comments, be verbose

  // Returns the first N fibonacci numbers.
  def fibonacci(number: Int): Seq[Long] = {
    def accumulator(previous2: Int, previous1: Int,  accumulated: Seq[Long]): Seq[Long] = {
      val next = previous2 + previous1

      // If we have already accumulated the correct number of fibonacci's, just return the values gathered
      if(accumulated.size == number) accumulated
        // Otherwise kick off the next iteration
      else accumulator(previous1, next, accumulated :+ next)
    }

    // Some edge case handling first
    if (number <= 0) Nil
      // Now some base case handling
    else if (number == 1) Seq(0)
    else {
      accumulator(0, 1, Seq(0,1))
    }
  }

  // Split a sequence based on predicate. Returns 2 sequences: first return seq is positives, second is negatives.
  def split[A](list: Seq[A], f: A => Boolean): (Seq[A], Seq[A]) = {
    // This is a super naive implementation and is slightly non-performant.
    // It performs 2 iterations over the list of items when only one is necessary.
    // Keeping it simple for now.
    val passed = list.filter(f)
    val failed = list.filter(!f(_))

    (passed, failed)
  }

  // Generate the first N primes.
  def primes(number: Int): Seq[Int] = {
    // use dynamic programming to store the result of if a number is prime or not.

  }

  // This is really just a set union problem...
  def fibPrimes(fibs: Seq[Long], primes: Seq[Int]): Seq[Long] = {
    primes.toSet.union(fibs.toSet).toSeq
  }
}
