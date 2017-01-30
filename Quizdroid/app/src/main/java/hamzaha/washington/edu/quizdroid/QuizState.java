package hamzaha.washington.edu.quizdroid;

/**
 * Created by iguest on 1/30/17.
 */

public class QuizState {
    int numberOfQuestions;
    //Array list of questions
    //Array list of answers
    //Dictionary of question answer pairs
    String subject;
    String description;

    public QuizState(int n, String s, String d) {
        numberOfQuestions = n;
        subject = s;
        description = d;
    }

    public int getNumQuestions() {
        return numberOfQuestions;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }
}
