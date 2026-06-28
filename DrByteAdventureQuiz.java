import java.util.Scanner;

// ================================================================
//  PROGRAM NAME  : Dr. Byte's Adventure Quiz Game
//  LANGUAGE      : Java
//  NAME        : Kadri Omowunmi Sarah
//  MATRIC NO     : EU240102-4186
// ================================================================

//  WHAT THIS PROGRAM DOES:
//  ------------------------
//  This is a story-driven console quiz game set in the legendary
//  classroom of Dr. Byte — a mysterious and no-nonsense programming
//  lecturer feared by many, admired by few.

//  The player must answer 5 multiple-choice general knowledge
//  questions (A, B, C, or D). Each correct answer unlocks the next
//  part of Dr. Byte's story. One wrong answer interrupts the story
//  and gives the player a chance to retry or quit.

//  Answer all 5 correctly and the full story concludes — with
//  Dr. Byte's unforgettable final lesson revealed.

//  HOW TO PLAY:
//  ------------
//  1. Run the program.
//  2. Read each question carefully.
//  3. Type A, B, C, or D and press Enter.
//  4. Get it right → the story continues.
//     Get it wrong  → Dr. Byte reacts. Choose to retry or exit.
//  5. Answer all 5 correctly to reach the ending.

public class DrByteAdventureQuiz {

    // MAIN METHOD — the program starts here

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Tool to read what the user types

        printWelcome();

        // QUIZ DATA — questions, options, and correct answers

        String[] questions = {
                "1. What does 'CPU' stand for?",
                "2. Which programming language is known as the 'mother of all languages'?",
                "3. What symbol is used to end a statement in Java?",
                "4. What does 'RAM' stand for?",
                "5. Which of these is NOT a programming language?"
        };

        String[][] options = {
                {"A. Central Processing Unit", "B. Computer Power Unit",
                        "C. Central Program Utility",  "D. Control Processing Unit"},

                {"A. Python",  "B. Java",
                        "C. C",       "D. Ruby"},

                {"A. .",  "B. :",
                        "C. ;",  "D. !"},

                {"A. Random Access Memory",   "B. Read And Memorise",
                        "C. Random Array Module",    "D. Rapid Access Module"},

                {"A. Python", "B. Java",
                        "C. HTML",   "D. Kotlin"}
        };

        // Correct answers must match the user's input exactly (case-insensitive)
        String[] answers = {"A", "C", "C", "A", "C"};

        // Story segments that play AFTER each correct answer
        String[] storyParts = {
                "\n Dr. Byte nods slowly. 'Good. A programmer who doesn't know their CPU\n"
                        + " is like a mechanic who doesn't know what an engine is.'\n"
                        + " The class scribbles notes furiously.\n",

                "\n 'Correct,' says Dr. Byte. 'C gave birth to most of what you use today.\n"
                        + " Respect your roots — even if the roots look ugly and difficult.'\n"
                        + " A student whispers, 'Like this course.'\n"
                        + " Dr. Byte slowly turns his head. The student smiles innocently.\n",

                "\n Dr. Byte taps the board. 'The semicolon. The most hunted symbol in history.\n"
                        + " Students lose sleep over it. Relationships end because of it.'\n"
                        + " Everyone glances at their own code nervously.\n",

                "\n 'Random Access Memory. RAM.' Dr. Byte says flatly.\n"
                        + " 'Without enough of it, your laptop will move like a tortoise carrying debt.\n"
                        + " Don't buy a laptop with less than 8GB if you want to take this course\n"
                        + " and remain mentally stable.'\n",

                "\n Dr. Byte smiles — the rare, legendary Dr. Byte smile.\n"
                        + " 'HTML is a markup language, not a programming language.\n"
                        + " If anyone argues with you about this at a party, leave that party immediately.\n"
                        + " You don't need those people in your life.'\n"
                        + " The class erupts in laughter.\n"
        };

        // GAME LOOP — go through each question one by one

        int score = 0; // Tracks how many questions the player got right

