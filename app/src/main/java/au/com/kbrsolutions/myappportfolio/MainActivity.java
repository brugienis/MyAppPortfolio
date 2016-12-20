package au.com.kbrsolutions.myappportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMessage(getString(R.string.spotifyClickMsg));
                startApp(v);
//                        spotifyClicked();
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMessage(getString(R.string.scoresClickMsg));
            }
        });

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMessage(getString(R.string.libraryClickMsg));
            }
        });

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMessage(getString(R.string.buildClickMsg));
                startApp(v);
            }
        });

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMessage(getString(R.string.backonClickMsg));
            }
        });

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showMessage(getString(R.string.capstoneClickMsg));
                startApp(v);
            }
        });
    }

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), getString(R.string.buttonClickMsg, message), Toast.LENGTH_SHORT).show();
    }

    private void startApp(View view) {
        Button button = (Button) view;
        String buttonText = (String) button.getText();
        Log.v("MainActivity", "startApp - buttonText: " + buttonText);
        if (buttonText.equals(getString(R.string.spotify_streamer))) {
            Intent callIntent = getPackageManager().getLaunchIntentForPackage("au.com.kbrsolutions.spotifystreamer");
            Log.v("MainActivity", "startApp - before start - callIntent: " + callIntent);
            startActivity(callIntent);
            Log.v("MainActivity", "startApp - after  start");
        } else if (buttonText.equals(getString(R.string.build_it_bigger))) {
//            Intent callIntent = getPackageManager().getLaunchIntentForPackage("au.com.kbrsolutions.builditbigger");
            Intent callIntent = getPackageManager().getLaunchIntentForPackage("au.com.kbrsolutions.builditbigger");
            Log.v("MainActivity", "startApp - before start builditbigger - callIntent: " + callIntent);
            if (callIntent != null) {
                startActivity(callIntent);
            }
            Log.v("MainActivity", "startApp - after  start builditbigger");
        } else if (buttonText.equals(getString(R.string.capstone))) {
            Log.v("MainActivity", "startApp - before start capstone");
            Intent callIntent = getPackageManager().getLaunchIntentForPackage("au.com.kbrsolutions.melbournepublictransport");
            startActivity(callIntent);
            Log.v("MainActivity", "startApp - after  start capstone");
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
