package com.example.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.StackView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;

    String[] dStory;
    String [] dStory2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.list_view);
        String [] tStory =getResources().getStringArray(R.array.title_story);
        dStory = getResources().getStringArray(R.array.detail_story1);
        dStory2 =getResources().getStringArray(R.array.detail_story2);









     //   int [] imagegs = {R.drawable.image7,R.drawable.image7,R.drawable.image7,R.drawable.image7,R.drawable.image7};
          ArrayAdapter<String> customAdapter1 = new ArrayAdapter<String>
                  (this, android.R.layout.simple_list_item_1,tStory);

        listView.setAdapter(customAdapter1);

  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     //String t = dStory[position];    //  only one story.........get position...

         String t = tStory[position];
       //  String t1 = dStory[position];
        Bundle bundle;
     if (position ==0){

        bundle =new Bundle();
        bundle.putStringArray("bundle1",dStory);
        Intent intent  = new Intent(getApplicationContext(),MainActivity2.class);
         intent.putExtra("position1",position);
         intent.putExtras(bundle);
         startActivity(intent);

     }

      else if( position==1){
         Intent intent  = new Intent(MainActivity.this,MainActivity2.class);
         intent.putExtra("story2",dStory2);
         intent.putExtra("position1",position);
         intent.putExtra("posi",t);
         startActivity(intent);
     }

      else{


         Toast.makeText(MainActivity.this, " "+t+"  ", Toast.LENGTH_SHORT).show();
     }










    //   int t1 = imagegs[position];
        //   intent.putExtra("images",t1);
        // intent.putExtra("story",dStory) ;////// all items.........for back and pre.
       // intent.putExtra("story2",dStory2 );
       // intent.putExtra("position1",position);
        //intent.putExtra("posi",t);
      // startActivity(intent);
    }
   });










    }
}