        for (int i = 0; i < questions.length; i++) {

            printDivider();

            // Print the current question
            System.out.println("\n QUESTION " + (i + 1) + " of " + questions.length);
            System.out.println(" " + questions[i]);
            System.out.println();

            // Print the answer options
            for (String option : options[i]) {
                System.out.println("   " + option);
            }

            System.out.print("\n Your answer (A, B, C or D): ");
            String userAnswer = scanner.nextLine().trim(); // Read the user's input

            // Check if the answer is correct
            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("\n Correct! Well done.\n");
                System.out.println(storyParts[i]); // Continue the story
                score++; // Add 1 to the score
            } else {
                // Wrong answer — Dr. Byte reacts, story is interrupted
                System.out.println("\n Wrong answer! You said '" + userAnswer
                        + "', but the correct answer is '" + answers[i] + "'.");
                printDrByteReaction(i);

                // Ask if they want to try again from the start
                System.out.print("\n Would you like to try the quiz again? (yes / no): ");
                String retry = scanner.nextLine().trim();

                if (retry.equalsIgnoreCase("yes")) {
                    System.out.println("\n Restarting... Dr. Byte is watching.\n");
                    main(args); // Restart the whole game
                    return;     // Stop the current run
                } else {
                    printGameOver(score, questions.length);
                    scanner.close();
                    return; // Exit the program
                }
            }
        }

        // ENDING — player answered all 5 correctly

        printVictory(score);
        scanner.close();
    }

    // HELPER METHODS — smaller tasks handled separately

    /** Prints the welcome screen and story introduction */
    static void printWelcome() {
        printDivider();
        System.out.println();
        System.out.println("        DR. BYTE'S ADVENTURE QUIZ GAME");
        System.out.println("          Answer 5 Questions to Survive");
        System.out.println();
        printDivider();

        System.out.println("\n THE STORY SO FAR...\n");
        System.out.println(" There was a mysterious Programming lecturer known only as Dr. Byte.");
        System.out.println(" Nobody knew where she lived, what she ate, or if she even slept.");
        System.out.println(" Some students suspected she was secretly powered by Java code");
        System.out.println(" and pure Nigerian generator fumes.\n");

        System.out.println(" Dr. Byte took no nonsense.");
        System.out.println(" If a student said, \"MA, my code works on my laptop,\" she would reply:");
        System.out.println(" \"Then submit your laptop for grading. Let your laptop graduate for you.\"\n");

        System.out.println(" Today, you are one of her students.");
        System.out.println(" You must prove yourself worthy by answering 5 questions correctly.");
        System.out.println(" One wrong answer and the story stops — Dr. Byte does not tolerate failure.\n");

        System.out.println(" Are you ready? Then let us begin.");
        System.out.println(" (Type A, B, C or D and press Enter for each question)\n");
    }

    /** Prints a Dr. Byte-themed reaction for a wrong answer */
    static void printDrByteReaction(int questionIndex) {
        String[] reactions = {
                " Dr. Byte stares at you over her glasses.\n"
                        + " 'CPU. Central Processing Unit. Please go home and read.'",

                " Dr. Byte sighs the sigh of a woman who has seen too many wrong answers.\n"
                        + " 'C. The answer is C. Java did not come from Python. Kindly reconsider your life.'",

                " Dr. Byte pinches the bridge of her nose.\n"
                        + " 'The semicolon. The SEMICOLON. It is always the semicolon.\n"
                        + "  You have been warned about this since week one.'",

                " Dr. Byte writes your answer on the board, stares at it, then erases it slowly.\n"
                        + " 'Random Access Memory. RAM. This is not a guessing show.'",

                " Dr. Byte sets down her marker with terrifying calm.\n"
                        + " 'HTML is a markup language. If you thought it was a programming language,\n"
                        + "  I suggest you and Stack Overflow have a long, honest conversation tonight.'"
        };

        System.out.println("\n" + reactions[questionIndex]);
    }

    /** Prints the game over screen */
    static void printGameOver(int score, int total) {
        printDivider();
        System.out.println("\n  GAME OVER");
        System.out.println("\n  Dr. Byte adjusts her glasses and says:");
        System.out.println("  \"I am not angry. I am disappointed.");
        System.out.println("   And in this class, disappointment is worse than anger.\"\n");
        System.out.println("  Your score: " + score + " / " + total);
        System.out.println("\n  The story could not continue.");
        System.out.println("  Come back when you are ready to face Dr. Byte.\n");
        printDivider();
    }

    /** Prints the victory screen */
    static void printVictory(int score) {
        printDivider();
        System.out.println("\n  YOU SURVIVED DR. BYTE'S CLASS!");
        printDivider();
        System.out.println("\n  THE STORY CONCLUDES...\n");
        System.out.println("  Years later, you became a successful software developer.");
        System.out.println("  Whenever you solved a difficult problem at 2 a.m. with no light");
        System.out.println("  and Stack Overflow refusing to cooperate, you remembered Dr. Byte");
        System.out.println("  and whispered:\n");
        System.out.println("      \"The tough old witch was right.\"\n");
        System.out.println("  And whenever you found a missing semicolon after six hours of debugging,");
        System.out.println("  you added:\n");
        System.out.println("      \"God bless Dr. Byte... but small, small.\" \uD83E\uDDD9\u200D♂️\uD83D\uDCBB\uD83D\uDE02\n");
        System.out.println("  Final Score: " + score + " / 5  —  Perfect. Dr. Byte would be proud.");
        System.out.println("              (She will never admit it, but she would be proud.)\n");
        printDivider();
    }

    /** Prints a simple divider line */
    static void printDivider() {
        System.out.println(" ============================================================");
    }
}
