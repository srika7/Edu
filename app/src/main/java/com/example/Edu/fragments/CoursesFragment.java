package com.example.Edu.fragments;

import android.content.Intent;
import android.net.Uri;
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

public class CoursesFragment extends Fragment {

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

        userDataList.add(new UserData2("PROGRAMMING IN PYTHON", "Handled by Dr. ANTONY ARUL RAJ D.", R.drawable.dp));
        userDataList.add(new UserData2("DESIGN ANALYSIS & ALGORITHM", "Handled by Dr. UMAGANDHI R.", R.drawable.dp));

        userDataList.add(new UserData2("OBJECT ORIENTED ANALYSIS & DESIGN", "Handled by Dr USHARANI V.", R.drawable.dp));

        userDataList.add(new UserData2("DATA MINING", "Handled by Ms. DEEPA C.", R.drawable.dp));

        userRecycler = view.findViewById(R.id.userRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter2(getContext(), userDataList);
        userRecycler.setAdapter(recyclerviewAdapter);
        userRecycler.requestLayout();
        recyclerviewAdapter.setOnItemClickListener(new RecyclerviewAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(UserData2 userData) {
                if (userData.getUserName().equals("PROGRAMMING IN PYTHON")) {
                    String url = "https://drive.google.com/drive/folders/1Tgj8NLnXIALUnqc0FiEzeXaF0EQAl9mS?usp=sharing";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    requireContext().startActivity(intent);
                } else if (userData.getUserName().equals("DESIGN ANALYSIS & ALGORITHM")) {
                    String url = "https://drive.google.com/drive/folders/1-6AfIorWDJQEDFIDNXPjqeA5HiTGPITt?usp=sharing";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    requireContext().startActivity(intent);
                } else if (userData.getUserName().equals("OBJECT ORIENTED ANALYSIS & DESIGN")) {
                    String url = "https://drive.google.com/drive/folders/1xcNde4x2vupWZNSyXjNw82tS9ZmTn_3i?usp=sharing";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    requireContext().startActivity(intent);
                }else if (userData.getUserName().equals("DATA MINING")) {
                    String url = "https://drive.google.com/drive/folders/1WYUavJIcCjlzN6Blz6xupENagyh54bkH?usp=sharing";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    requireContext().startActivity(intent);
                }
            }
        });


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