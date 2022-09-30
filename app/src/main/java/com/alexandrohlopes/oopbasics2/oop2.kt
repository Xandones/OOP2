package com.alexandrohlopes.oopbasics2

// Super Class, Parent Class or Base Class. If it's not opened it can't be inherited by Child Classes
open class Car(val name : String, val brand : String) {
    open var range : Double = 0.0 // You can only alter a property if it's opened

    fun extendRange(amount : Double) {
        if (amount > 0) {
            range += amount
        }
    }

    open fun drive(distance : Double) {
        println("Drove for $distance KM.")
    }
}

// Sub Class, Child Class or Derived Class of Car
class EletricalCar(name : String, brand : String, batteryLife : Double) : Car(name, brand) {

    var chargerType = "Type 1"

    override var range = batteryLife * 6 // This modifies the variable in the Parent Class

    override fun drive(distance: Double) { // This modifies the function in the Parent Class
        println("Drove for $distance KM on electricity.")
    }

}

fun main() {
    var fusca = Car("Fusca", "Volkswagen")
    var teslaS = EletricalCar("S-Model", "Tesla",85.0)

    /*
        Polymorphism is the ability to act accordingly to the situation.
        The Fusca is a regular car, the Tesla S is an electrical car - so the drive method will act differently.
     */
    fusca.drive(100.0)
    teslaS.drive(510.0)
}