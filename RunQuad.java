import java.util.Scanner;

class Quadrilateral {
    public void showDescription() {
        System.out.println("- is a quadrilateral");
    }
}

class Parallelogram extends Quadrilateral {
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.println("- has 2 pairs of parallel sides");
    }
}

class Rectangle extends Parallelogram {
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.println("- has 4 right angles");
    }
}

class Square extends Rectangle {
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.println("- has 4 equal sides");
    }
}

class Rhombus extends Parallelogram {
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.println("- has 4 congruent sides");
    }
}

class Trapezoid extends Quadrilateral {
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.println("- has 1 pair of parallel sides");
    }
}

public class RunQuad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char choice;

        do {
            System.out.println("\nPress R for Rectangle, S for Square, P for Parallelogram, H for Rhombus, T for Trapezoid, or Q to quit:");
            choice = scanner.next().charAt(0);

            Quadrilateral selectedShape;

            switch (choice) {
                case 'R':
                case 'r':
                    selectedShape = new Rectangle();
                    break;
                case 'S':
                case 's':
                    selectedShape = new Square();
                    break;
                case 'P':
                case 'p':
                    selectedShape = new Parallelogram();
                    break;
                case 'H':
                case 'h':
                    selectedShape = new Rhombus();
                    break;
                case 'T':
                case 't':
                    selectedShape = new Trapezoid();
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose R, S, P, H, T, or Q.");
                    continue;
            }

            selectedShape.showDescription();

        } while (choice != 'Q' && choice != 'q');

        scanner.close();
    }
}
