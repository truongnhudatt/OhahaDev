package com.example.ohana_clone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ohana_clone.MainActivity;
import com.example.ohana_clone.R;
import com.example.ohana_clone.models.UserRequestSignup;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtFirstName, txtLastName;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtRetyePassword;
    private EditText txtEmail;
    private EditText txtPhone;

    private Button buttonSignup;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;

    private String reTypePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initParamFromView();
    }


    private void initParamFromView(){
        txtFirstName = findViewById(R.id.txtFristname);
        txtLastName = findViewById(R.id.txtLastname);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtRetyePassword = findViewById(R.id.txtRetypePassword);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        buttonSignup = findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = txtFirstName.getText().toString();
                lastName = txtLastName.getText().toString();
                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();
                reTypePassword = txtRetyePassword.getText().toString();
                email = txtEmail.getText().toString();
                phone = txtPhone.getText().toString();
                if(validateForm(firstName, lastName, username, password, reTypePassword, email, phone)){
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    UserRequestSignup userRequestSignup = new UserRequestSignup(firstName, lastName, username, password, email, phone);
                    goToMainActivity(userRequestSignup);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean validateForm(String firstName, String lastName, String username, String password, String reTypePassword, String email, String phone){
        if(firstName.length() == 0){
            txtFirstName.requestFocus();
            txtFirstName.setError("Vui lòng điền họ");
            return false;
        }
        else if(!firstName.matches("[a-zA-z]+")){
            txtFirstName.requestFocus();
            txtFirstName.setError("Ký tự không hợp lệ");
            return false;
        }
        return true;
    }

    private void goToMainActivity(UserRequestSignup userRequestSignup){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userRequestSignup", userRequestSignup);
        startActivity(intent);
    }

}