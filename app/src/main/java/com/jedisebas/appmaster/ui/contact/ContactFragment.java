package com.jedisebas.appmaster.ui.contact;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.R;

public class ContactFragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        TextView link = root.findViewById(R.id.linkTv);
        String linkText = "<a href='https://image.ceneostatic.pl/data/products/29268409/i-kontakt-simon-basic-modul-gniazdo-wtyczkowe-podwojne-bez-uziemienia-kompletne-16a-250v-zaciski-srubowe-biale-bmg2-11.jpg'>Kontakt</a>";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());
        return root;
    }
}
