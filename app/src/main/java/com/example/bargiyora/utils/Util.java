package com.example.bargiyora.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Util {

    public static void openDialPadWithNumber(Context context, String number) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            String phone = "tel:" + number;
            callIntent.setData(Uri.parse(phone));
            context.startActivity(callIntent);
        } catch (Exception e) {
            // TODO: 11/12/2020 add error
        }
    }
}
