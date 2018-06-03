package com.example.nika.menu_app.feature;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nika.menu_app.feature.Model.User;

public class SignUpActivity extends AppCompatActivity {

    MaterialEditText edtEmail, edtPassword, edtNickname, edtName;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtEmail = (MaterialEditText)findViewById(R.id.edtEmail);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtName = (MaterialEditText)findViewById(R.id.edtName);
        edtNickname = (MaterialEditText)findViewById(R.id.edtNickName);

        btnSignUp = (Button)findViewById(R.id.btnSingUp);

        final FirebaseDatabase database = new FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference()"User";

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener {}{

                    public void onDataChange(DataSnapshot) {
                    //Check if user is not exist in database
                    if(dataSnapshop.child(edtEmail.getText().toString()).exist())
                    {
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                        else {
                        mDialog.dismiss();
                    };
                            table_user.child(edtEmail.getText().toString().setValue(user));
                            Toast.makeText(SignUp.this, "SignUp successfully!", Toast.LENGTH_SHORT).show();
                            finish();
                        }


                });
            }
        });
    }
}
