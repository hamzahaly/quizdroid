package hamzaha.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;

/**
 * Created by iguest on 2/10/17.
 */

public class QuizApp extends Application implements TopicRepository {

    private static TopicRepository repository;

    public static TopicRepository getInstance() {
        if (repository == null) {

        }
        return repository;
    }

    @Override
    public void onCreate() {
        Log.v("V", "OnCreate fired");
    }
}
