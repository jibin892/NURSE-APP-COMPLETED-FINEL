package com.msg91.sendotp.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Request extends AppCompatActivity {
    TextView pname,pname2,pname3;
    ImageView pname4;
    Intent i;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        pname=findViewById(R.id.pname);
        bt=findViewById(R.id.p_btn);
        pname2=findViewById(R.id.pname2);
        pname3=findViewById(R.id.pname3);
        pname4=findViewById(R.id.pname4);
        i=getIntent();
        pname.setText(i.getStringExtra("name"));
        pname2.setText(i.getStringExtra("name1"));
        pname3.setText(i.getStringExtra("name2"));
        //pname4.setText(i.getStringExtra("name3"));
        Picasso.get().load(i.getStringExtra("image")).into(pname4);




        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getApplicationContext(),Addrequset.class);
                j.putExtra("amount",pname.getText().toString());
                j.putExtra("pname",pname2.getText().toString());
                j.putExtra("pd",pname3.getText().toString());
                startActivity(j);
            }
        });

    }
}
