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
    private TextView textViews;
    private DatabaseReference FireBaseDataBase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText("This is the user activity");
       //textViews = (TextView)findViewById(R.id.textView2);
        //textViews.setText("This adasdady");

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

                    //textView.setText(data);
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
               // textViews = (TextView)findViewById(R.id.textView2);

                List<String>  textlist = new ArrayList<String>();
                List<String>  msglist = new ArrayList<String>();
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                System.out.println("Author: " + newPost.get("name"));
                System.out.println("Message: " + newPost.get("text"));
                textlist.add(String.valueOf(newPost.get("name")));
                msglist.add(String.valueOf(newPost.get("text")));
                String print = "";
                String prints = "";
                for(String s : textlist) {
                    print += s;

                }
                for(String s : msglist) {
                    prints += s;

                }

                textView.setText("Sender: "+print);
                //textViews.setText(prints);



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
