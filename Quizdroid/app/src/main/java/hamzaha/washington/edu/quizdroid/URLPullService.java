package hamzaha.washington.edu.quizdroid;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by iguest on 2/17/17.
 */

public class URLPullService extends IntentService {

    public URLPullService() {
        super("URLPullService");

    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        String urlToDownload = workIntent.getStringExtra("URL");
        ResultReceiver receiver = workIntent.getParcelableExtra("receiver");

        Bundle bundle = new Bundle();
        bundle.putString("resultValue", "My Result Value. Passed in: " + urlToDownload);

        receiver.send(PreferencesActivity.RESULT_OK, bundle);

        try {
            URL url = new URL(urlToDownload);
            URLConnection connection = url.openConnection();
            connection.connect();

            InputStream input = new BufferedInputStream(connection.getInputStream());

            // WHERE TO STORE FILE?
            OutputStream output = new FileOutputStream("/sdcard/");

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
