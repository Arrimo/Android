package com.example.arrimo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    Button mainButton;

    EditText emailTF;

    ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailTF = findViewById(R.id.editTextEmail3);
        spinner = findViewById(R.id.progressBar2);

        spinner.setVisibility(View.GONE);
        spinner.getIndeterminateDrawable();

        mainButton = findViewById(R.id.button3);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);

                String email = emailTF.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    System.out.println("Error");
                    spinner.setVisibility(View.GONE);
                    alert("Fehler", "Bitte füllen Sie alle Felder aus");
                } else {
                    System.out.println("email: " + email);
                    spinner.setVisibility(View.GONE);
                    sendRecoveryLink(email);
                }

            }
        });
    }

    public void sendRecoveryLink(String email) {
        Boolean success = true;
        if (success == true) {
            spinner.setVisibility(View.GONE);
            alert("Erfolg", "Passwort Reset Link wurde gesendet");
        } else {
            spinner.setVisibility(View.GONE);
            alert("Fehler", "Bitte versuche es erneut");
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