package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class SubjectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Button beginButton = (Button) findViewById(R.id.begin);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Make a new intent
                Intent intent = new Intent(view.getContext(), QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
