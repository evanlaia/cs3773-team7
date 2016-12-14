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
import java.util.concurrent.TimeUnit;

import android.widget.Toast;

import static java.util.concurrent.TimeUnit.*;


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


                Map<String, Object> newPost = (Map<String, Object>) dataSnapshot.getValue();
                List<String> lst = new ArrayList<String>();
               // Result will be holded Here
                for(DataSnapshot dsp : dataSnapshot.getChildren()){
                    lst.add(String.valueOf(dsp.getKey())); //add result into array list

                }

                Log.d("lisrrtertetertt",lst.toString());
                String childName="";

                for(String data:lst){

                    textView.setText(data);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    FireBaseDataBase.remove("-K2ib5JHRbbL0NrztUfO");

                }





            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        myRef.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to Firebase
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                textView = (TextView)findViewById(R.id.textView1);

                List<String>  textlist = new ArrayList<String>();
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                System.out.println("Author: " + newPost.get("name"));
                System.out.println("Message: " + newPost.get("text"));
                textlist.add(String.valueOf(newPost.get("text")));
                String print = "";
                for(String s : textlist) {
                    print += s;
                }

                textView.setText("BIRnnnnD MAN JR "+print);

               // Toast.makeText(getApplicationContext(), (String) newPost.get("text"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            //... ChildEventListener also defines onChildChanged, onChildRemoved,
            //    onChildMoved and onCanceled, covered in later sections.
        });



    }



}
