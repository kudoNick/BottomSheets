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

import com.google.android.material.bottomsheet.BottomSheetBehavior;





public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior bottomSheetBehavior;
    private TextView tvState;
    private Button btnExpand,btnCollapse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = bottomSheetBehavior.from(bottomSheet);

        tvState = findViewById(R.id.text_view_state);

        btnExpand = findViewById(R.id.button_expand);
        btnCollapse = findViewById(R.id.button_collapse);

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

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomsheet, int newstate) {
                switch (newstate) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                         tvState.setText("Collapsed");
                         break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        tvState.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        tvState.setText("expanded");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        tvState.setText("settling");
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }
}