package com.ss.bottombar;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.ImageView;

/**
 * Created by sowmi on 02/09/16.
 */

public class BottomBarUtils {

    public static void setImageResource(ImageView imgView, int inactiveDrawableId) {
        imgView.setBackgroundResource(inactiveDrawableId);

    }

    public static boolean isPhone(Context context) {
        return !((context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE);
    }
}
