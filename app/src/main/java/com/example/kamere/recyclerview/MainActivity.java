package com.example.kamere.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Fruits> fruitsList;

    //Array of fruits names
    String[] names={"Apple","Strawberry","Pomegranates","Oranges","Watermelon","Bananas","Kiwi","Tomato","Grapes"};
    //Array of fruits desc
    String[] sntfNames={"Malus Domestica","Fragaria Ananassa ","Punica Granatum","Citrus Sinensis","Citrullus Vulgaris","Musa Acuminata","Actinidia Deliciosa","Solanum Lycopersicum","Vitis vinifera"};

    //Array of fruits images
    int[] image ={R.drawable.apple,R.drawable.strawberry,R.drawable.pomegranates,R.drawable.oranges,R.drawable.watermelon,R.drawable.banana,R.drawable.kiwi,R.drawable.tomato,R.drawable.grapes};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding views
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //item decorator to separate the items
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //setting layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialize fruits list
        fruitsList = new ArrayList<>();

        //method to load fruits
        loadfruits();

        //onItemClickListener
        recyclerView.addOnItemTouchListener(new FruitTouchListener(getApplicationContext(), new FruitTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Place item click action here
                Toast.makeText(getApplicationContext(),"You clicked "+names[position],Toast.LENGTH_SHORT).show();
            }
        }));


    }

    private void loadfruits() {

        for(int i=0; i<names.length;i++) {

            fruitsList.add(new Fruits(names[i], sntfNames[i], image[i]));
        }

        FruitAdapter adapter = new FruitAdapter(this,fruitsList);
        recyclerView.setAdapter(adapter);

    }
}
