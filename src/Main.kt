
fun main() {

    //

    println("Radius of a Circle:")
    val circleRadius = readln()


    println("Width of a Rectangle:")
    val rectangleWidth = readln()

    println("Height of a Rectangle:")
    val rectangleHeight = readln()


    println("Radius of a Sphere:")
    val sphereRadius = readln()

    // Array
    val shapes: Array <Shape> = arrayOf(
        Circle(circleRadius.toDouble()),
        Rectangle(rectangleWidth.toDouble(),rectangleHeight.toDouble()),
        Sphere(sphereRadius.toDouble())
    )

    shapes.forEach {
        val name = it.getName()

        when(it) {
            is TwoDimensional -> println(name + ": " + it.calculateArea())
            is ThreeDimensional -> println(name + ": " + it.calculateVolume())
            else -> throw Exception("Error")

        }
    }
}

//Enum class
enum class ShapeType (shape: String) {
    CIRCLE("Circle"),
    RECTANGLE("Rectangle"),
    SPHERE("Sphere")

}

//Abstract class
abstract class Shape {

    abstract fun getName(): String

}

// Interface Two
interface TwoDimensional {
    fun calculateArea():Double

}

// Interface Three
interface ThreeDimensional {
    fun calculateVolume():Double

}



// Circle class
class Circle (val radius: Double) :Shape(), TwoDimensional {

    override fun getName():String {
        return ShapeType.CIRCLE.name
    }

    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

// Rectangle class
class Rectangle (val width: Double, val height: Double) : Shape(), TwoDimensional{

    override fun getName():String {
        return ShapeType.RECTANGLE.name
    }

    override fun calculateArea(): Double {
        return width*height
    }
}

// Sphere class
class Sphere (val radius : Double): TwoDimensional, ThreeDimensional, Shape(){


    override fun getName():String {
        return ShapeType.SPHERE.name
    }

    override fun calculateArea(): Double {
        return 4 * Math.PI * radius * radius
    }

    override fun calculateVolume(): Double {
        return (4/3) * Math.PI * radius * radius * radius
    }

}





