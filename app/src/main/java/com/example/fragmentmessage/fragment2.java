package com.example.fragmentmessage;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragment2 extends Fragment {
    private TextView tv;
    private EditText editText;
    private Button button;
    private fragment2listener listener;

    public interface fragment2listener{
        void textinput2(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);

        tv = v.findViewById(R.id.tx2);
        editText = v.findViewById(R.id.ed2);
        button = v.findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.textinput2(input);
            }
        });

        return v;
    }

    public void updateTextView (CharSequence newText) {
        tv.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fragment2listener){
            listener = (fragment2listener) context;
        }
        else {
            throw new RuntimeException(context.toString()+"must implement fragment2listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}