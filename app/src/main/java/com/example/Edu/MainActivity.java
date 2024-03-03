package com.example.Edu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView userRecycler;
    RecyclerviewAdapter recyclerviewAdapter;
    EditText searchView;
    CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_bar);

        List<UserData> userDataList = new ArrayList<>();
        userDataList.add(new UserData("Caterpillar", "Global manufacturer of construction and mining equipment.", R.drawable.cp));
        userDataList.add(new UserData("Appranix", "Cloud security and compliance automation company.", R.drawable.appranix));
        userDataList.add(new UserData("Amazon", "Multinational e-commerce and technology company.", R.drawable.amazon));
        userDataList.add(new UserData("Avasoft", "Technology-driven software development firm focused on delivering innovative solutions for businesses worldwide.", R.drawable.avasoft));
        userDataList.add(new UserData("Infosys", "Global leader in consulting, technology, and outsourcing services, known for driving digital transformation for businesses worldwide.", R.drawable.infosys));
        userDataList.add(new UserData("kyro", "Software company with a unique focus on Technology innovation, Service transformation, and Total experience.", R.drawable.kyro));
        userDataList.add(new UserData("Cognizant", "American multinational technology company specializing in IT services, consulting, and business process outsourcing.", R.drawable.th));
        userDataList.add(new UserData("Intellipaat Academy", "Offers top-quality online courses led by experts across diverse technology fields, fostering career excellence in individuals and industries.", R.drawable.i));
        userDataList.add(new UserData("Flipkart", "India's Leading E-commerce Marketplace with a Diverse Range of Online Products.", R.drawable.flipkart));
        userDataList.add(new UserData("Kanini", "Innovating IT Solutions for Healthcare, Finance, and Government Sectors, focused on Efficiency and Digital Transformation.", R.drawable.kanini));
        userDataList.add(new UserData("GEP", "Leading global provider of procurement and supply chain software and services.", R.drawable.gep));
        userDataList.add(new UserData("FacePrep", "Online platform specializing in interview preparation and skill development courses.", R.drawable.faceprep));
        userDataList.add(new UserData("TCS", "Global IT services and consulting company, known for providing cutting-edge technology solutions to businesses around the world.", R.drawable.tcs));
        userDataList.add(new UserData("Zoho", "Multinational technology company that offers a suite of cloud-based software solutions for businesses, including CRM, productivity, and collaboration tools.", R.drawable.zoho));
        userDataList.add(new UserData("Wipro", "Multinational corporation offering a wide range of IT solutions and consulting services to clients worldwide, known for its expertise in technology and innovation.", R.drawable.wip));




        setUserRecycler(userDataList);


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                recyclerviewAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private  void  setUserRecycler(List<UserData> userDataList){
        userRecycler = findViewById(R.id.userRecycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(this, userDataList);
        userRecycler.setAdapter(recyclerviewAdapter);
    }

}