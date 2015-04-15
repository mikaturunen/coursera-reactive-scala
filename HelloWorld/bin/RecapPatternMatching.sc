object test {
	// Super simple recaps on Functions and Pattern Matching to warm things up
	
	val f: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> f  : PartialFunction[String,String] = <function1>
	f("ping")                                 //> res0: String = pong
	f.isDefinedAt("foo")                      //> res1: Boolean = false
	
	val e: PartialFunction[List[Int], String] = {
		case Nil => "one"
		case x :: y :: rest => "two"
	}                                         //> e  : PartialFunction[List[Int],String] = <function1>
	
	e.isDefinedAt(List(1,2,3))                //> res2: Boolean = true
	
	// Proves that isDefinedAt applies only to the outer scope (first case Nil) and not the inner one
	val g: PartialFunction[List[Int], String] = {
		case Nil => "one"
		case x :: rest => {
			rest match {
				case Nil => "two"
			}
		}
	}                                         //> g  : PartialFunction[List[Int],String] = <function1>
	
	g.isDefinedAt(List(1,2,3))                //> res3: Boolean = true
}