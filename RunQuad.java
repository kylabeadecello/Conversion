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
            System.out.println("\nSelect from the following:");
            System.out.println("R - Rectangle");
            System.out.println("S - Square");
            System.out.println("P - Parallelogram");
            System.out.println("H - Rhombus");
            System.out.println("T - Trapezoid");
            System.out.println("Q - quit:");
            System.out.println(" ");
            choice = scanner.next().charAt(0);

            Quadrilateral selectedShape;

            if (choice == 'R' || choice == 'r') {
                        System.out.println("A rectangle:");
                        selectedShape = new Rectangle();
                    } else if (choice == 'S' || choice == 's') {
                        System.out.println("A square:");
                        selectedShape = new Square();
                    } else if (choice == 'P' || choice == 'p') {
                        System.out.println("A parallelogram:");
                        selectedShape = new Parallelogram();
                    } else if (choice == 'H' || choice == 'h') {
                        System.out.println("A rhombus:");
                        selectedShape = new Rhombus();
                    } else if (choice == 'T' || choice == 't') {
                        System.out.println("A trapezoid:");
                        selectedShape = new Trapezoid();
                    } else if (choice == 'Q' || choice == 'q') {
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        return;
                    } else {
                        System.out.println("Invalid choice. Please choose R, S, P, H, T, or Q.");
                        continue;
                    }

            selectedShape.showDescription();

        } while (choice != 'Q' && choice != 'q');

        scanner.close();
    }
}
