package hamzaha.washington.edu.quizdroid;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

/**
 * Created by iguest on 2/17/17.
 */

public class URLPullService extends IntentService {

    public URLPullService() {
        super("URLPullService");

    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        String url = workIntent.getStringExtra("URL");
        ResultReceiver receiver = workIntent.getParcelableExtra("receiver");

        Bundle bundle = new Bundle();
        bundle.putString("resultValue", "My Result Value. Passed in: " + url);

        receiver.send(PreferencesActivity.RESULT_OK, bundle);
    }


}
