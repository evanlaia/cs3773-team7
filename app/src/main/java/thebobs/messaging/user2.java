package thebobs.messaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class user2 extends AppCompatActivity {
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText("This is the user activity");
    }
}
