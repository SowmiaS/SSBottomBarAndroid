package com.ss.bottombar;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sowmi on 02/09/16.
 */

public class BottomBarBehaviour extends CoordinatorLayout.Behavior<BottomBar>{

    public BottomBarBehaviour() {
    }

    public BottomBarBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, BottomBar child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, BottomBar child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if(dyConsumed > 0){
            child.hide();
        }else {
            child.show();
        }
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomBar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }
}
