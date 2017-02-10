package hamzaha.washington.edu.quizdroid;

/**
 * Created by iguest on 2/10/17.
 */

public class Question {
    public String questionsText;
    public int[] possibleAnswers;
    public int answer;

    public Question(String text, int[] answers, int answer) {
        questionsText = text;
        possibleAnswers = answers;
        this.answer = answer;
    }

    public String getQuestion() {
        return questionsText;
    }

    public int[] getPossibleAnswers() {
        return possibleAnswers;
    }

    public int getAnswer() {
        return answer;
    }
}
