package rungame;
import java.util.Scanner;

interface GameCategory {
    void start();
    String getCategoryName();
    int getNumberOfQuestions();
    boolean askQuestion();
}

interface Question {
    boolean askQuestion();
}

interface GameResult {
    void displayResult();
}

class GuessQuestGame implements GameCategory, Question, GameResult {
    private int score;
    private String playerName;
    private Scanner scanner;

    GuessQuestGame(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println("Welcome to Guess-Quest");
        System.out.print("Enter your WHIZard name: ");
        playerName = scanner.nextLine();
        System.out.println("Hello " + playerName + "! Please pick your desired category");
        System.out.println("1 - Human\n2 - Animal\n3 - Place");

        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (categoryChoice) {
            case 1:
                playGame(new HumanCategory());
                break;
            case 2:
                playGame(new AnimalCategory());
                break;
            case 3:
                playGame(new PlaceCategory());
                break;
            default:
                System.out.println("Invalid choice. Exiting game.");
                break;
        }
    }

    private void playGame(GameCategory category) {
        System.out.print("You picked " + category.getCategoryName() + "! Press S to start or C to cancel\n");
        char startChoice = scanner.nextLine().toUpperCase().charAt(0);

        if (startChoice == 'S') {
            category.start();
            score = 0;

            for (int i = 0; i < category.getNumberOfQuestions(); i++) {
                if (category.askQuestion()) {
                    score++;
                    System.out.println("Correct! Great job!");
                } else {
                    System.out.println("Wrong! Try again!");
                    i--; 
                }
            }

            displayResult();
        } else {
            System.out.println("Game canceled. Exiting.");
        }
    }

    @Override
    public boolean askQuestion() {
        return false;
    }

    @Override
    public void displayResult() {
        System.out.println("YOU GOT A TOTAL OF " + score + " POINTS " + playerName + "!");
        System.out.print("\nWant to play again? Y for yes N for no\n");
        System.out.println(" ");
        char playAgain = scanner.nextLine().toUpperCase().charAt(0);

        if (playAgain == 'Y') {
            start();
        } else {
            System.out.println("Exit program");
            scanner.close();
        }
    }

    @Override
    public String getCategoryName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumberOfQuestions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class HumanCategory implements GameCategory {
        private final String[] questions = {
            "\nWhich system in the human body is responsible for pumping blood? \nA) Respiratory System B) Nervous System C) Cardiovascular System D) Digestive System",
            "\nWhat is the powerhouse of the cell? \nA) Nucleus B) Mitochondria C) Ribosome D) Endoplasmic Reticulum",
            "\nWhich of the following is the largest organ in the human body? \nA) Heart B) Liver C) Skin D) Brain",
            "\nWhat is the process by which the body converts food into energy? \nA) Digestion B) Respiration C) Photosynthesis D) Metabolism",
            "\nHow many bones are there in the adult human body? \nA) 206 B) 156 C) 106 D) 306"
        };
        private final String[] answers = {"C", "B", "C", "D", "A"};

        private int currentQuestionIndex;

        @Override
        public void start() {
            System.out.println("\nHuman category started!");
            currentQuestionIndex = 0;
        }

        @Override
        public String getCategoryName() {
            return "Human";
        }

        @Override
        public int getNumberOfQuestions() {
            return questions.length;
        }

        public boolean askQuestion() {
            if (currentQuestionIndex < questions.length) {
                System.out.println(questions[currentQuestionIndex]);
                String userAnswer = scanner.nextLine().toUpperCase();

                if (userAnswer.equals(answers[currentQuestionIndex])) {
                    currentQuestionIndex++;
                    return true;
                } else {
                    System.out.println(" ");
                }
            }
            return false;
        }
    }

    private class AnimalCategory implements GameCategory {
        private final String[] questions = {
            "\nWhat is the largest mammal on Earth? \nA) Elephant B) Blue Whale C) Giraffe D) Polar Bear",
            "\nWhat is the primary diet of pandas? \nA) Eagle B) Parrot C) Penguin D) Owl",
            "\nWhich of these animals is not a member of the big cat family? \nA) Lion B) Tiger C) Leopard D) Hyena",
            "\nWhich bird is known for its ability to mimic human speech? \nA) Fish B) Bamboo C) Ants D) Berries",
            "\nWhich of the following animals is a marsupial? \nA) Kangaroo B) Elephant C) Cheetah D) Gorilla"
        };
        private final String[] answers = {"B", "B", "D", "B", "A"};

        private int currentQuestionIndex;

        @Override
        public void start() {
            System.out.println("\nAnimal category started!");
            currentQuestionIndex = 0;
        }

        @Override
        public String getCategoryName() {
            return "Animal";
        }

        @Override
        public int getNumberOfQuestions() {
            return questions.length;
        }

        public boolean askQuestion() {
            if (currentQuestionIndex < questions.length) {
                System.out.println(questions[currentQuestionIndex]);
                String userAnswer = scanner.nextLine().toUpperCase();

                if (userAnswer.equals(answers[currentQuestionIndex])) {
                    currentQuestionIndex++;
                    return true;
                } else {
                    System.out.println("Wrong! Try again!");
                }
            }
            return false;
        }
    }

    private class PlaceCategory implements GameCategory {
        private final String[] questions = {
            "\nWhich of the following is the largest continent on Earth? \nA) North America  B) Europe  C) Asia  D) Africa",
            "\nWhich city is known as the \"City of Love\" and is famous for the Eiffel Tower? \nA) Rome B) Paris C) New York D) Tokyo",
            "\nWhat is the capital city of Australia? \nA) Sydney B) Melbourne C) Canberra D) Brisbane",
            "\nWhich natural wonder is located between the borders of the United States and Canada? \nA) Grand Canyon B) Niagara Falls C) Great Barrier Reef D) Mount Everest",
            "\nWhich desert is the largest hot desert in the world? \nA) Sahara Desert B) Gobi Desert C) Atacama Desert D) Kalahari Desert"
        };
        private final String[] answers = {"C", "B", "C", "B", "A"};

        private int currentQuestionIndex;

        @Override
        public void start() {
            System.out.println("\nPlace category started!");
            currentQuestionIndex = 0;
        }

        @Override
        public String getCategoryName() {
            return "Place";
        }

        @Override
        public int getNumberOfQuestions() {
            return questions.length;
        }

        public boolean askQuestion() {
            if (currentQuestionIndex < questions.length) {
                System.out.println(questions[currentQuestionIndex]);
                String userAnswer = scanner.nextLine().toUpperCase();

                if (userAnswer.equals(answers[currentQuestionIndex])) {
                    currentQuestionIndex++;
                    return true;
                } else {
                    System.out.println("Wrong! Try again!");
                }
            }
            return false;
        }
    }
}

public class GuessQuest {
    public static void main(String[] args) {
        GuessQuestGame game = new GuessQuestGame("");
        game.start();
    }
}
