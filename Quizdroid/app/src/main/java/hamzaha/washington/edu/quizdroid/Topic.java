package hamzaha.washington.edu.quizdroid;

import android.widget.ImageView;

/**
 * Created by iguest on 1/27/17.
 */

public class Topic {
    private String topicName;
    private String description;
    private  int numQuestions;
    private int imgLocation;
    //Need a way to store questions and answers to those questions

    public Topic(String subjectName, String description, int numQuestions, int imgLocation) {
        this.topicName = subjectName;
        this.description = description;
        this.numQuestions = numQuestions;
        this.imgLocation = imgLocation;
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

    public int getImageIcon() {
        return imgLocation;
    }

}
