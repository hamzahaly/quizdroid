package hamzaha.washington.edu.quizdroid;

/**
 * Created by iguest on 1/27/17.
 */

public class Topic {
    private String topicName;
    private String description;
    private  int numQuestions;
    //Need a way to store questions and answers to those questions

    public Topic(String subjectName, String description, int numQuestions) {
        this.topicName = subjectName;
        this.description = description;
        this.numQuestions = numQuestions;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfQuestions() {
        return numQuestions;
    }

}
