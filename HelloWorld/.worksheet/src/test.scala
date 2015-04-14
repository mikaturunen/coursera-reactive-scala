object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(159); 
	// Super simple recaps on Functions and Pattern Matching to warm things up
	
	val f: PartialFunction[String, String] = { case "ping" => "pong" };System.out.println("""f  : PartialFunction[String,String] = """ + $show(f ));$skip(11); val res$0 = 
	f("ping");System.out.println("""res0: String = """ + $show(res$0));$skip(22); val res$1 = 
	f.isDefinedAt("foo");System.out.println("""res1: Boolean = """ + $show(res$1));$skip(103); 
	
	val e: PartialFunction[List[Int], String] = {
		case Nil => "one"
		case x :: y :: rest => "two"
	};System.out.println("""e  : PartialFunction[List[Int],String] = """ + $show(e ));$skip(30); val res$2 = 
	
	e.isDefinedAt(List(1,2,3));System.out.println("""res2: Boolean = """ + $show(res$2));$skip(240); 
	
	// Proves that isDefinedAt applies only to the outer scope (first case Nil) and not the inner one
	val g: PartialFunction[List[Int], String] = {
		case Nil => "one"
		case x :: rest => {
			rest match {
				case Nil => "two"
			}
		}
	};System.out.println("""g  : PartialFunction[List[Int],String] = """ + $show(g ));$skip(30); val res$3 = 
	
	g.isDefinedAt(List(1,2,3));System.out.println("""res3: Boolean = """ + $show(res$3))}
}
