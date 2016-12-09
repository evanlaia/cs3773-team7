package thebobs.messaging;
/*
*This activity will handle individual chats and sending and displaying messages
*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.*;
import android.util.*;
import java.util.*;
import android.widget.Toast;



public class ChatActivity extends AppCompatActivity {
    private TextView textView ;
    private DatabaseReference FireBaseDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        textView = (TextView)findViewById(R.id.textView1);


        textView.setText("This is the user activity");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();


       // myRef.setValue(value);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
               // String value = dataSnapshot.getValue(String.class);
                //textView.setText(value+"\n"+"cat!!!!!!");

                //Map<String, Object> td = (HashMap<String,Object>) dataSnapshot.getValue();
                //List<Object> values = new List<>(td.values());


                List<String> lst = new ArrayList<String>(); // Result will be holded Here
                for(DataSnapshot dsp : dataSnapshot.getChildren()){
                    lst.add(String.valueOf(dsp.getKey())); //add result into array list
                }
                Log.d("list", lst.toString());

                //NOW YOU HAVE ARRAYLIST WHICH HOLD RESULTS




                for(String data:lst){
                    textView.setText(data);
                }





            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });




    }





}
