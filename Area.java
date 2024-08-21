//abstract class
abstract class Shape{
    abstract void calculateArea();
}

//rectangle class inherits shape
class Rectangle extends Shape{
    //instance variables
    int length;
    int breadth;
    //constructor
    Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    //overriding the parent class abstract method
    @Override
    void calculateArea() {
        System.out.println("Area of Rectangle with sides "+length+"x"+breadth+" : "+length*breadth);
    }
}

//circle inherits shape class
class Circle extends Shape{
    //instance variable
    double radius;

    //constructor
    Circle(double radius){
        this.radius = radius;
    }
    //overriding the parent abstract method
    @Override
    void calculateArea() {
        System.out.println("Area of Circle with radius "+radius+" is "+ Math.PI*radius*radius);
    }
}
public class Area {
    public static void main(String[] args) {
        //creating object of Rectangle
        Rectangle rect1 = new Rectangle(12,15);
        rect1.calculateArea();  //area of rectangle

        Rectangle rect2 = new Rectangle(30,15);
        rect2.calculateArea();

        //creating object of Circle class
        Circle c1 = new Circle(125);
        c1.calculateArea();

    }
}
