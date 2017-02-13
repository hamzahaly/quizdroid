package hamzaha.washington.edu.quizdroid;

import java.util.List;

/**
 * Created by iguest on 2/10/17.
 */

public interface TopicRepository {
    List<Topic> getAllTopics();
    List<Question> getAllQuestions();
    Topic getTopic();
    int getAnswer();
    Question getQuestion();

}
