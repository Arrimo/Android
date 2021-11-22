package com.example.arrimo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button mainButton;

    TextView forgotPasswordButton;

    EditText emailTF;

    EditText passwordTF;

    ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkForRememberMe();

        emailTF = findViewById(R.id.editTextEmail);
        passwordTF = findViewById(R.id.editTextPassword);
        spinner = findViewById(R.id.progressBar);

        spinner.setVisibility(View.GONE);
        spinner.getIndeterminateDrawable();

        forgotPasswordButton = findViewById(R.id.forgtopassw);
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ForgotPassword.class);
                startActivity(myIntent);
            }
        });

        mainButton = findViewById(R.id.button2);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);

                String email = emailTF.getText().toString();
                String password = passwordTF.getText().toString();

                if (TextUtils.isEmpty(email) || (TextUtils.isEmpty(password))) {
                    System.out.println("Error");
                    spinner.setVisibility(View.GONE);
                    alert("Fehler", "Bitte füllen Sie alle Felder aus");
                } else {
                    System.out.println("email: " + email);
                    System.out.println("email: " + password);
                    signUserIn(email, password, v);
                }

            }
        });
    }

    public void signUserIn(String email, String password, View vv) {
        Boolean success = true;
        if (success == true) {
            spinner.setVisibility(View.GONE);
            moveToHomePage();
        } else {
            spinner.setVisibility(View.GONE);
            alert("Error", "Please Try Again");
        }
    }

    public void moveToHomePage() {
        Intent goToHomeScreen = new Intent(this, HomeScreen.class);
        startActivity(goToHomeScreen);
    }

    public void checkForRememberMe() {
        Boolean isExistingUser = true;
        if (isExistingUser == true) {
            moveToHomePage();
        }
    }

    private void alert(String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setTitle(title);
        dialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        System.out.println("seen error");
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

}