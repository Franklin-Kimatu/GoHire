package com.moringa.gohire.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.gohire.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.logoImage) ImageView mLogoImage;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.loginButton) Button mLoginButton;
    @BindView(R.id.noAccountTextView) TextView mNoAccountTextView;
    @BindView(R.id.signUpButton) Button mSignUpButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() !=null){

                    startActivity(new Intent(LoginActivity.this,Main1Activity.class));

                }
            }
        };


        mLoginButton.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v==mLoginButton) {
            startSign();
        }
        if(v ==mSignUpButton){
            startActivity(new Intent(LoginActivity.this,RegistryActivity.class));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSign(){
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this,"Field is empty",Toast.LENGTH_SHORT).show();
        }else{

            progressDialog.setMessage("Logging in...");
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Sign in problem",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }


}
