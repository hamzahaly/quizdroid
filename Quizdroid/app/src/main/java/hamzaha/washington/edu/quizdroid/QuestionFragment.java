package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class QuestionFragment extends Fragment {

    public static final String TAG = "TAG";

    public int numberOfQuestionsLeft;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_question, container, false);

        final Button submitButton = (Button) view.findViewById(R.id.submit);
        submitButton.setEnabled(false);
        submitButton.setClickable(false);

        final SubjectActivity subjectActivity = (SubjectActivity) getActivity();
        numberOfQuestionsLeft = subjectActivity.getNumQuestions();

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                submitButton.setEnabled(true);
                submitButton.setClickable(true);
                switch(checkedId) {
                    case R.id.A:
                        Log.v(TAG, "Submitting A");
                        break;
                    case R.id.B:
                        Log.v(TAG, "Submitting B");
                        break;
                    case R.id.C:
                        Log.v(TAG, "Submitting C");
                        break;
                    case R.id.D:
                        Log.v(TAG, "Submitting D");
                        break;
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment answerFragment = new AnswerFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, answerFragment);
                fragmentTransaction.commit();
                subjectActivity.decrementNumQuestions();
            }
        });

        return view;
    }

}
