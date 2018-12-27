package com.example.ruslan.orangeviews.view.Dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ruslan.orangeviews.R;

public class NewAddressDialog extends android.support.v4.app.DialogFragment {
    public NewAddressDialog() {
    }

    public static NewAddressDialog newInstance() {
        NewAddressDialog frag = new NewAddressDialog();
        return frag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add_address, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.getDialog().setCanceledOnTouchOutside(false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image_button_add_address_add);
        this.getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Button button = (Button) view.findViewById(R.id.image_button_add_address_cancel);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewAddressDialog.this.dismiss();
                Toast.makeText(getActivity(),"added", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewAddressDialog.this.dismiss();
                Toast.makeText(getActivity(),"canceled",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
