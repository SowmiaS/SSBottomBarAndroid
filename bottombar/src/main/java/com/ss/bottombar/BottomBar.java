package com.ss.bottombar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by iOS on 26/08/16.
 */

public class BottomBar extends LinearLayout {

    private boolean isShown= false;
    private BottomBarItemClickListener listener;
    private ArrayList<BottomBarItem> bottomBarItems = new ArrayList<>();
    private LayoutParams bottomBarItemsLayoutParamsPhone = new LayoutParams(LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT , 1f);
    private LayoutParams bottomBarItemsLayoutParamsTab = new LayoutParams(LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT );

    public BottomBar(Context context) {
        super(context);
        init();
    }

    private void init() {

    }

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBottomBarItems(ArrayList<BottomBarItem> bottomBarItems){
        this.bottomBarItems = bottomBarItems;

        LayoutParams layoutParams = null;
        if(BottomBarUtils.isPhone(getContext())){
            layoutParams = bottomBarItemsLayoutParamsPhone;
            setWeightSum(bottomBarItems.size());
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
        }else{
            layoutParams = bottomBarItemsLayoutParamsTab;
            layoutParams.gravity = Gravity.CENTER;
        }


        for (BottomBarItem item: bottomBarItems ) {
            item.createBottomBarItemView(this, bottomBarItems.indexOf(item));

            item.getBottomBarItemView().setLayoutParams(layoutParams);
            addView(item.getBottomBarItemView());

        }
        setSelctedStyle(bottomBarItems.get(0));
        invalidate();
    }

    public ArrayList<BottomBarItem> getBottomBarItems() {
        return bottomBarItems;
    }

    public void setShown(boolean isShown){
        this.isShown = isShown;
        if(isShown){
            show();
        }else {
            hide();
        }
    }

    public void show(){
        setVisibility(VISIBLE);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y , getHeight() , 0); //TODO: bottombar height should be made dynamic , remove hardcoded
        objectAnimator.setDuration(300);
        objectAnimator.start();
        isShown = true;
        deselectAll();
        setSelctedStyle(bottomBarItems.get(0));
        invalidate();
    }


    public void hide(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y , 0 , getHeight() );
        objectAnimator.setDuration(300);
        objectAnimator.start();
        isShown = false;
    }

    public void setListener(BottomBarItemClickListener listener) {
        this.listener = listener;
    }

    public void onItemClick(BottomBarItem v) {
        if(listener != null){
            listener.onBottomBarItemClick((v.getPositionInBottomBar()));
        }
        deselectAll();
        setSelctedStyle(v);
    }

    public interface BottomBarItemClickListener{
        public void onBottomBarItemClick(int position);
    }


    private void deselectAll(){
        for (BottomBarItem item: bottomBarItems) {
            BottomBarUtils.setImageResource(item.getImgView(), item.getInactiveDrawableId());
            item.getTextView().setTextColor(ContextCompat.getColor(getContext(),android.R.color.black));
        }
    }

    private void setSelctedStyle(BottomBarItem item){
        BottomBarUtils.setImageResource(item.getImgView(), item.getActiveDrawableId());
        item.getTextView().setTextColor(ContextCompat.getColor(getContext(),item.getActiveColor()));
    }

}
