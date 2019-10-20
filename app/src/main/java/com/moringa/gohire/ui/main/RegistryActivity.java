package com.moringa.gohire.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.gohire.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistryActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.nameCreateEditText) EditText mCreateNameCreateEditText;
    @BindView(R.id.emailCreateEditText) EditText mCreateEmailEditText;
    @BindView(R.id.passwordCreateEditText) EditText mCreatePasswordEDitText;
    @BindView(R.id.submitDetailsButton) Button mSubmitDetailButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth mFireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        ButterKnife.bind(this);
        mFireBaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        mSubmitDetailButton.setOnClickListener(this);
    }
    public  void RegisterUser(){
        String email = mCreateEmailEditText.getText().toString().trim();
        String password = mCreatePasswordEDitText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter valid email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        mFireBaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(RegistryActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistryActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(RegistryActivity.this,"Could not register.Please try again",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

        if( v== mSubmitDetailButton){
            RegisterUser();
        }

    }
}
