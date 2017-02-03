package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;

public class AnswerFragment extends Fragment {

    private int numberOfQuestionsLeft;
    public static final String TAG = "TAG";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_answer, container, false);

        SubjectActivity subjectActivity = (SubjectActivity) getActivity();
        numberOfQuestionsLeft = subjectActivity.getNumQuestions();
        Button next  = (Button) view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOfQuestionsLeft > 0) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Fragment questionFragment = new QuestionFragment();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, questionFragment);
                    fragmentTransaction.commit();
                } else {

                    Log.v(TAG, "" + numberOfQuestionsLeft);
                    FragmentManager fragmentManager = getFragmentManager();
                    Fragment finishFragment = new FinishFragment();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, finishFragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
