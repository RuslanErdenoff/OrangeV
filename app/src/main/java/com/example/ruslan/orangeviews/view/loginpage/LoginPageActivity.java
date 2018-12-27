package com.example.ruslan.orangeviews.view.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruslan.orangeviews.db.DataBaseInstance;
import com.example.ruslan.orangeviews.view.consultantView.ConsultantMainProfileActivity;
import com.example.ruslan.orangeviews.view.customerView.CustomerProfileActivity;
import com.example.ruslan.orangeviews.view.customerView.PasswordRecoveryActivity;
import com.example.ruslan.orangeviews.R;

public class LoginPageActivity extends AppCompatActivity {
    private String inputLogin;
    private String inputPassword;
    private EditText inputLoginText;
    private EditText inputPasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView textView = (TextView) findViewById(R.id.login_tool_bar_title);
        textView.setText("Войти в профиль");


         inputLoginText = (EditText)findViewById(R.id.input_login_edittext);
         inputPasswordText = (EditText)findViewById(R.id.input_password_edittext);

        inputLoginText.requestFocus();
        inputPasswordText.requestFocus();

    }
    public void recoveryPassword(View view){
        Intent intent = new Intent(this,PasswordRecoveryActivity.class);
        startActivity(intent);
    }
    public void doRegistration(View view){
        Intent intent = new Intent(this,RegistrationPageFirstActivity.class);
        startActivity(intent);

    }
    public void doLogin(View view){
        if(inputLoginText.getText()!=null && inputPasswordText.getText()!=null){
            inputLogin = inputLoginText.getText().toString();
            inputPassword = inputPasswordText.getText().toString();
            if(inputLogin.equals("admin")&&inputPassword.equals("123")){
                DataBaseInstance.createDB(this);
                Intent intent = new Intent(this,CustomerProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }else if(inputLogin.equals("admin")&&inputPassword.equals("321")){
                DataBaseInstance.createDB(this);
                Intent intent = new Intent(this,ConsultantMainProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }
    }
}
