package com.example.pr3_gurdzhi;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BlankFragment extends Fragment {

    private Context context;
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "BlankFragment";
    public BlankFragment() {
        super(R.layout.blank_fragment);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("requestKey", this, (key, bundle) -> {
            String result = bundle.getString("bundleKey");
            TextView text1 = (TextView) getView().findViewById(R.id.wc1);
            text1.setText("Вы открыли отель номер:" + result);
            TextView text2 = (TextView) getView().findViewById(R.id.wc2);
            text2.setText("Нажмите клавишу 'Начать', чтобы перейти в библиотеку!");
            TextView text3 = (TextView) getView().findViewById(R.id.wc3);
            text3.setText("");
        });
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment2.class, null).commit());

        TextView text1 = view.findViewById(R.id.wc1);
        text1.setText("Добро пожаловать в OlyaApp!");
        TextView text2 = view.findViewById(R.id.wc2);
        text2.setText("Похоже, что у вас пока нету активной брони!");
        TextView text3 = view.findViewById(R.id.wc3);
        text3.setText("Нажмите клавишу 'Начать', чтобы перейти на этап регистрации отеля.");

        ImageView image = view.findViewById(R.id.img);
        image.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));

        Log.d(TAG, "onViewCreated");
        Toast.makeText(context, "onViewCreated", duration).show();

    }




}

