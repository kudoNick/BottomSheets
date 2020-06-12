package com.example.bottomsheets;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class MainActivity extends AppCompatActivity implements BottomSheetFragment.BottomSheetListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private static TextView tvState;
    private Button btnExpand,btnCollapse,button_Modal_Bottom_Sheet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final View bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = bottomSheetBehavior.from(bottomSheet);

        tvState = findViewById(R.id.text_view_state);

        btnExpand = findViewById(R.id.button_expand);
        btnCollapse = findViewById(R.id.button_collapse);
        button_Modal_Bottom_Sheet = findViewById(R.id.button_Modal_Bottom_Sheet);

        btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        btnCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        //lắng nghe sự kiện khi đóng mở BottomSheet
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomsheet, int newstate) {
                switch (newstate) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                         tvState.setText("Sụp đổ");
                         break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        tvState.setText("Đang kéo...");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        tvState.setText("Mở Rộng");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        tvState.setText("định cư");
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        button_Modal_Bottom_Sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(),"exampleBottomSheet");
            }
        });
    }

    @Override
    public void onBottomSheetClick(String text) {
        tvState.setText(text);
    }
}