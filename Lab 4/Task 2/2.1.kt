2.1.kt


fun main(){
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")

	val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    
    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

	val solarSystem = rockPlanets + gasPlanets
    solarSystem[3] = "Little Earth"
    
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])
    println(newSolarSystem[8])
}