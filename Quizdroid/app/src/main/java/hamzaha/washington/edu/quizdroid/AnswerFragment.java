package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AnswerFragment extends Fragment {

    private int numberOfQuestionsLeft;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_answer, container, false);

        return view;
    }
//    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_answer);
////
////        numberOfQuestionsLeft = getIntent().getIntExtra("NumberOfQuestionsLeft", 0);
////
////        Button next = (Button) findViewById(R.id.next);
////
////
////        next.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                //Do something on this button click
////                //If there are more questions left
////                if (numberOfQuestionsLeft > 0) {
////                    Intent intent = new Intent(view.getContext(), QuestionActivity.class);
////                    intent.putExtra("NumberOfQuestions", numberOfQuestionsLeft);
////                    startActivity(intent);
////                } else {
////                    //Else there are no more questions left
////                    Intent intent = new Intent(view.getContext(), FinishActivity.class);
////                    startActivity(intent);
////                }
////                finish();
////            }
////        });
////    }
}
