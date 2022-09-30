package com.alexandrohlopes.oopbasics2

// Super Class, Parent Class or Base Class. If it's not opened it can't be inherited by Child Classes
open class Car(override val maxSpeed: Double, val name : String, val brand : String) : Drivable {
    open var range : Double = 0.0 // You can only alter a property if it's opened

    fun extendRange(amount : Double) {
        if (amount > 0) {
            range += amount
        }
    }

    override fun drive() : String = "Driving the interface drive."

    open fun drive(distance : Double) {
        println("Drove for $distance KM.")
    }
}

// Sub Class, Child Class or Derived Class of Car
class EletricalCar(maxSpeed: Double, name : String, brand : String, batteryLife : Double) : Car(maxSpeed, name, brand) {

    var chargerType = "Type 1"

    override var range = batteryLife * 6 // This modifies the variable in the Parent Class

    override fun drive(distance: Double) { // This modifies the function in the Parent Class
        println("Drove for $distance KM on electricity.")
    }

    override fun brake() {
        super.brake() // Calls the function from its parent. The code bellow will override the parent code.
        println("Brake inside of eletric car")
    }

}

interface Drivable {
    val maxSpeed : Double
    fun drive() : String
    fun brake() {
        println("The drivable is braking.")
    }
}

fun main() {
    var fusca = Car(180.0,"Fusca", "Volkswagen")
    var teslaS = EletricalCar(200.0,"S-Model", "Tesla",85.0)

    /*
        Polymorphism is the ability to act accordingly to the situation.
        The Fusca is a regular car, the Tesla S is an electrical car - so the drive method will act differently.
     */
    fusca.drive(100.0)
    fusca.brake()
    teslaS.drive(510.0)
    teslaS.brake()
}