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

// You can create classes from a Abstract Class (Subclasses) but you can't instantiate objects from it.
abstract class Mammal(private val name : String, private val origin : String, private val weight : Double) { // Concrete (non abstract) Properties
    // Abstract Property (must be overridden by subclasses)
    abstract var maxSpeed : Double

    // Abstract Methods (must be implemented by subclasses)
    abstract fun run()
    abstract fun breath()

    // Concrete (non abstract) Method
    fun displayDetails() {
        println("Name: $name | Origin: $origin | Weight: $weight | Max Speed: $maxSpeed")
    }
}

// A Subclass can only inherit from one Class
class Human(name : String, origin : String, weight : Double, override var maxSpeed : Double) : Mammal(name,origin, weight) {
    override fun run() {
        println("Runs on two legs")
    }

    override fun breath() {
        println("Breath through mouth or nose")
    }
}

class Elephant(name : String, origin : String, weight : Double, override var maxSpeed : Double) : Mammal(name,origin, weight) {
    override fun run() {
        println("Runs on four legs")
    }

    override fun breath() {
        println("Breath through the trunk")
    }
}

fun main() {
    println("The next 2 variables are related to Interfaces")
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

    println("\nThe following part is related to Abstract Classes")
    val human = Human("Jodelle", "Canada",40.0, 25.0)
    val elephant = Elephant("Giganto", "Africa", 5400.0, 25.0)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
}