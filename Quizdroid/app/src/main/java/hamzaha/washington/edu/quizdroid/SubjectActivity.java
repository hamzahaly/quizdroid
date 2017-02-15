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

    private String topic;
    private String description;
    private int numQuestions;
    private int imgLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        QuizApp quizApp = (QuizApp) getApplication();

        topic = quizApp.getRepository().getTopic().getTopicName();
        description = quizApp.getRepository().getTopic().getDescription();
        numQuestions = quizApp.getRepository().getTopic().getNumberOfQuestions();
        imgLocation = quizApp.getRepository().getTopic().getImgLocation();

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

    public String getSubject() {

        return topic;
    }

    public String getDescription() {
        return description;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public int getImgLocation() {
        return imgLocation;
    }
    public void decrementNumQuestions() {
        numQuestions--;
    }
}
