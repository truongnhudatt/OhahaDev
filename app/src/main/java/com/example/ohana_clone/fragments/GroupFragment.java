package com.example.ohana_clone.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohana_clone.R;
import com.example.ohana_clone.adapters.UserGroupViewAdapter;
import com.example.ohana_clone.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewGroup;

    private UserGroupViewAdapter userGroupViewAdapter;

    private List<User> listUser;

    public GroupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GroupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroupFragment newInstance(String param1, String param2) {
        GroupFragment fragment = new GroupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        setUpRecyclerViewGroup(view);
        return view;
    }

    private void setUpRecyclerViewGroup(View view){
        listUser = new ArrayList<>();
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        listUser.add(new User("Tuệ Lâm Hoàng Tuệ Lâm", "500,000", "2,000,000", "Quận Đống Đa", R.drawable.image1));
        userGroupViewAdapter = new UserGroupViewAdapter(getContext(), listUser);
        recyclerViewGroup = view.findViewById(R.id.recyclerViewGroup);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewGroup.setAdapter(userGroupViewAdapter);
        recyclerViewGroup.setLayoutManager(linearLayoutManager);
        recyclerViewGroup.addItemDecoration(itemDecoration);

    }

}