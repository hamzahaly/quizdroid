package hamzaha.washington.edu.quizdroid;

/**
 * Created by iguest on 2/2/17.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OverviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SubjectActivity subjectActivity = (SubjectActivity) getActivity();
        String subject = subjectActivity.getSubject();
        String description = subjectActivity.getDescription();
        int numQuestions = subjectActivity.getNumQuestions();

        View view = inflater.inflate(R.layout.fragment_overview, container, false);


        Button beginButton = (Button) view.findViewById(R.id.begin);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment questionFragment = new QuestionFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations();
                fragmentTransaction.replace(R.id.fragment_container, questionFragment);
                fragmentTransaction.commit();
            }
        });

        TextView subjectNameTV = (TextView) view.findViewById(R.id.subject_name);
        TextView descriptionNameTV = (TextView) view.findViewById(R.id.subject_description);
        TextView numberQuestionsTV = (TextView) view.findViewById(R.id.subject_num_questions);

        subjectNameTV.setText(subject);
        descriptionNameTV.setText(description);

        String numberOfQuestions = "Number of Questions: " + numQuestions;
        numberQuestionsTV.setText(numberOfQuestions);
        return view;
    }
}
