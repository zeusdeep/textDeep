package com.ub.deep.textdeep;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUp extends ActionBarActivity {
    protected EditText mUserName,mPassword,mEmail;
    protected Button mSignBupButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mUserName =(EditText) findViewById(R.id.usernameField);
        mPassword=(EditText) findViewById(R.id.passwordField);
        mEmail=(EditText) findViewById(R.id.emailField);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }




    public void signUpButtonOnClick(View v)
    {
        String userName=mUserName.getText().toString().trim();
        String password=mPassword.getText().toString().trim();
        String email=mEmail.getText().toString().trim();

        if(userName.isEmpty() || password.isEmpty() || email.isEmpty())
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(SignUp.this);

            builder.setMessage(" Please Enter valid credentials");
            builder.setTitle("Error");
            builder.setPositiveButton(android.R.string.ok,null);
            AlertDialog dialog=builder.create();
            dialog.show();
        }

        else
        {
            //create a new user object

            ParseUser newUser=new ParseUser();
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setUsername(userName);
            newUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null)
                    {
                        //Success
                        Intent intent=new Intent(SignUp.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }

                    else
                    {
                        AlertDialog.Builder builder=new AlertDialog.Builder(SignUp.this);

                        builder.setMessage(e.getMessage().toString());
                        builder.setTitle("Error");
                        builder.setPositiveButton(android.R.string.ok,null);
                        AlertDialog dialog=builder.create();
                        dialog.show();
                    }

                }
            });
        }
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
