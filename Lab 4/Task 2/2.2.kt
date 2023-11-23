2.2.kt

fun main() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    
    solarSystem.remove("Future Moon")
    
    for (planet in solarSystem) {
    println(planet)
	}
}