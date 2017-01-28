package hamzaha.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionActivity extends Activity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Button submitButton = (Button) findViewById(R.id.submit);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        submitButton.setEnabled(false);
        submitButton.setClickable(false);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Make a new intent

                //If there are more questions left
                Intent intent = new Intent(view.getContext(), AnswerActivity.class);
                startActivity(intent);

                //Else there are no more questions left
//                Intent intent = new Intent(view.getContext(), FinishActivity.class);
//                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        Log.v(TAG, "method called");
        boolean checked = ((RadioButton) view).isChecked();
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(true);
        submitButton.setClickable(true);

        switch(view.getId()) {
            case R.id.A:
                if (checked) {
                    //Submit answer A
                    Log.v(TAG, "Submitting A");
                }
                break;
            case R.id.B:
                if (checked) {
                    //Submit answer B
                    Log.v(TAG, "Submitting B");
                }
                break;
            case R.id.C:
                if (checked) {
                    //Submit answer C
                    Log.v(TAG, "Submitting C");
                }
                break;
            case R.id.D:
                if (checked) {
                    //Submit answer D
                    Log.v(TAG, "Submitting D");
                }
                break;
        }
    };
}
