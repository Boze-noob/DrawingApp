package com.applid.kids.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.applid.kids.R;
import com.applid.kids.activity.Drawing;
import com.applid.kids.activity.MainActivity;
import com.applid.kids.adapter.ViewAdapter;
import com.applid.kids.interfaces.OnClick;
import com.applid.kids.util.Constant;
import com.applid.kids.util.Method;
import com.google.android.material.textview.MaterialTextView;

public class HomeFragment extends Fragment {

    public int[] image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        if (MainActivity.toolbar != null) {
            MainActivity.toolbar.setTitle(getResources().getString(R.string.home));
        }

        OnClick onClick = (OnClick) (position, type) -> {
            Constant.image = image;
            startActivity(new Intent(getActivity(), Drawing.class)
                    .putExtra("position", position));
        };
        Method method = new Method(getActivity(), onClick);

        image = new int[]{R.drawable.image, R.drawable.image_a, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7,
                R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15, R.drawable.img16, R.drawable.img17,
                R.drawable.img18, R.drawable.img19, R.drawable.img20, R.drawable.img24, R.drawable.img22, R.drawable.img23, R.drawable.img21};

        MaterialTextView textViewNoData = view.findViewById(R.id.textView_noData_home);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment);

        textViewNoData.setVisibility(View.GONE);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ViewAdapter viewAdapter = new ViewAdapter(getActivity(), image, method);
        recyclerView.setAdapter(viewAdapter);

        return view;

    }

}
