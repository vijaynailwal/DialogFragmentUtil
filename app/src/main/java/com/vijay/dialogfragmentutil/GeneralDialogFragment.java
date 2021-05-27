package com.vijay.dialogfragmentutil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class GeneralDialogFragment extends BaseDialogFragment<GeneralDialogFragment.OnDialogFragmentClickListener> {
    TextView title;
    Button no, yes;

    public interface OnDialogFragmentClickListener {
        void onOkClicked(GeneralDialogFragment dialog);

        void onCancelClicked(GeneralDialogFragment dialog);
    }

    public static GeneralDialogFragment newInstance(String title, String message) {
        GeneralDialogFragment frag = new GeneralDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("msg", message);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        no = view.findViewById(R.id.btn_no);
        yes = view.findViewById(R.id.btn_yes);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean setFullScreen = false;
        if (getArguments() != null) {
            setFullScreen = getArguments().getBoolean("fullScreen");
        }
        if (setFullScreen)
            setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            title.setText(getArguments().getString("title"));
            no.setOnClickListener(view -> {
                dismiss();
                getActivityInstance().onCancelClicked(GeneralDialogFragment.this);
            });
            yes.setOnClickListener(view -> {
                dismiss();
                getActivityInstance().onOkClicked(GeneralDialogFragment.this);
            });

        }
    }

    /*
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(getArguments().getString("title"))
                .setMessage(getArguments().getString("message"))
                .setCancelable(false)
                .setPositiveButton("OK",
                        (dialog, whichButton) -> {
                            getActivityInstance().onOkClicked(GeneralDialogFragment.this);
                        }
                )
                .setNegativeButton("Cancel",
                        (dialog, whichButton) -> {
                            getActivityInstance().onCancelClicked(GeneralDialogFragment.this);
                        }
                )
                .create();
    }
*/

}