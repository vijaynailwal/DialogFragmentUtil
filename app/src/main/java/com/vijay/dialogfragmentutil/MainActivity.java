package com.vijay.dialogfragmentutil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements GeneralDialogFragment.OnDialogFragmentClickListener {

    private static final String TAG = "MainActivity";
    Button button, button2;

    String s1 = "string 1";
    String s2 = "string 2";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(view -> {
            bluetoothDialog();
        });
        button2.setOnClickListener(view -> {
            suiteDialog();
        });

    }

    private void bluetoothDialog() {
        GeneralDialogFragment generalDialogFragment =
                GeneralDialogFragment.newInstance(s1, "message");
        generalDialogFragment.show(getSupportFragmentManager(), "dialog");
    }

    private void suiteDialog() {
        GeneralDialogFragment generalDialogFragment =
                GeneralDialogFragment.newInstance(s2, "message");
        generalDialogFragment.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onOkClicked(GeneralDialogFragment dialog) {
        Log.e(TAG, "onOkClicked: ");
    }

    @Override
    public void onCancelClicked(GeneralDialogFragment dialog) {
        Log.e(TAG, "onCancelClicked: ");
    }

}