package com.example.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    TextView textView;


    ImageView imageView;
    Button sharebutton ,next,pre;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    textView =(TextView)findViewById(R.id.textview_1);

    imageView =(ImageView)findViewById(R.id.Image_view);
    sharebutton=(Button)findViewById(R.id.share_button);
 pre = (Button)findViewById(R.id.pre_but);
 next=(Button)findViewById(R.id.next_button);
  //  String dstory  = getIntent().getStringExtra("story"); //// only one item ke liye
        // textView.setText(dstory);



        String [] dstory =getIntent().getStringArrayExtra("storybundle");//fully array list for back and pre
        String [] dstroy2 = getIntent().getStringArrayExtra("storybundle1");


      position =getIntent().getIntExtra("position1",0);


        textView.setText(dstory[position]);
      textView.setText(dstroy2[position]);

       //int images = getIntent().getIntExtra("images",0);


  // imageView.setImageResource(images);


  sharebutton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent = new Intent();
          intent.setAction(Intent.ACTION_SEND);
          intent.putExtra(intent.EXTRA_TEXT,dstory[position]);
          intent.setType("text/plain");
          intent =Intent.createChooser(intent,"hii");
          startActivity(intent);
      }
  });

      pre.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              position = (position+1) % dstory.length;
              textView.setText(dstory[position]);
          }
      });

next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        position = (position-1) % dstory.length;
        textView.setText(dstory[position]);
    }
});


    }
}
