package com.example.a06_04_viewpageraddremovesearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a06_04_viewpageraddremovesearch.model.Product;


public class AddFragment extends Fragment {
    private RecyclerView revCat;
    private CatAdapter adapter;
    private Spinner spImg;
    private EditText eName,ePrice,eDescribe;
    private Button btAdd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,
                container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView(view);

        adapter=new CatAdapter((MainActivity) getActivity());
        revCat.setAdapter(adapter);
        revCat.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p=new Product();
                String i=spImg.getSelectedItem().toString();
                int img=0;
                switch(i){
                    case "1":img=R.drawable.cat1;
                        break;
                    case "2":img=R.drawable.cat2;
                        break;
                    case "3":img=R.drawable.cat3;
                        break;
                    case "4":img=R.drawable.cat4;
                        break;
                    case "5":img=R.drawable.cat5;
                        break;
                    case "6":img=R.drawable.cat6;
                        break;
                }
                p.setResouceImg(img);
                p.setName(eName.getText().toString());
                p.setPrice(Double.parseDouble(ePrice.getText().toString()));
                p.setDescribe(eDescribe.getText().toString());
                adapter.add(p);
                adapter.notifyDataSetChanged();
            }
        });
    }
    private void intView(View v) {
        revCat=v.findViewById(R.id.recyclerView);
        spImg=v.findViewById(R.id.img);
        eName=v.findViewById(R.id.name);
        ePrice=v.findViewById(R.id.price);
        eDescribe =v.findViewById(R.id.describe);
        btAdd=v.findViewById(R.id.btAdd);
    }
}
