package hamzaha.washington.edu.quizdroid;

import android.app.Application;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

/**
 * Created by iguest on 2/10/17.
 */

public class QuizApp extends Application {

    private TopicRepository instance = new Repository();
    private List<Topic> topics;

    public TopicRepository getRepository() {
        return instance;
    }

    public QuizApp() {
        Log.v("V", "OnCreate fired");
    }
}
