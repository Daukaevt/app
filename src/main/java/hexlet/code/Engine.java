package hexlet.code;



import java.util.Random;

public class Engine {
     /**
     * ask game question.
     * @param quest current game quest.
     */
    public static void makeQuest(final String quest) {
        System.out.print("Question:  " + quest + "\nYour answer: ");
    }
    /**
     * gives a game quest answer.
     * @param correct game correct answer.
     */
    public static void checkInputAnswer(final String correct) {
        System.out.println(correct);
    }
    /**
     * Even game if even question.
     * @param max max rnd number.
     * @return if even question String.
     */
    public static int random(final int max) {
        Random rnd = new Random(); //instance of random class
        return rnd.nextInt(0, max);
    }
    /**
     * game points counter.
     * @param name user name string.
     */
    public static void congratulate(final String name) {
            System.out.println(
                    "Congratulations, " + name + "!");
    }
}
