package com.ss.example;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by sowmi on 26/08/16.
 */

public class BadgeView extends TextView {

    public BadgeView(Context context) {
        super(context);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBadgeCount(int count){
        String countStr = String.valueOf(count);
        if(countStr.length() >=2 ) {
            float[] R = new float[] { 10, 10, 10, 10,10, 10, 10, 10 };
         RectF inset = new RectF(10,10,10,10);
         setBackgroundDrawable(getShapeDrawable(new RoundRectShape(R , null, null)));
        }
         setText(""+count);
    }


    public void setTargetView(View view){
        setElevation(40);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT));
        setBackgroundDrawable(getShapeDrawable(new OvalShape()));

        ViewGroup parent = (ViewGroup) view.getParent();
        FrameLayout flBadgeContainer = new FrameLayout(getContext());
        FrameLayout.LayoutParams  badgeLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        badgeLayoutParams.gravity = Gravity.RIGHT | Gravity.TOP | Gravity.END ;

        setLayoutParams(badgeLayoutParams);
        flBadgeContainer.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT));
        parent.removeView(view);
        setTextColor(getResources().getColor(android.R.color.white));
        setPadding(5,0,5,0);
        flBadgeContainer.addView(this);
        flBadgeContainer.addView(view);
        this.bringToFront();

        parent.addView(flBadgeContainer);

        setTextColor(Color.WHITE);

    }


    public ShapeDrawable getShapeDrawable(Shape shape){
        ShapeDrawable shapeDrawable = new ShapeDrawable(shape);
        shapeDrawable.getPaint().setColor(Color.BLUE);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        return  shapeDrawable;
    }
}


