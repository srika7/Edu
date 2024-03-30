package com.example.Edu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.Edu.fragments.CoursesFragment;
import com.example.Edu.fragments.FacultiesFragment;
import com.example.Edu.fragments.LabFragment;

public class MyViewPagerAdapter  extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FacultiesFragment();
            case 1:
                return new CoursesFragment();
            case 2:
                return new LabFragment();
            default:
                return new FacultiesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
