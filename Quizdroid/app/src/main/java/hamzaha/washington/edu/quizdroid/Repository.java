package hamzaha.washington.edu.quizdroid;

import java.util.List;

/**
 * Created by iguest on 2/10/17.
 */

public class Repository implements TopicRepository {
    private Repository instance;
    private int answer;
    private Topic topic;
    private List<Topic> topics;
    private Question question;


    @Override
    public List<Topic> getTopics() {
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
    public Repository getInstance() {
        return instance;
    }

    @Override
    public int getAnswer() {
        return 0;
    }

}
