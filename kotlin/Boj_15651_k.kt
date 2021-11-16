import java.util.*
import kotlin.properties.Delegates

class Boj_15651_k {

    private var N by Delegates.notNull<Int>()

    fun input() {
        val scan = Scanner(System.`in`)
        N = scan.nextInt()
    }

}