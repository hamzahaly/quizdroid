package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends Activity {

    private int numberOfQuestionsLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        numberOfQuestionsLeft = getIntent().getIntExtra("NumberOfQuestionsLeft", 0);

        Button next = (Button) findViewById(R.id.next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do something on this button click
                //If there are more questions left
//                if (numberOfQuestionsLeft > 0) {
//                    Intent intent = new Intent(view.getContext(), QuestionActivity.class);
//                    intent.putExtra("NumberOfQuestions", numberOfQuestionsLeft);
//                    startActivity(intent);
//                } else {
//                    //Else there are no more questions left
//                    Intent intent = new Intent(view.getContext(), FinishActivity.class);
//                    startActivity(intent);
//                }
//                finish();
            }
        });
    }
}
