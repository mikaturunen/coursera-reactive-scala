import scala.collection

object TreeGenerator {
	trait Generator[+T] {
		self =>

		def generate: T

		def map[S](f: T => S): Generator[S] = new Generator[S] {
			def generate = f(self.generate)
		}
	}

	val integers = new Generator[Int] {
		def generate = scala.util.Random.nextInt()
	}
	
	val booleans = for (x <- integers) yield x > 0

	def leafs: Generator[Leaf] = for {
		x <- integers
	}	yield Leaf(x)
	
	def inners: Generator[Inner] = for {
		l <- trees
		r <- trees
	} yield Inner(l, r)

	def trees: Generator[Tree] = for {
		isLeaf <- booleans
		tree <- if (isLeaf) leafs else inners
	} yield tree
	
}