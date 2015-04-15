import scala.collection

object TreeGenerator {
	trait Generator[+T] {
		self =>

		def generate: T

		def map[S](f: T => S): Generator[S] = new Generator[S] {
			def generate = f(self.generate)
		}
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(288); 

	val integers = new Generator[Int] {
		def generate = scala.util.Random.nextInt()
	};System.out.println("""integers  : TreeGenerator.Generator[Int] = """ + $show(integers ));$skip(50); 
	
	val booleans = for (x <- integers) yield x > 0;System.out.println("""booleans  : TreeGenerator.Generator[Boolean] = """ + $show(booleans ));$skip(71); 

	def leafs: Generator[Leaf] = for {
		x <- integers
	}	yield Leaf(x);System.out.println("""leafs: => TreeGenerator.Generator[<error>]""");$skip(88); 
	
	def inners: Generator[Inner] = for {
		l <- trees
		r <- trees
	} yield Inner(l, r);System.out.println("""inners: => TreeGenerator.Generator[<error>]""");$skip(113); 

	def trees: Generator[Tree] = for {
		isLeaf <- booleans
		tree <- if (isLeaf) leafs else inners
	} yield tree;System.out.println("""trees: => TreeGenerator.Generator[<error>]""")}
	
}
