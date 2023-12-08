import java.util.Scanner;

abstract class Animal {
    abstract void makeSound();
    abstract void eat();
    abstract void sleep();    
}

class Bird extends Animal {
    void makeSound() {
        System.out.println("\nI am a bird! *chirp* *chirp*");
    }
    void eat() {
        System.out.println("Birds found worms to eat, and then");
    }    
    void sleep() {
        System.out.print("Sleep for a couple of hours *ZzZZZz*");
        System.out.println(" ");
    }

    void birdFigure() {
        System.out.println("\t   ___");
        System.out.println("\t  (o o)");
        System.out.println("\t (  v  )");
        System.out.println("\t/--m-m--/");
        System.out.print("----------------------------------------------------");
        System.out.println(" ");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("\nI am a cat! *meow* *meow*");
    }    
    void eat() {
        System.out.println("Cats love to eat fish and cat treats, after that ");
    }
    void sleep() {
        System.out.println("Goes to sleep throughout the entire day *ZzZzzzZZzZzzz* ");
    }

    void catFigure() {
        System.out.println("\t /\\_/\\");
        System.out.println("\t( o o )");
        System.out.println("\t = ^ =");
        System.out.println("\t || ||");
        System.out.println("\t((_|_))");
        System.out.print("----------------------------------------------------");
        System.out.println(" ");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("\nI am a dog! *woof!* *woof!*");
    }
    void eat() {
        System.out.println("Dogs love to eat their foods fast so they could play outside!");
    }
    void sleep() {
        System.out.println("Then they sleep for short hours *zZzZ*, then would play again!");
    }
    void dogFigure() {
        System.out.println("\t             __");
        System.out.println("\t(\\,--------'()'--o");
        System.out.println("\t (_    ___    /~");
        System.out.println("\t  (_)_)  (_)_)");
        System.out.print("----------------------------------------------------");
        System.out.println(" ");
    }
}

public class RunAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bird bird = new Bird();
        Cat cat = new Cat();
        Dog dog = new Dog();
        char choice;

        do {
            displayMenu();
            choice = scanner.next().toUpperCase().charAt(0);
            if (choice == 'B') {
                performAnimalActivities("Bird", bird);
                bird.birdFigure();
            } else if (choice == 'C') {
                performAnimalActivities("Cat", cat);
                cat.catFigure();
            } else if (choice == 'D') {
                performAnimalActivities("Dog", dog);
                dog.dogFigure();
            } else if (choice == 'E') {
                System.out.println("\nGoodbye *meow!* *chirp!* *woof!*");
            } else {
                System.out.println("Invalid choice. Please try again.");
                System.out.println(" ");
            }
        } while (choice != 'E');
    }

    private static void displayMenu() {
        System.out.println("Press a letter to choose an Animal (Press 'E' to exit)");
        System.out.println("B.) To pick the BIRD");
        System.out.println("C.) To pick the CAT");
        System.out.println("D.) To pick the DOG");
        System.out.println("E.) To EXIT the program");
    }

    private static void performAnimalActivities(String animalName, Animal animal) {
        System.out.println("\n\tLook what the " + animalName + " does!");
        System.out.print("----------------------------------------------------");
        animal.makeSound();
        animal.eat();
        animal.sleep();
        
    }
}
