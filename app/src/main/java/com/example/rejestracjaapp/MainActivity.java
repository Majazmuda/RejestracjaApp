package com.example.rejestracjaapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        Button submitButton = findViewById(R.id.submitButton);
        TextView messageTextView = findViewById(R.id.messageTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String repeatPassword = repeatPasswordEditText.getText().toString();

                if (TextUtils.isEmpty(email) || !email.contains("@")) {
                    messageTextView.setText("Nieprawidłowy adres e-mail");
                    return;
                }

                if (!password.equals(repeatPassword)) {
                    messageTextView.setText("Hasła się różnią");
                    return;
                }

                messageTextView.setText("Witaj, " + email);
            }
        });
    }
}
