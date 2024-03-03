package com.example.Edu.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Edu.R;
import com.example.Edu.RecyclerviewAdapter2;
import com.example.Edu.UserData2;

import java.util.ArrayList;
import java.util.List;

public class FacultiesFragment extends Fragment {
    RecyclerView userRecycler;
    RecyclerviewAdapter2 recyclerviewAdapter;
    EditText searchView;
    CharSequence search = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculties, container, false);

        searchView = view.findViewById(R.id.search_bar);
        List<UserData2> userDataList = new ArrayList<>();
        userDataList.add(new UserData2("Dr. K. V. RUKMANI MCA.,M.E.,Ph.D.","HOD & ASSOCIATE PROFESSOR\n" +
                "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("LT. Dr. D. ANTONY ARUL RAJ M.Sc.,M.Phil.,PGDCE.","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));

        userDataList.add(new UserData2("Dr.V. Usharani MCA.,M.Phil.,Ph.D.", "ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("Dr.S. KANCHANA MCA.,M.Phil.,MBA.,M.Sc(Yoga).,Ph.D","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("Dr.A. SUBHASHINI M.Sc.,M.Phil.,MCA.,Ph.D","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("Ms.C. DEEPA M.Sc.,M.Phil.,MBA.,M.A(Yoga)","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("Dr.R. UMAGANDHI MCA.,M.Phil.,Ph.D.,NET.,","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("Dr.G.S KARTHICK M.Sc.,DCM.,Ph.D.,NET.,DST-Fellow","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));
        userDataList.add(new UserData2("Mr.G. KARTHIKEYAN MCA.,M.Phil.,Ph.D","ASSOCIATE PROFESSOR\n" + "DEPARTMENT OF SOFTWARE SYSTEMS.", R.drawable.dp));



        userRecycler = view.findViewById(R.id.userRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter2(getContext(), userDataList);
        userRecycler.setAdapter(recyclerviewAdapter);
        userRecycler.requestLayout();


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
        return view;
    }
}