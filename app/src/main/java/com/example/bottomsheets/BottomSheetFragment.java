package com.example.bottomsheets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {


    private BottomSheetListener bottomSheetListener;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_sheet_dialog, container, false);

        bottomSheetListener = (BottomSheetListener) getContext();
        linearLayout1 = view.findViewById(R.id.line1);
        linearLayout2 = view.findViewById(R.id.line2);
        linearLayout3 = view.findViewById(R.id.line3);
        linearLayout4 = view.findViewById(R.id.line4);
        linearLayout5 = view.findViewById(R.id.line5);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetListener.onBottomSheetClick("PreView");
                dismiss();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetListener.onBottomSheetClick("Share");
                dismiss();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetListener.onBottomSheetClick("Get Link");
                dismiss();
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetListener.onBottomSheetClick("Make a Copy");
                dismiss();
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetListener.onBottomSheetClick("Email a copy");
                dismiss();
            }
        });
        return view;

    }

    public interface BottomSheetListener{
        void onBottomSheetClick(String text);

    }
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        try {
//            bottomSheetListener = (BottomSheetListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + " must implement BottomSheetLestener");
//        }
//    }
}
