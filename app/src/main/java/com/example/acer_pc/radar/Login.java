package com.example.acer_pc.radar;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static android.R.attr.id;

/**
 * Created by Acer-PC on 19-Apr-17.
 */

public class Login extends MainActivity {

    public EditText et_userName, et_password;
    public String username, password;
    Button signInButton;

    LoginButton login_button;       //facebook login
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //connecting the java with xml
        setContentView(R.layout.activty_login);


        //adding login with fb buttons
        intializeControl();
        loginWithFB();


        //toastCat.cancel();

        et_userName = (EditText) findViewById(R.id.loginUsernameID);
        et_password = (EditText) findViewById(R.id.loginPasswordID);
        signInButton = (Button) findViewById(R.id.loginSignInId);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginButtonValidate();        //check the inputs in the edit text
            }
        });


    }

    private void loginButtonValidate() {
        intialize();          //Preparing the components by converting them to string;

        if (!validate()) {
            Toast.makeText(this, "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
        } else {
            onSignUpSuccess();
        }
    }

    private void onSignUpSuccess() {
        // TODO what will go after the valid input
        Toast.makeText(getApplicationContext(),"Successfully Signed In ",Toast.LENGTH_SHORT).show();

        signInBtnFun(null);   //CALLING A METHOD WITH A VIEW PARAMETER

    }

    private void signInBtnFun(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public boolean validate() {
        boolean valid = true;
        if (username.isEmpty()) {
            et_userName.setError("Please Enter A Valid Username!");
            valid = false;
        }
        if(password.isEmpty()){
            et_password.setError("Please Enter A Password!");
            valid=false;
        }

        return valid;
    }

    private void intialize() {
        username = et_userName.getText().toString().trim();
        password = et_password.getText().toString().trim();
    }



    //go to register when clicking on SignUp Button
    public void signUpFun(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Register",Toast.LENGTH_SHORT).show();
    }

    //fbLogInIntializer
    private void intializeControl() {
        callbackManager = CallbackManager.Factory.create();

        login_button = (LoginButton) findViewById(R.id.fbLogin_button);


    }

    //fbLoginManger
    private void loginWithFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(),"Successfully Logged In",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Login.this , MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Log In Cancelled",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),"Log In Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //fbLogin
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

   public void goToForgotPassword(View view){
       Intent intent = new Intent(Login.this , loginForgotPassword.class);
       startActivity(intent);
    }


}

