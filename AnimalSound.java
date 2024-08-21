//superclass Animal
class Animal{

    //superclass method
    void makeSound(){
        System.out.println("The animal makes a sound.");
    }
}

//subclasses
//Dog inherits class Animal
class Dog extends Animal{

    //overrides the Animal class makesound method
    @Override
    void makeSound() {
        System.out.println("The dog barks");
    }
}

//Cat inherits the Dog class
//multilevel inheritence
class Cat extends Dog{

    //overrides the Dog class makesound method
    @Override
    void makeSound() {
        System.out.println("The Cat meows");
    }
}

public class AnimalSound {
    public static void main(String[] args) {

      //creating Objects of each classes
      Animal animal = new Animal();
      Dog dog = new Dog();
      Cat cat = new Cat();

      //calling make sound method of each objects
       animal.makeSound();
       dog.makeSound();
       cat.makeSound();
    }
}
