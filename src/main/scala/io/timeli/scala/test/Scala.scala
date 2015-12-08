package io.timeli.scala.test

class Scala {

  // document how your answers work with comments, be verbose

  // return the first number of fibonacci numbers
  def fibonacci(number: Int): Seq[Long] = {
    // admittedly, fibonacci is a definitive scala example for Streams but i'll explain what's happening

    // we are defining a lazy immutable infinite Stream of fib numbers
    // it has to be lazy or the recursive stream technique is going to fail because the compiler will try to define
    // fibStream before it is used ... which is in it's own definition!
    lazy val fibStream: Stream[Long] =
      // The #:; operator is right associative so the reason we can use it here is due to .zip returning a stream below
      // the first fib number is zero so make a stream of 0 followed by the rest of fib seq
      0 #::
      // the second fib number is 1 so make a stream of 1 followed by the rest of fib seq
      1 #::
      // the handy zip method translates two streams into one stream of tuples
      // since rval is zipping its tail (that sounds painful) it is constructing the tuples we want to sum to make the next fib number
      fibStream.zip(fibStream.tail)
        // and here we are mapping the tuple to the sum of its two members
        .map(t => t._1 + t._2)
    // finally, we take the first n elements as a finite Stream having the quantity requested
    fibStream.take(number)
  }

  // given a sequence and a predicate, construct a tuple of sequences such that:
  // the first member of the tuple has elements with predicate evaluating to true
  // and the second member of the tuple has elements with the predicate evaluating to false
  def split[A](list: Seq[A], f: A => Boolean): (Seq[A], Seq[A]) = {
    // ... and that is exactly what the partition method of the list does
    // is this cheating and did you want me to write this algorithm manually?
    list.partition(f)
  }


  // again, this is a definitive example of using streams to calculate primes and not my original solution but i will explain
  def primes(number: Int): Seq[Int] = {
    // first, the basis of this algorithm for primes.
    // 1) a given number is prime if it is not a multiple of any smaller prime number
    // 2) helpful hint, only need to check smaller primes with a square less than our target value

    // the first prime is 2
    lazy val ps: Stream[Int] = 2 #::
      // tail is a stream with every number 3 and greater
      Stream.from(3)
        // keeping any numbers 3 and greater that are prime
        .filter(potentialPrime => ps
          // takeWhile gives items until the predicate fails
          // effect is to reduce to a stream of every smaller prime with a square <= the possible prime
          .takeWhile{lesserPrime => lesserPrime * lesserPrime <= potentialPrime}
            // predicate for our filter above, we must not be evenly divsible by any smaller practicle prime
            .forall{ practLesserPrime => potentialPrime % practLesserPrime > 0});

    // and finally, take the first n primes
    ps.take(number)
  }

  // return the intersection of fibs and primes
  // suggestion, "primeFib" sounds more appetizing
  def fibPrimes(fibs: Seq[Long], primes: Seq[Int]): Seq[Long] = {
    // this is exactly what the intersect method does
    // again, is this cheating the test and did you want me to write out an algorithm to do this?
    fibs.intersect(primes)
  }
}
