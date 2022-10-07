package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private EditText email, pass;
    Button btnSignin;
    TextView txtSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        pass = (EditText)  findViewById(R.id.password);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        txtSignup = (TextView) findViewById(R.id.txtSignup);

        String passemail = getIntent().getStringExtra("email");
        String passPword = getIntent().getStringExtra("password");

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((email.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                        || (email.getText().toString().equals(passemail) && pass.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu chưa chính xác!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}