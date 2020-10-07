package com.example.imagesliderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView cityName;

    private TabLayout tabLayout;
    private ViewPager citiesViewPager;
    private RadioGroup rgCities;
    private ViewPagerAdapter adapter;
    private ArrayList<City> cities;

    private City selectedCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        cities=new ArrayList<>();
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        initializeCities();
      citiesViewPager.setAdapter(adapter);
      tabLayout.setupWithViewPager(citiesViewPager);

      selectedCity=getCityByName("Tokyo");
        ArrayList<ImageFragment> fragments = new ArrayList<>();
        for (int i=0; i<selectedCity.getImageUrls().size(); i++){
            ImageFragment imageFragment=new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ImageUrl", selectedCity.getImageUrls().get(i));
            imageFragment.setArguments(bundle);
            fragments.add(imageFragment);

        }
        adapter.setFragments(fragments);

        cityName.setText(selectedCity.getName());


      rgCities.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              cityChanged(checkedId);
          }
      });

    }

    private void cityChanged(int rbId){
        Log.d(TAG, "cityChanged: started");

        switch (rbId){
            case R.id.rbTokyo:
                selectedCity =getCityByName("Tokyo");
                break;
            case R.id.rbLosAngeles:
                selectedCity =getCityByName("Los Angeles");
                break;
            case R.id.rbPrzeciszow:
                selectedCity =getCityByName("Przeciszow");
                break;
            case R.id.rbTrzemesnia:
                selectedCity =getCityByName("Trzemesnia");
                break;
            default:
                break;


        }

        if(null!=selectedCity){
            cityName.setText(selectedCity.getName());
            ArrayList<ImageFragment> fragments = new ArrayList<>();
            for (int i=0; i<4; i++){
                ImageFragment imageFragment=new ImageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ImageUrl", selectedCity.getImageUrls().get(i));
                imageFragment.setArguments(bundle);
                fragments.add(imageFragment);

            }
            adapter.setFragments(fragments);
        }

    }


    private City getCityByName(String name){
        Log.d(TAG, "getCityByName: started");

        for (City city:cities) {
            if (city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    private void initViews(){

        Log.d(TAG, "initViews: started");
        cityName=findViewById(R.id.txtCityName);
        tabLayout= findViewById(R.id.tabLayout);

        citiesViewPager=findViewById(R.id.citiesViewpager);
        rgCities=findViewById(R.id.rgCities);


    }

    private void initializeCities(){

        City tokyo = new City();
        tokyo.setName("Tokyo");
        ArrayList<String>tokyoImageUrls=new ArrayList<>();
        tokyoImageUrls.add("https://www.japan-guide.com/thumb/destination_tokyo.jpg");
        tokyoImageUrls.add("https://tokyoescapes.com/wp-content/uploads/2019/01/tokyo-sm-605x605.jpg");
        tokyoImageUrls.add("https://www.nippon.com/en/ncommon/contents/features/56165/56165.jpg");
        tokyoImageUrls.add("https://japanesenostalgiccar.com/wordpress/wp-content/uploads/2016/01/0754_NissanSkylineC10-StarRoad-640x427.jpg");
        tokyo.setImageUrls(tokyoImageUrls);

        City losAngeles = new City();
        losAngeles.setName("Los Angeles");
        ArrayList<String>losAngelesImageUrls=new ArrayList<>();
        losAngelesImageUrls.add("https://ocdn.eu/images/pulscms/NjY7MDA_/1d95157963f1ea12dfaf6998c722406e.jpg");
        losAngelesImageUrls.add("https://f4fcdn.eu/wp-content/uploads/2019/01/Los-Angeles.jpg");
        losAngelesImageUrls.add("https://1img.wprost.pl/_thumb/1f/62/48be7d8188c9520a041b2aecece9.jpeg");
        losAngelesImageUrls.add("https://cdn1.mecum.com/auctions/sc0517/sc0517-282636/images/sc0517-282636_1@2x.jpg?1494422738000");
        losAngeles.setImageUrls(losAngelesImageUrls);

        City przeciszow = new City();
        przeciszow.setName("Przeciszow");
        ArrayList<String>przeciszowImageUrls=new ArrayList<>();
        przeciszowImageUrls.add("https://miro.medium.com/max/5064/0*MvaOyDLeIsPYJSf2");
        przeciszowImageUrls.add("https://farbspiel-photo.com/wp-content/uploads/2014/07/Big-City-Lights-HDR-1030x682.jpg");
        przeciszowImageUrls.add("https://i2.wp.com/thepointsguy.com/wp-content/uploads/2020/02/GettyImages-802893644.jpg?fit=2119%2C1414px&ssl=1");
        przeciszowImageUrls.add("https://cdn.motor1.com/images/mgl/VJLZB/s1/bentley-continental-gt-speed-spy-photo.jpg");
        przeciszow.setImageUrls(przeciszowImageUrls);

        City trzemesnia = new City();
        trzemesnia.setName("Trzemesnia");
        ArrayList<String>trzemesniaImageUrls=new ArrayList<>();
        trzemesniaImageUrls.add("https://kmy.pl/wp-content/uploads/2018/07/F_DSC03269.jpg");
        trzemesniaImageUrls.add("https://previews.123rf.com/images/hank55/hank551604/hank55160400016/57468407-old-poor-village-and-spring-flooding-7-4-2016.jpg");
        trzemesniaImageUrls.add("https://www.rp.pl/apps/pbcsi.dll/storyimage/RP/20190208/SWIAT/190209350/AR/0/AR-190209350.jpg?imageversion=Artykul&lastModified=");
        trzemesniaImageUrls.add("https://i.redd.it/rb7n7y3zc3wy.jpg");
        trzemesnia.setImageUrls(trzemesniaImageUrls);

        cities.add(tokyo);
        cities.add(losAngeles);
        cities.add(przeciszow);
        cities.add(trzemesnia);





    }
}
