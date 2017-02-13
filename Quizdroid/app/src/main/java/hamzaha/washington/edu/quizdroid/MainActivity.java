package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = "TAG";
    public QuizApp quizAppState = new QuizApp();
    public ArrayList<Topic> topics = (ArrayList<Topic>) quizAppState.getRepository().getAllTopics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topics.add(new Topic("Math", "Default Description", 3));
        topics.add(new Topic("Physics", "Default Description", 3));
        topics.add(new Topic("Marvel Super Heroes", "Default Description", 3));

        final TopicAdapter topicAdapter = new TopicAdapter(this, topics);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(topicAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), SubjectActivity.class);
                Topic t = topicAdapter.getItem(i);

                Log.v(TAG, t.getTopicName());

                intent.putExtra("Subject", t.getTopicName());
                intent.putExtra("Description", t.getDescription());
                intent.putExtra("NumberOfQuestions", t.getNumberOfQuestions());

                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(clickListener);
    }

}
