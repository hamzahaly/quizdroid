package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;

public class SubjectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        String subject = getIntent().getStringExtra("Subject");
        String description = getIntent().getStringExtra("Description");
        final int numQuestions = getIntent().getIntExtra("NumberOfQuestions", 3);

        QuizState quizState = new QuizState(numQuestions, subject, description);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment overviewFragment = new OverviewFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, overviewFragment);
        fragmentTransaction.commit();


//        Button beginButton = (Button) findViewById(R.id.begin);
//        beginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Make a new intent
//                Intent intent = new Intent(view.getContext(), QuestionActivity.class);
//
//                //Implement Parcebale to pass objects into Intents
//                intent.putExtra("NumberOfQuestions", numQuestions);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        TextView subjectNameTV = (TextView) findViewById(R.id.subject_name);
//        TextView descriptionNameTV = (TextView) findViewById(R.id.subject_description);
//        TextView numberQuestionsTV = (TextView) findViewById(R.id.subject_num_questions);
//
//        subjectNameTV.setText(subject);
//        descriptionNameTV.setText(description);
//
//        String numberOfQuestions = "Number of Questions: " + numQuestions;
//        numberQuestionsTV.setText(numberOfQuestions);

    }
}
