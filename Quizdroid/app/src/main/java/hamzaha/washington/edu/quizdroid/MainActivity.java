package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {

    public ArrayList<Subject> subjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjects.add(new Subject("Math", "Default Description", 3));
        subjects.add(new Subject("Physics", "Default Description", 3));
        subjects.add(new Subject("Marvel Super Heroes", "Default Description", 3));

        SubjectAdapter subjectAdapter = new SubjectAdapter(this, subjects);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(subjectAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), SubjectActivity.class);
                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(clickListener);
    }

}
