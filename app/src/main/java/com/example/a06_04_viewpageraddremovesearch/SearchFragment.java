package com.example.a06_04_viewpageraddremovesearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a06_04_viewpageraddremovesearch.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment  extends Fragment {
    private RecyclerView revView;
    private SearchAdapter adapter;
    private EditText eName;
    private Button btSearch;
    private List<Product> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_search,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView(view);
        adapter=new SearchAdapter();
        revView.setAdapter(adapter);
        revView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List<Product> tList=new ArrayList<>();
                String name=eName.getText().toString();
                for(Product p:list){
                    if(p.getName().indexOf(name)>=0)
                        tList.add(p);
                }
                adapter.setSearchList(tList);

            }
        });
    }

    private void intView(View v) {
        revView=v.findViewById(R.id.recyclerView);
        eName=v.findViewById(R.id.name);
        btSearch=v.findViewById(R.id.btSearch);
    }
    @Override
    public void onResume() {
        super.onResume();
        list = ((MainActivity)getActivity()).list;
    }
}
