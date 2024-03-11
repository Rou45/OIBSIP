package Project;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class Exam {
    private Question[] questions;

    public Exam(Question[] questions) {
        this.questions = questions;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Question " + (i + 1) + ": " + q.getQuestion());
            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            System.out.print("Your answer: ");
            int selectedOption = scanner.nextInt();
            if (q.isCorrect(selectedOption)) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.length);
    }
}

public class OnlineExamSystem {
    public static void main(String[] args) {
        
        User user = new User("username", "password");

        
        Question[] questions = {
            new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 2),
            new Question("What is the capital of France?", new String[]{"London", "Berlin", "Paris", "Madrid"}, 3),
            new Question("Who is the president of the USA?", new String[]{"Donald Trump", "Joe Biden", "Barack Obama", "George Washington"}, 2),
           
            new Question("What is the capital of Japan?", new String[]{"Tokyo", "Beijing", "Seoul", "Bangkok"}, 1),
            new Question("What is the chemical symbol for water?", new String[]{"W", "H2O", "CO2", "NaCl"}, 2),
            new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"Ernest Hemingway", "Harper Lee", "J.K. Rowling", "Charles Dickens"}, 2),
            new Question("What is the largest planet in our solar system?", new String[]{"Mars", "Venus", "Saturn", "Jupiter"}, 4)
        };

       
        Exam exam = new Exam(questions);

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (user.authenticate(username, password)) {
            System.out.println("Authentication successful. Starting exam...");
            exam.start();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}

