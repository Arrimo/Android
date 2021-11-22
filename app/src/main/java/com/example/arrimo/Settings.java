package com.example.arrimo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.vorlonsoft.android.rate.AppRate;

public class Settings extends AppCompatActivity {

    Button ratingButton;
    Button changePasswordButton;
    Button logoutButton;

    TextView nameLabel;

    ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameLabel = findViewById(R.id.name_text_view);
        nameLabel.setText(findName());

        profileImageView = findViewById(R.id.profileImage);
        if (isMale() == true) {
            profileImageView.setImageResource(R.drawable.male_user);
        } else {
            profileImageView.setImageResource(R.drawable.female_user);
        }

        ratingButton = findViewById(R.id.ratingButton);
        ratingButton.setOnClickListener(view -> ratingButtonPressed());

        changePasswordButton = findViewById(R.id.changePasswordButton);
        changePasswordButton.setOnClickListener(view -> changePasswordButtonPressed());

        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(view -> logOutButtonPressed());
    }

    public void ratingButtonPressed() {
        System.out.println("rating");
        AppRate
//        AppRate.with(this)
//                .setStoreType(StoreType.GOOGLEPLAY) /* default is GOOGLEPLAY (Google Play), other options are AMAZON (Amazon Appstore), BAZAAR (Cafe Bazaar),
//         *         CHINESESTORES (19 chinese app stores), MI (Mi Appstore (Xiaomi Market)), SAMSUNG (Samsung Galaxy Apps),
//         *         SLIDEME (SlideME Marketplace), TENCENT (Tencent App Store), YANDEX (Yandex.Store),
//         *         setStoreType(BLACKBERRY, long) (BlackBerry World, long - your application ID),
//         *         setStoreType(APPLE, long) (Apple App Store, long - your application ID),
//         *         setStoreType(String...) (Any other store/stores, String... - an URI or array of URIs to your app) and
//         *         setStoreType(Intent...) (Any custom intent/intents, Intent... - an intent or array of intents) */
//                .setTimeToWait(Time.DAY, (short) 0) // default is 10 days, 0 means install millisecond, 10 means app is launched 10 or more time units later than installation
//                .setLaunchTimes((byte) 3)           // default is 10, 3 means app is launched 3 or more times
//                .setRemindTimeToWait(Time.DAY, (short) 2) // default is 1 day, 1 means app is launched 1 or more time units after neutral button clicked
//                .setRemindLaunchesNumber((byte) 1)  // default is 0, 1 means app is launched 1 or more times after neutral button clicked
//                .setSelectedAppLaunches((byte) 1)   // default is 1, 1 means each launch, 2 means every 2nd launch, 3 means every 3rd launch, etc
//                .setShowLaterButton(true)           // default is true, true means to show the Neutral button ("Remind me later").
//                .set365DayPeriodMaxNumberDialogLaunchTimes((short) 3) // default is unlimited, 3 means 3 or less occurrences of the display of the Rate Dialog within a 365-day period
//                .setVersionCodeCheck(true)          // default is false, true means to re-enable the Rate Dialog if a new version of app with different version code is installed
//                .setVersionNameCheck(true)          // default is false, true means to re-enable the Rate Dialog if a new version of app with different version name is installed
//                .setDebug(false)                    // default is false, true is for development only, true ensures that the Rate Dialog will be shown each time the app is launched
//                .setOnClickButtonListener(which -> Log.d(this.getLocalClassName(), Byte.toString(which))) // Java 8+, change for Java 7-
//                .monitor();                         // Monitors the app launch times
//
//        if (AppRate.with(this).getStoreType() == StoreType.GOOGLEPLAY) { // Checks that current app store type from library options is StoreType.GOOGLEPLAY
//            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this) != ConnectionResult.SERVICE_MISSING) { // Checks that Google Play is available
//                AppRate.showRateDialogIfMeetsConditions(this); // Shows the Rate Dialog when conditions are met
//            }
//        } else {
//            AppRate.showRateDialogIfMeetsConditions(this);     // Shows the Rate Dialog when conditions are met
//        }
    }

    public void changePasswordButtonPressed() {
        System.out.println("change password");
    }

    public void logOutButtonPressed() {
        System.out.println("logout");
        alert2Options("Warte!!","Möchten Sie sich wirklich ausloggen?");
    }

    public String findName() {
        return "Jorge";
    }

    public Boolean isMale() {
        return true;
    }

    private void alert2Options(String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setTitle(title);
        dialog.setPositiveButton("Ja",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        System.out.println("log out");
                        moveToSignIn();
                    }
                });
        dialog.setNegativeButton("Nein",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        System.out.println("no logout");
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    public void moveToSignIn() {
        Intent signInIntent = new Intent(this, MainActivity.class);
        startActivity(signInIntent);
    }

}