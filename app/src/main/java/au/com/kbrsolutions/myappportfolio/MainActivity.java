package au.com.kbrsolutions.myappportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String PACKAGE_SPOTIFY_STREAMER =
            "au.com.kbrsolutions.spotifystreamer";
    private final static String PACKAGE_BUILD_IT_BIGGER =
            "au.com.kbrsolutions.builditbigger.paid";
    private final static String PACKAGE_MELBOURNE_PUBLIC_TRANSPORT =
            "au.com.kbrsolutions.melbournepublictransport";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * Show Toast with the the message indicating which app will be launched.
     *
     * @param message   The text to show.  Can be formatted text.
     *
     */
    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),
                getString(R.string.buttonClickMsg, message), Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * Launch the an app depending on which button was clicked.
     *
     * @param view  Clicked button view.
     *
     */
    public void startApp(View view) {
        Button button = (Button) view;
        String buttonText = (String) button.getText();
        if (buttonText.equals(getString(R.string.spotify_streamer))) {
            Intent callIntent = getPackageManager().getLaunchIntentForPackage
                    (PACKAGE_SPOTIFY_STREAMER);
            startActivity(callIntent);
        } else if (buttonText.equals(getString(R.string.super_duo_scores))) {
            showMessage(buttonText);
        } else if (buttonText.equals(getString(R.string.super_duo_library))) {
            showMessage(buttonText);
        }
        else if (buttonText.equals(getString(R.string.build_it_bigger))) {
                Intent callIntent = getPackageManager().getLaunchIntentForPackage
                        (PACKAGE_BUILD_IT_BIGGER);
                if (callIntent != null) {
                startActivity(callIntent);
            }
        } else if (buttonText.equals(getString(R.string.xyz_reader))) {
            showMessage(buttonText);
        } else if (buttonText.equals(getString(R.string.capstone))) {
            Intent callIntent = getPackageManager().getLaunchIntentForPackage
                    (PACKAGE_MELBOURNE_PUBLIC_TRANSPORT);
            startActivity(callIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
