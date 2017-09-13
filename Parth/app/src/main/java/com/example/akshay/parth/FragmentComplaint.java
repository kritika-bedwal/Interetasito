package com.example.akshay.parth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.example.akshay.parth.ChatActivity.RC_PHOTO_PICKER;

/**
 * Created by rahul on 11/9/17.
 */

public class FragmentComplaint extends Fragment{
    public FragmentComplaint(){

    }

    public String ImageUri;
    String YourLocation;
    ImageView complaint;

    FloatingActionButton click,send,pick;
    Spinner spinner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.complaints, container, false);

        complaint=RootView.findViewById(R.id.complaintImage);
        ArrayList<String> choice=new ArrayList<>();
        choice.add("Children's Helpline");

        spinner = (Spinner) RootView.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.helpline_array, android.R.layout.simple_spinner_item);
        YourLocation="https://www.google.co.in/maps/search/MMU+mullana/@30.251118,77.0453181,17z/data=!3m1!4b1";

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        Log.i("message","important log message");




        click=RootView.findViewById(R.id.OpenCameraFAB);
        send=RootView.findViewById(R.id.floatingActionButtonsent);
        pick=RootView.findViewById(R.id.ImagePicker);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 2500);




            }
        });
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);

            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=spinner.getSelectedItem().toString();
                if(value.equals("Childrens Helpline")){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"children_helpline@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Children being abused in the form of child labour");
                    intent.putExtra(Intent.EXTRA_TEXT, "Sir the following picture acts as a proof of the ongoing child labour activities in the region "+YourLocation);
                    intent.putExtra(Intent.EXTRA_STREAM,Uri.parse(ImageUri));
                    startActivity(Intent.createChooser(intent, "Send Email"));


                }
                else if(value.equals("Womens Helpline")){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");

                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"womenSafetyInitiative@gmail.com"});

                    intent.putExtra(Intent.EXTRA_SUBJECT, "Report regarding women harrasment");
                    intent.putExtra(Intent.EXTRA_TEXT, "Sir the following picture acts as a proof of the ongoing women harassment activities in the region "+YourLocation);

                    startActivity(Intent.createChooser(intent, "Send Email"));
                }
                else if(value.equals("Medical Emergency")){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"emergencyApolloHospital@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Emergency due to road accident");
                    intent.putExtra(Intent.EXTRA_TEXT, "Sir the following image is of a road accident at the location "+YourLocation);

                    startActivity(Intent.createChooser(intent, "Send Email"));
                }
            }
        });
        return RootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {
            ImageUri = data.getData().toString();
            complaint.setImageURI(Uri.parse(ImageUri));
        }
    }


}
