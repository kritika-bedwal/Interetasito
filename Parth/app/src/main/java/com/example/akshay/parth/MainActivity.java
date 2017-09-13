package com.example.akshay.parth;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.akshay.parth.R.id.sign_out_menu;


public class MainActivity extends AppCompatActivity {
    private static final int RECOGNIZER_REQ_CODE = 1234;


    public static final int CAMERA_PIC_REQUEST = 1;//firstly define this




    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


//You tab icons
        int[] icons = {
                R.drawable.folder,
                R.drawable.security,
                R.drawable.work,
                R.drawable.textviewer,
        };

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };





    }
    @Override
    protected void onResume() {
        super.onResume();
        auth.addAuthStateListener(authListener);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {

            String phone = "08039515021";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phone));
            startActivity(callIntent);

            return true;

        } else
            return super.onKeyDown(keyCode, event);


    }

    

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case sign_out_menu:
                signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void signOut() {
        auth.signOut();

    }


    public void cliclMe(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_PIC_REQUEST );
}


    public void Source(View view) {
        Intent i=new Intent(this,BarcodeActivity.class);
        startActivity(i);
    }


    public void attend(View view) {
        Intent j=new Intent(this,BarcodeActivity2.class);
        startActivity(j);
    }

    public void knowmore(View view) {
        Intent k=new Intent(this,BarcodeActivity3.class);
        startActivity(k);
    }


    public void ok(View view) {


    }
}
