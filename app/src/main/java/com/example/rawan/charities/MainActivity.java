package com.example.rawan.charities;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  private  DatabaseHelper mydb;
    private ArrayList<charitiesData> resultList;
    private RecyclerView.Adapter adapter;
    private RecyclerView rv;
    private LinearLayout rv_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb= new DatabaseHelper(MainActivity.this);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv_layout =(LinearLayout) findViewById(R.id.rv_layout);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(layoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());

        if(IsConnected(MainActivity.this)==true){
    //Retrofit and GSON
            Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    API api = retrofit.create(API.class);
    Call<ArrayOfObjects> call = api.getList();
    call.enqueue(new Callback<ArrayOfObjects>() {
        //Response{protocol=http/1.1, code=200, message=OK, url=http://demo8044805.mockable.io/7arka_get_charities}
        @Override
        public void onResponse(Call<ArrayOfObjects> call, Response<ArrayOfObjects> response) {
            resultList=  response.body().getArrayOfCharites();
        /*        for(int i =0;i<8;++i) {
                    r.add(response.body().getCh().get(i));
                    String name= r.get(i).getOrganization_name().toString();
                    String type= r.get(i).getOrganization_type().toString();
                    String des= r.get(i).getOrganization_desc().toString();
                    String pic= r.get(i).getOrganization_pic().toString();
                     //mydb.insertData(name,type,des,pic);
               }*/
            adapter= new RvAdapter(MainActivity.this,resultList);
            rv.setAdapter(adapter);
        }
         @Override
        public void onFailure(Call<ArrayOfObjects> call, Throwable t) {
            Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

        }
    });
            Toast.makeText(MainActivity.this,"Internet connection is good!",Toast.LENGTH_LONG).show();
}
else {
             ArrayList<charitiesData> objectList= getResults();
            adapter= new RvAdapter(MainActivity.this,objectList);
            rv.setAdapter(adapter);
            Toast.makeText(MainActivity.this,"No internet connection! don't panic we have SQLITE", Toast.LENGTH_LONG).show();
}
    }

    //Getting data from database
   public ArrayList<charitiesData> getResults() {
         resultList = new ArrayList<>();
        Cursor c = mydb.getAllData();
        while (c.moveToNext())
        {
            String name = c.getString(c.getColumnIndex("name"));
            String type = c.getString(c.getColumnIndex("type"));
            String desc = c.getString(c.getColumnIndex("descc"));
            String picc = c.getString(c.getColumnIndex("pic"));
            try
            {
               charitiesData ob = new charitiesData();
                ob.setOrganization_name(name);
                ob.setOrganization_type(type);
                ob.setOrganization_desc(desc);
                ob.setOrganization_pic(picc);

                resultList.add(ob);
            }
            catch (Exception e) {
                Log.e("w", "Error " + e.toString());
            }

        }
       c.close();
        return resultList;
    }
    public boolean IsConnected(Context context){
    ConnectivityManager cm =
            (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    boolean isConnected = activeNetwork != null &&
            activeNetwork.isConnectedOrConnecting();
    return isConnected;}
}