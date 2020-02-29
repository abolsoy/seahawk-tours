package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private String lastBuilding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spin = findViewById(R.id.building);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] building_names = getResources().getStringArray(R.array.building_names);
                if (i==0) {
                    // do nothing
                }
                else {
                    String building;
                    String info;
                    int pic;
                    if (i == 1) {
                        // User selects CIS Building
                        building = building_names[1];
                        info = getResources().getString(R.string.cis_info);
                        pic = R.drawable.cisbuilding;
                        onChooseBuilding(building, info, pic, 0);
                    } else if (i == 2) {
                        // User selects Hoggard Hall
                        building = building_names[2];
                        info = getResources().getString(R.string.hoggard_info);
                        pic = R.drawable.hoggardhall;
                        onChooseBuilding(building, info, pic, 1);
                    } else if (i == 3) {
                        // User selects Deloach Hall
                        building = building_names[3];
                        info = getResources().getString(R.string.deloach_info);
                        pic = R.drawable.deloachhall;
                        onChooseBuilding(building, info, pic, 2);
                    } else if (i == 4) {
                        // User selects Bear Hall
                        building = building_names[4];
                        info = getResources().getString(R.string.bear_info);
                        pic = R.drawable.bearhall;
                        onChooseBuilding(building, info, pic, 3);
                    } else if (i == 5) {
                        // User selects Dobo Hall
                        building = building_names[5];
                        info = getResources().getString(R.string.dobo_info);
                        pic = R.drawable.dobohall;
                        onChooseBuilding(building, info, pic, 4);
                    } else {
                        building = "";
                        info = "";
                        pic = 0;
                    }

                    lastBuilding = building;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do not worry about this
            }
        });

        if (savedInstanceState != null) {
            lastBuilding = savedInstanceState.getString("lastBuilding");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("lastBuilding", lastBuilding);
    }

    public void onChooseAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void onChooseBuilding(String building, String info, int pic, int id) {
        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra(DetailActivity.EXTRA_BUILDINGID, id);

        intent.putExtra(DetailActivity.EXTRA_BUILDING, building);
        intent.putExtra(DetailActivity.EXTRA_INFO, info);
        intent.putExtra(DetailActivity.EXTRA_PICID, pic);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lastBuilding != null) {
            TextView previous = findViewById(R.id.last_building);
            String text = "Previous Building: " + lastBuilding;
            previous.setText(text);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
