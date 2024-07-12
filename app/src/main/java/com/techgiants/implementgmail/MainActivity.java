package com.techgiants.implementgmail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button message,share,gmail,dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
   message=findViewById(R.id.btnmessage);
   share=findViewById(R.id.btnshare);
   gmail=findViewById(R.id.btnEmail);
   dial=findViewById(R.id.btndial);
   dial.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent idial=new Intent(Intent.ACTION_DIAL);
           idial.setData(Uri.parse("tel: +919528914140"));
           startActivity(idial);
       }
   });
   message.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent imessage=new Intent();
           imessage.setAction(Intent.ACTION_SENDTO);
           imessage.setData(Uri.parse("smsto:"+Uri.encode("+919528914140")));
           imessage.putExtra("sms_body","This is Akash");
           startActivity(imessage);
       }
   });
   gmail.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent igmail=new Intent();
           igmail.setAction(Intent.ACTION_SEND);
           igmail.setType("message/rfc822");
           igmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"akashsolanki926@gmail.com"});
           igmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
           igmail.putExtra(Intent.EXTRA_TEXT,"please make a lot of efforts");
           startActivity(Intent.createChooser(igmail,"via Email"));
       }
   });
   share.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent ishare=new Intent();
           ishare.setAction(Intent.ACTION_SEND);
           ishare.setType("text/plain");
           ishare.putExtra(Intent.EXTRA_TEXT,"Download this amazing game, https://play.google.com/store/apps/details?id=com.Rohit.IndianBikes&hl=en");
           startActivity(Intent.createChooser(ishare,"Share Via "));
       }
   });
    }
}