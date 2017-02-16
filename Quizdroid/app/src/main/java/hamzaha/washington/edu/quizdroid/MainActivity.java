package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.JsonReader;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuizApp quizApp = (QuizApp) getApplication();

        final File file = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath(), "questions.json");
        Log.v(TAG, file.toString());

        Log.v(TAG, String.valueOf(file.exists()));

        //FileOutputStream stream = new FileOutputStream(file);

        quizApp.getRepository().setTopic("Math", "Default Description", 3, R.mipmap.ic_launcher);
        quizApp.getRepository().setTopic("Physics", "Default Description", 3, R.mipmap.ic_launcher);
        quizApp.getRepository().setTopic("Marvel Superheroes", "Default Description", 3, R.mipmap.ic_launcher);

        final TopicAdapter topicAdapter = new TopicAdapter(this, (ArrayList<Topic>) quizApp.getRepository().getAllTopics());
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(topicAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), SubjectActivity.class);
                Topic t = topicAdapter.getItem(i);

                Log.v(TAG, t.getTopicName());
                

                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(clickListener);
    }

}
