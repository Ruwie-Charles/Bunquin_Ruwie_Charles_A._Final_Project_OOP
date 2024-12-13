import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Represents the question in my quiz.
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

//Handl my quiz logic and operations.
class Quiz {
    private ArrayList<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    //use add question to the quiz
    public void addQuestion(Question question) {
        questions.add(question);
    }

    //use to starts the quiz and interacts with the user.
    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("\nNo questions available. Please add questions first!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("\nWelcome to the Animal Learning Quiz! Test your knowledge about animals.");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestionText());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int userAnswer = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Your answer (1-" + options.length + "): ");
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= options.length) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter a valid option (1-" + options.length + ").");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // if it was ainvalid input
                }
            }

            if (userAnswer == q.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + options[q.getCorrectAnswer() - 1]);
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
    }
}

//Handles the user menu for quiz interaction.
class Menu {
    private Quiz quiz;

    public Menu(Quiz quiz) {
        this.quiz = quiz;
    }

    //Displays the main menu and handles user input.
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Lets Have fun with ANIMALS! ====");
            System.out.println("1. Add a Question");
            System.out.println("2. Start Quiz");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // for the newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // if it was an invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    quiz.startQuiz();
                    break;
                case 3:
                    System.out.println("Thank you I Hope you had fun!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Adds a new question to AnimalQuiz by user input.
    private void addQuestion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the question text: ");
        String questionText = scanner.nextLine();

        int numOptions = 0;
        while (true) {
            try {
                System.out.print("Enter the number of options: ");
                numOptions = scanner.nextInt();
                scanner.nextLine(); // to take the newline character
                if (numOptions > 0) { // Its for to make a sute if its positive number
                    break;
                } else {
                    System.out.println("Please enter a positive number for the options.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the options.");
                scanner.next(); // if it was a invalid input
            }
        }

        String[] options = new String[numOptions];
        for (int i = 0; i < numOptions; i++) {
            System.out.print("Enter option " + (i + 1) + ": ");
            options[i] = scanner.nextLine();
        }

        int correctAnswer = 0;
        while (true) {
            try {
                System.out.print("Enter the correct option number (1-" + numOptions + "): ");
                correctAnswer = scanner.nextInt();
                if (correctAnswer >= 1 && correctAnswer <= numOptions) {
                    break;
                } else {
                    System.out.println("Please enter a valid option number (1-" + numOptions + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the correct option.");
                scanner.next(); // if it was invalid input
            }
        }

        quiz.addQuestion(new Question(questionText, options, correctAnswer));
        System.out.println("Question added successfully!");
    }
}

// Main class that will run the animal quiz program.
public class AnimalQuiz {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Menu menu = new Menu(quiz);

        // 1-2 questions
        quiz.addQuestion(new Question(
            "Which of the following is a mammal?",
            new String[]{"Eagle", "Shark", "Dolphin", "Crocodile"},
            3
        ));
        quiz.addQuestion(new Question(
            "What characteristic is unique to mammals?",
            new String[]{"Feathers", "Scales", "Hair or fur", "Cold-blooded"},
            3
        ));

        menu.displayMenu(); // Start the menu
    }
}
