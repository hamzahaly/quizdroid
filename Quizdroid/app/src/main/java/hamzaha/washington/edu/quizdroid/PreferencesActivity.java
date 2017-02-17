package hamzaha.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PreferencesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        //Text field to get URL from user
        EditText urlText = (EditText) findViewById(R.id.editText);
        String url = urlText.getText().toString();
        final Intent intent = new Intent(this, URLPullService.class);
        intent.putExtra("URL", url);

        //Button to begin background download
        Button urlButton = (Button) findViewById(R.id.url_button);
        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });

        //Spinner with choices of how many minutes to check for new downloads
        Spinner spinner = (Spinner) findViewById(R.id.minutes_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.minutes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String item = (String) parent.getItemAtPosition(pos);
        Log.v("TAG", item);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Log.v("TAG", "Nothing selected");
    }
}
