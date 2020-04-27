package com.example.javamailapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.javamailapi.java_mail_api.GMailSender;
import com.example.javamailapi.java_mail_api.SendMailAsynchronously;

// 1. First Change the Project view to Project from Android.
// 2. app->libs (paste all the jars to the same folder in your application).
// 3. Now paste java_mail_api package to your project.
// 4. Don' forget to provide internet permission in manifest file.
// 5. Make sure your app level gradle contains the below line:
        //implementation fileTree(dir: 'libs', include: ['*.jar'])
// 6. Finally visit the below link and "Enable", "Access for less secure apps" radio button.
       //https://www.google.com/settings/security/lesssecureapps

public class MainActivity extends AppCompatActivity {

    private SendMailAsynchronously sendMailAsynchronously;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the object
        sendMailAsynchronously=new SendMailAsynchronously(this);

        findViewById(R.id.sendMail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setting up sender and receiver
                sendMailAsynchronously.setUpSenderAndReceiver("Paste SenderMailAddress Here",
                        "Paste Sender Password Here","Paste Receiver Mail Address Here");

                //setting up mail Subject and Body
                sendMailAsynchronously.sendMail( "Sending From the App","Mail Body");
            }
        });
    }



}
