package hamzaha.washington.edu.quizdroid;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by iguest on 2/17/17.
 */

public class URLPullService extends IntentService {

    public URLPullService() {
        super("URLPullService");

    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        String dataString = workIntent.getDataString();
    }


}
