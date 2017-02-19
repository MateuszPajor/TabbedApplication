package com.blogspot.skooltchdev.tabbedapplicationmaster;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {

    String[] title;
    TypedArray rest_pic;
    String[] description;
    String[] number;
    String[] price;

    List<RowItem> rowItems;
    ListView listView;


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rowItems = new ArrayList<RowItem>();

        title = getResources().getStringArray(R.array.title);

        rest_pic = getResources().obtainTypedArray(R.array.rest_pic);

        description = getResources().getStringArray(R.array.description);

        price = getResources().getStringArray(R.array.price);

        number = getResources().getStringArray(R.array.number);

        for (int i = 0; i < title.length; i++) {
            RowItem item = new RowItem(title[i],
                    rest_pic.getResourceId(i, -1), description[i],
                    number[i]);
            rowItems.add(item);
        }

        listView = (ListView) view.findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(getActivity(), rowItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String member_name = rowItems.get(position).getTitle();
                Toast.makeText(getActivity().getApplicationContext(), "" + member_name,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DesActivity.class);
                intent.putExtra("string", "go to another Activity from ListView position: " + (position + 1));
                parent.setVisibility(View.GONE);
                startActivity(intent);
            }
        });
    }


}