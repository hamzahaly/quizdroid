package hamzaha.washington.edu.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iguest on 2/10/17.
 */

public class Repository implements TopicRepository {
    private int answer;
    private Topic topic;
    private Question question;
    private int imgLocation;

    private List<Question> questions = new ArrayList<Question>();
    private List<Topic> topics = new ArrayList<Topic>();

    @Override
    public List<Topic> getAllTopics() {
        return topics;
    }

    @Override
    public Topic getTopic() {
        return topic;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public int getAnswer() {
        return 0;
    }

    @Override
    public int getImgLocation() {
        return imgLocation;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public void setTopic(String topic, String desc, int numQuestions, int imgLocation) {
        this.topic = new Topic(topic, desc, numQuestions, imgLocation);
        topics.add(this.topic);
    }

    @Override
    public void setAnswer() {

    }

    @Override
    public void setQuestion() {

    }
}
