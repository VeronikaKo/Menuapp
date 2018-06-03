package com.example.nika.menu_app.feature;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nika.menu_app.feature.Model.Common.Common;
import com.example.nika.menu_app.feature.Model.Home;
import com.example.nika.menu_app.feature.Model.User;

public class Main2Activity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtPassword =(MateriaEditText)findViewById(R.id.edtPassword);
        edtEmail =(MateriaEditText)findViewById(R.id.edtEmail);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        final FirebaseDatabase database = new FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference()"User";

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final  ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener()
                        @Override

                    public void onDataChange(DataSnapshot) {
                        //Check if user is not exist in database
                        if(dataSnapshop.child(edtEmail.getText().toString()).exist())
                        {
                            mDialog.dismiss();
                        User user = dataSnapshot.child(edtEmail.getText().toString().getValue(User.class));
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                {
                                    Intent homeIntent = new Intent(SingIn.this,Home.class);
                                    Common.currentuser = user;
                                    startActivity(HomeIntent);
                                    finish();
                                }

                }           else {
                                 Toast.makeText(SignIn.this, "SignIn failed!", Toast.LENGTH_SHORT).show();
                                }

                }
            }else
                {
                    mDialog.dismiss();
                    Toast.makeText(SignIn.this, "User not exist", Toast.LENGTH_SHORT).show();
                }
        }

    });
}
}

