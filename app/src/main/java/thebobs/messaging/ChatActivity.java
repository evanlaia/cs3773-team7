package thebobs.messaging;
/*
*This activity will handle individual chats and sending and displaying messages
*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;




public class ChatActivity extends AppCompatActivity {
    private TextView textView ;
    private DatabaseReference FireBaseDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText("This is the user activity");




    }
}
