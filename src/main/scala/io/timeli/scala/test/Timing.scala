package io.timeli.scala.test

object Time {

  def it[T](label: => String, output: String => Unit = (in) => println(in))(block: => T): T = {
    // run it
    val t0 = System.nanoTime()
    output(s"$label - Starting  ...")
    val result = block // call-by-name
    val t1 = System.nanoTime()

    // dump the results
    val millis = (t1 - t0) / (1000 * 1000)
    val rawSecs: Int = (millis.toDouble / 1000).floor.toInt
    val mins: Int = rawSecs / 60
    val secs: Int  = rawSecs - (mins * 60)

    (mins, secs) match {
      case (m, s) if m > 0   => output(s"$label - Elapsed Time: $m mins $s seconds")
      case (_, s) if s > 0   => output(s"$label - Elapsed Time: $s seconds")
      case (_, _)            => output(s"$label - Elapsed Time: $millis milliseconds")
    }

    result
  }

  def repeated[T](label: => String, runs:Int = 1, output: String => Unit = (in) => println(in))(block: => T): Seq[T] = it(label, output) {
    (1 to runs).map{ _ => block}
  }

}

