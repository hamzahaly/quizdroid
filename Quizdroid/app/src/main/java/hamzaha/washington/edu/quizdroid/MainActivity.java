package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final QuizApp quizApp = (QuizApp) getApplication();

        quizApp.getRepository().setTopic("Math", "Default Desc", 3, R.mipmap.ic_launcher);
        quizApp.getRepository().setTopic("Physics", "Default Desc", 3, R.mipmap.ic_launcher);
        quizApp.getRepository().setTopic("Marvel Superheroes", "Default Desc", 3, R.mipmap.ic_launcher);

        final TopicAdapter topicAdapter = new TopicAdapter(this, (ArrayList<Topic>) quizApp.getRepository().getAllTopics());
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(topicAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), SubjectActivity.class);
                Topic t = topicAdapter.getItem(i);

                Log.v(TAG, t.getTopicName());
                intent.putExtra("position", i);

                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(clickListener);
    }

}
