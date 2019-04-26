package com.example.acer_pc.radar;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public SearchResultAdapter adapter;
    ArrayList<SearchProduct> arrayList =new ArrayList<>();


    private  int [] images   ={R.drawable.car1,R.drawable.car2,R.drawable.truck1,R.drawable.truck2,R.drawable.motorcycle1,R.drawable.motorcycle2,
            R.drawable.heavyequipment1,R.drawable.heavyequipment2,R.drawable.vehiclesparts1,R.drawable.vehiclesparts2,R.drawable.watercraft1,R.drawable.watercrafts2};

    private String [] titles ={"Acura MDX","nissan bluebird ","Mantega 460"," Actross mp2"," M109 Suzuki","airbrush 919","Mcv 400","Nissan 1994",
            "Alloy wheels and tires Palace","Back Speakers","Crownline 220 LS 5.0L 320HP","Speed Boat"};
    private String [] state  ={"Buy","Rent","Buy","Rent","Buy","Rent","Buy","Rent","Buy","Rent","Buy","Rent"};
    private String [] condition={"New","Used","Used","New","Used","Used","New","Used","Used","New","Used","Used",};
    private String [] region={"District 1","District 2","District 3","District 4", "District 1","District 2","District 3","District 4", "District 1","District 2","District 3","District 4"};
    private String [] price={"67000","5000","43000","140000","7500","24000","67000","5000","43000","140000","7500","24000"};

    private String [] transmission = {"automatic","manuel","automatic","automatic","automatic","automatic","-","manuel","-","-","manuel","manuel"};
    private String [] model = {"Lancer","Nissan ","Mercedes","Chevrolet","Suzuki","Rocket","sernj","Nissan","Mercedes","-","Chaparral","MerCruiser"};
    private String [] kilometer= {"+200000 ","100000 to 109999","100000 to 109999","1000","+200000","100000 to 109999","100000 to 109999","100000","1000","-","100000 to 109999","100000 to 109999"};
    private String [] year = {"2005","2004 ","2006","2007","2008","2001","2005","2004 ","2006","2007","2008","2009"};
    private String [] description = {"In a very good condition","In an acceptable condition","In a good condition","In a very good condition",
            "In a very good condition","In an acceptable condition","In a good condition","In a very good condition",
            "In a very good condition","In an acceptable condition","In a good condition","In a very good condition",};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        //adding title to the activity
        setTitle("Search Result");


        //adding the toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        recyclerView = (RecyclerView) findViewById(R.id.searchResultRecyclerViewID);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count=0;

        for(String Title : titles)
        {
            SearchProduct searchProduct= new SearchProduct(images[count],titles[count],state[count],condition[count],price[count],region[count],
                    transmission[count],model[count],kilometer[count],year[count],description[count]);
            count++;
            arrayList.add(searchProduct);

        }
        adapter = new SearchResultAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);

    }


    //create the option menu to hold account icon
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;

    }

    //go to login when account icon clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        if( id ==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<SearchProduct> newList = new ArrayList<>();

        for (SearchProduct sp : arrayList)
        {
            String title =sp.getTitle().toLowerCase();
            if(title.contains(newText))
                newList.add(sp);
        }

        adapter.setFilter(newList);

        return true;
    }
}


