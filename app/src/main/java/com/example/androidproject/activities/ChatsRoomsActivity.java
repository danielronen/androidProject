package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidproject.R;
import com.example.androidproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class ChatsRoomsActivity extends AppCompatActivity {

    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_rooms);
    }

    public void goToChat(View view) {
        String roomID = "239ea67e-7b58-4c80-93ea-8f381f598f4f";
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("roomID", roomID);
        startActivity(intent);
    }

    public void showFriends(View view){
        User myUser = new User();
        myUser.setUserName(currentUser.getDisplayName());
        String content;
        if(myUser.getFriends() == null) {
            content = "No Friends Exists";
        }
        else{
            content = myUser.getFriends().toString();
        }
        TextView result = findViewById(R.id.textViewResult);
        result.setText(content);


    }
}
