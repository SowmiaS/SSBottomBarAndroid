package com.ss.bottombar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iOS on 26/08/16.
 */

public class BottomBarItem implements View.OnClickListener{

    private int inactiveDrawableId;
    private int activeDrawableId;
    private int inactiveColor;
    private int activeColor;
    private String title;
    private int positionInBottomBar;
    private View bottomBarItemView;
    private BottomBar parent;


    public BottomBarItem(int inactiveDrawableId, int activeDrawableId , int activeColor, String text) {
        this.inactiveDrawableId = inactiveDrawableId;
        this.activeDrawableId = activeDrawableId;
        this.activeColor = activeColor;
        this.title = text;
    }

    private BottomBarItem() {
    }


    public void createBottomBarItemView(BottomBar context , int positionInBottomBar){
        this.positionInBottomBar = positionInBottomBar;
        this.parent = context;
        bottomBarItemView = LayoutInflater.from(context.getContext()).inflate(R.layout.bottombar_item , null , false);
        bottomBarItemView.setOnClickListener(this);
        populateView();
    }

    private void populateView(){
        BottomBarUtils.setImageResource((ImageView) bottomBarItemView.findViewById(R.id.bottombaritem_img) , inactiveDrawableId);
        ((TextView)bottomBarItemView.findViewById(R.id.bottombaritem_title)).setText(title);
    }

    public View getBottomBarItemView() {
        return bottomBarItemView;
    }

    public int getPositionInBottomBar() {
        return positionInBottomBar;
    }

    @Override
    public void onClick(View v) {
        if(parent != null){
            parent.onItemClick(this);
        }
    }

    public int getInactiveDrawableId() {
        return inactiveDrawableId;
    }

    public int getActiveDrawableId() {
        return activeDrawableId;
    }

    public int getInactiveColor() {
        return inactiveColor;
    }

    public int getActiveColor() {
        return activeColor;
    }

    public String getTitle() {
        return title;
    }

    public ImageView getImgView(){
        return (ImageView) bottomBarItemView.findViewById(R.id.bottombaritem_img);
    }

    public TextView getTextView(){
        return (TextView) bottomBarItemView.findViewById(R.id.bottombaritem_title);
    }
}
