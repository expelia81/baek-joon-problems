import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var array = IntArray(46)

    array[0] = 0
    array[1] = 1
    array[2] = 1
    array[3] = 2
    for (i in 2..n) {
        array[i] = array[i-1] + array[i-2]
    }
    bw.write(array[n].toString())

//    var st = StringTokenizer(br.readLine(), " ")
//    var n = st.nextToken()
//    var k = st.nextToken()
//    var result = 0L
//    for (c in n.toString().toCharArray()) {
//        var i = Integer.parseInt(c.toString())
//        for (d in k.toString().toCharArray()) {
//            var j = Integer.parseInt(d.toString())
//            result += i*j
//        }
//    }
//
//    bw.write(result.toString())

    bw.flush()
    br.close()
    bw.close()
}