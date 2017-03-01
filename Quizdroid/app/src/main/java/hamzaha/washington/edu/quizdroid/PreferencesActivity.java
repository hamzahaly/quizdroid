package hamzaha.washington.edu.quizdroid;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PreferencesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public MyReceiver receiver;
    final Intent intent = new Intent(this, URLPullService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        setupServiceReceiver();

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            AlertDialog.Builder builder = new AlertDialog.Builder(PreferencesActivity.this);
            builder.setMessage("You have no access to Internet right now").setTitle("No Internet Connection");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            final AlertDialog dialog = builder.create();
            dialog.show();
        }


        //Text field to get URL from user
        EditText urlText = (EditText) findViewById(R.id.editText);

        //Button to begin background download
        final Button urlButton = (Button) findViewById(R.id.url_button);
        urlButton.setClickable(false);
        urlButton.setEnabled(false);

        urlText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_GO) {
                    String url = textView.getText().toString();
                    intent.putExtra("URL", url);
                    intent.putExtra("receiver", receiver);
                    if (url != null || url != "") {
                        urlButton.setEnabled(true);
                        urlButton.setClickable(true);
                    }
                }
                return handled;
            }
        });


        //Button logic
        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

                if (downloadManager.PAUSED_WAITING_TO_RETRY == 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PreferencesActivity.this);
                    builder.setMessage("Download failed retry or quit?").setTitle("Download failed");
                    builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            System.exit(1);
                        }
                    });
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        //Spinner with choices of how many minutes to check for new downloads
        Spinner spinner = (Spinner) findViewById(R.id.minutes_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.minutes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(0);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String item = (String) parent.getItemAtPosition(pos);
        Log.v("TAG", item);

        final PendingIntent pendingIntent = PendingIntent.getService(this.getApplicationContext(), 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, 1000, 6000 * Integer.parseInt(item), pendingIntent);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Log.v("TAG", "Nothing selected");
    }

    public void setupServiceReceiver() {
        receiver = new MyReceiver(new Handler());

        receiver.setReceiver(new MyReceiver.Receiver() {
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == RESULT_OK) {
                    String resultValue = resultData.getString("resultValue");
                    Toast.makeText(PreferencesActivity.this, resultValue, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
