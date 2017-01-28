package hamzaha.washington.edu.quizdroid;

/**
 * Created by iguest on 1/27/17.
 */

public class Subject {
    private String subjectName;
    private String description;
    private  int numQuestions;
    //Need a way to store questions and answers to those questions

    public Subject(String subjectName, String description, int numQuestions) {
        this.subjectName = subjectName;
        this.description = description;
        this.numQuestions = numQuestions;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfQuestions() {
        return numQuestions;
    }

}
