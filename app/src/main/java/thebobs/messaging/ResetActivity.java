package thebobs.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
/**
 * Created by Catalyst on 12/1/2016.
 */

public class ResetActivity extends AppCompatActivity{
    private static final String TAG = "Reset Activity";
    private Button btnReset, btnBack;
    private FirebaseAuth auth;
    private EditText resetInputEmail;
    private TextInputLayout resetInputLayoutEmail;



    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        auth = FirebaseAuth.getInstance();

        resetInputLayoutEmail = (TextInputLayout) findViewById(R.id.reset_input_layout_email);

        resetInputEmail = (EditText) findViewById(R.id.reset_input_email);

        btnReset = (Button) findViewById(R.id.btn_reset);
        btnBack = (Button) findViewById(R.id.btn_back);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetPassword();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thebobs.messaging.ResetActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ResetPassword(){
        String email = resetInputEmail.getText().toString().trim();


        resetInputLayoutEmail.setErrorEnabled(false);


        if(!checkEmail()) {
            return;
        }

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
    };






    private boolean checkEmail() {
        String email = resetInputEmail.getText().toString().trim();
        if (email.isEmpty() || !isEmailValid(email)) {

            resetInputLayoutEmail.setErrorEnabled(true);
            resetInputLayoutEmail.setError(getString(R.string.err_msg_email));
            resetInputEmail.setError(getString(R.string.err_msg_required));
            requestFocus(resetInputEmail);
            return false;
        }
        resetInputLayoutEmail.setErrorEnabled(false);
        return true;
    }

    private static boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
