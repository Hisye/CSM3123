fun main() {
    var favoriteActor: String? = "hisye"

    val lengthOfName = if(favoriteActor != null) {
      favoriteActor.length
    } else {
      0
    }
    println("The number of characters in your favorite actor's name is $lengthOfName.")
}