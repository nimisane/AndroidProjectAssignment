package com.nimish.internshipassignment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private RequestTabAdapter requestTabAdapter;
    private RecyclerView.LayoutManager layoutManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RequestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RequestFragment newInstance(String param1, String param2) {
        RequestFragment fragment = new RequestFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_request, container, false);

        Context context;
        ArrayList<RequestTabItems> requestTabItems = new ArrayList<>();
        requestTabItems.add(new RequestTabItems(R.drawable.ic_round_user_profile_foreground,"Roger","App Developer Job","14 Mar, 04:27 PM","Mumbai","I am looking for Android Development Job"));
        recyclerView = rootView.findViewById(R.id.requests_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        requestTabAdapter = new RequestTabAdapter(requestTabItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(requestTabAdapter);
        requestTabAdapter.setOnItemClickListener(new RequestTabAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                PopupMenu popupMenu = new PopupMenu(getContext(),getView().findViewById(R.id.delete_option));
                popupMenu.inflate(R.menu.options_menu);
                popupMenu.show();
            }
        });

        return rootView;
    }
}