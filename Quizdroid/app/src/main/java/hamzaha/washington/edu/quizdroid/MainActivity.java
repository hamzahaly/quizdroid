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

public class MainActivity extends Activity {

    private static final String TAG = "TAG";
    public ArrayList<Subject> subjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjects.add(new Subject("Math", "Default Description", 3));
        subjects.add(new Subject("Physics", "Default Description", 3));
        subjects.add(new Subject("Marvel Super Heroes", "Default Description", 3));

        final SubjectAdapter subjectAdapter = new SubjectAdapter(this, subjects);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(subjectAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), SubjectActivity.class);
                Subject s = subjectAdapter.getItem(i);

                Log.v(TAG, s.getSubjectName());

                intent.putExtra("Subject", s.getSubjectName());
                intent.putExtra("Description", s.getDescription());
                intent.putExtra("NumberOfQuestions", s.getNumberOfQuestions());

                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(clickListener);
    }

}
