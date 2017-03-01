package hamzaha.washington.edu.quizdroid;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
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

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

        Bundle bundle = new Bundle();
        bundle.putString("resultValue", "My Result Value. Passed in: " + urlToDownload);

        receiver.send(PreferencesActivity.RESULT_OK, bundle);

        try {
            URL url = new URL(urlToDownload);
            URLConnection connection = url.openConnection();
            connection.connect();

            if (downloadManager.PAUSED_WAITING_TO_RETRY == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
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

            InputStream input = new BufferedInputStream(connection.getInputStream());

            File storage = getBaseContext().getFilesDir();
            Log.v("TAG", storage.toString());
            // WHERE TO STORE FILE?
            OutputStream output = new FileOutputStream(storage.toString() + "/questions.json");

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
