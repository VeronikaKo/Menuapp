package com.example.nika.menu_app.feature.Model;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.widget.TextView;

import com.example.nika.menu_app.feature.Model.Common.Common;

public class Home {

    FirebaseDatabase database;
    DatabaseReference category;

    TextView txtFullName;

    RecyclerView recyler_menu;
    RecyclerView.LayoutManager layoutManager;

    Toolbar toolbar = (Toolbar) findViewbyId(R.id.toolbar);
    toolbar.setTitle("Menu");

    setSupportActionBar(toolbar);

    database =FireBase.getInstance();
    category =database.getReference("Category");

    //Set name for User
    View headerView = navigationView.getHeaderView(0);
    txtFullName =(TextView)findViewbyId(R.id.txtFullName);
    txtFullName.setText(Common.currentuser.getName());

}

    @Override
    public void onBackPressed (){
        DrawerLayout drawer = (DrawerLayout) findViewbyId(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        }
        else {
            super.onBackPressed();
        }
    }
}

