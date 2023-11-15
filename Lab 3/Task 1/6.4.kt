//hisye
fun main() {    
    val hisyeSong = Song("Its about her", "Hisye", 2023, 897)
    hisyeSong.printDescription()
    println(hisyeSong.isPopular)
}


class Song(
    val title: String, 
    val artist: String, 
    val yearPublished: Int, 
    val playCount: Int
){
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }   
}