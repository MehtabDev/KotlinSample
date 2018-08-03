package com.mehtabkotlin.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mehtabkotlin.R;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavLayout;
import com.yarolegovich.slidingrootnav.callback.DragListener;
import com.yarolegovich.slidingrootnav.callback.DragStateListener;
import com.yarolegovich.slidingrootnav.transform.CompositeTransformation;
import com.yarolegovich.slidingrootnav.transform.ElevationTransformation;
import com.yarolegovich.slidingrootnav.transform.RootTransformation;
import com.yarolegovich.slidingrootnav.transform.ScaleTransformation;
import com.yarolegovich.slidingrootnav.transform.YTranslationTransformation;
import com.yarolegovich.slidingrootnav.util.ActionBarToggleAdapter;
import com.yarolegovich.slidingrootnav.util.DrawerListenerAdapter;
import com.yarolegovich.slidingrootnav.util.HiddenMenuClickConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yarolegovich on 24.03.2017.
 */

public class BSlidingRootNavBuilder {

    private static final float DEFAULT_END_SCALE = 0.65f;
    private static final int DEFAULT_END_ELEVATION_DP = 8;
    private static final int DEFAULT_DRAG_DIST_DP = 180;

    private Activity activity;

    private ViewGroup contentView;

    private View menuView;
    private int menuLayoutRes;

    private List<RootTransformation> transformations;

    private List<DragListener> dragListeners;

    private List<DragStateListener> dragStateListeners;

    private int dragDistance;

    private Toolbar toolbar;

    private SlideGravity gravity;

    private boolean isMenuOpened;

    private boolean isMenuLocked;

    private boolean isContentClickableWhenMenuOpened;

    private Bundle savedState;

    public BSlidingRootNavBuilder(Activity activity) {
        this.activity = activity;
        this.transformations = new ArrayList<>();
        this.dragListeners = new ArrayList<>();
        this.dragStateListeners = new ArrayList<>();
        this.gravity = SlideGravity.LEFT;
        this.dragDistance = dpToPx(DEFAULT_DRAG_DIST_DP);
        this.isContentClickableWhenMenuOpened = true;
    }

    public BSlidingRootNavBuilder withMenuView(View view) {
        menuView = view;
        return this;
    }

    public BSlidingRootNavBuilder withMenuLayout(@LayoutRes int layout) {
        menuLayoutRes = layout;
        return this;
    }

    public BSlidingRootNavBuilder withToolbarMenuToggle(Toolbar tb) {
        toolbar = tb;
        return this;
    }

    public BSlidingRootNavBuilder withGravity(SlideGravity g) {
        gravity = g;
        return this;
    }

    public BSlidingRootNavBuilder withContentView(ViewGroup cv) {
        contentView = cv;
        return this;
    }

    public BSlidingRootNavBuilder withMenuLocked(boolean locked) {
        isMenuLocked = locked;
        return this;
    }

    public BSlidingRootNavBuilder withSavedState(Bundle state) {
        savedState = state;
        return this;
    }

    public BSlidingRootNavBuilder withMenuOpened(boolean opened) {
        isMenuOpened = opened;
        return this;
    }

    public BSlidingRootNavBuilder withContentClickableWhenMenuOpened(boolean clickable) {
        isContentClickableWhenMenuOpened = clickable;
        return this;
    }

    public BSlidingRootNavBuilder withDragDistance(int dp) {
        return withDragDistancePx(dpToPx(dp));
    }

    public BSlidingRootNavBuilder withDragDistancePx(int px) {
        dragDistance = px;
        return this;
    }

    public BSlidingRootNavBuilder withRootViewScale(@FloatRange(from = 0.01f) float scale) {
        transformations.add(new ScaleTransformation(scale));
        return this;
    }

    public BSlidingRootNavBuilder withRootViewElevation(@IntRange(from = 0) int elevation) {
        return withRootViewElevationPx(dpToPx(elevation));
    }

    public BSlidingRootNavBuilder withRootViewElevationPx(@IntRange(from = 0) int elevation) {
        transformations.add(new ElevationTransformation(elevation));
        return this;
    }

    public BSlidingRootNavBuilder withRootViewYTranslation(int translation) {
        return withRootViewYTranslationPx(dpToPx(translation));
    }

    public BSlidingRootNavBuilder withRootViewYTranslationPx(int translation) {
        transformations.add(new YTranslationTransformation(translation));
        return this;
    }

    public BSlidingRootNavBuilder addRootTransformation(RootTransformation transformation) {
        transformations.add(transformation);
        return this;
    }

    public BSlidingRootNavBuilder addDragListener(DragListener dragListener) {
        dragListeners.add(dragListener);
        return this;
    }

    public BSlidingRootNavBuilder addDragStateListener(DragStateListener dragStateListener) {
        dragStateListeners.add(dragStateListener);
        return this;
    }

    public SlidingRootNav inject() {
        ViewGroup contentView = getContentView();

        View oldRoot = contentView.getChildAt(0);
        contentView.removeAllViews();

        SlidingRootNavLayout newRoot = createAndInitNewRoot(oldRoot);

        View menu = getMenuViewFor(newRoot);

        initToolbarMenuVisibilityToggle(newRoot, menu);

        HiddenMenuClickConsumer clickConsumer = new HiddenMenuClickConsumer(activity);
        clickConsumer.setMenuHost(newRoot);

        newRoot.addView(menu);
        newRoot.addView(clickConsumer);
        newRoot.addView(oldRoot);

        contentView.addView(newRoot);

        if (savedState == null) {
            if (isMenuOpened) {
                newRoot.openMenu(false);
            }
        }

        newRoot.setMenuLocked(isMenuLocked);

        return newRoot;
    }

    private SlidingRootNavLayout createAndInitNewRoot(View oldRoot) {
        SlidingRootNavLayout newRoot = new SlidingRootNavLayout(activity);
        newRoot.setId(R.id.srn_root_layout);
        newRoot.setRootTransformation(createCompositeTransformation());
        newRoot.setMaxDragDistance(dragDistance);
        newRoot.setGravity(gravity);
        newRoot.setRootView(oldRoot);
        newRoot.setContentClickableWhenMenuOpened(isContentClickableWhenMenuOpened);
        for (DragListener l : dragListeners) {
            newRoot.addDragListener(l);
        }
        for (DragStateListener l : dragStateListeners) {
            newRoot.addDragStateListener(l);
        }
        return newRoot;
    }

    private ViewGroup getContentView() {
        if (contentView == null) {
            contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        }
        if (contentView.getChildCount() != 1) {
            throw new IllegalStateException(activity.getString(R.string.srn_ex_bad_content_view));
        }
        return contentView;
    }

    private View getMenuViewFor(SlidingRootNavLayout parent) {
        if (menuView == null) {
            if (menuLayoutRes == 0) {
                throw new IllegalStateException(activity.getString(R.string.srn_ex_no_menu_view));
            }
            menuView = LayoutInflater.from(activity).inflate(menuLayoutRes, parent, false);
        }
        return menuView;
    }

    private RootTransformation createCompositeTransformation() {
        if (transformations.isEmpty()) {
            return new CompositeTransformation(Arrays.asList(
                    new ScaleTransformation(DEFAULT_END_SCALE),
                    new ElevationTransformation(dpToPx(DEFAULT_END_ELEVATION_DP))));
        } else {
            return new CompositeTransformation(transformations);
        }
    }

    public void initToolbarMenuVisibilityToggle(final SlidingRootNavLayout sideNav, View drawer) {
        if (toolbar != null) {
            ActionBarToggleAdapter dlAdapter = new ActionBarToggleAdapter(activity);
            dlAdapter.setAdaptee(sideNav);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, dlAdapter, toolbar,
                    R.string.srn_drawer_open,
                    R.string.srn_drawer_close);
            toggle.syncState();
            DrawerListenerAdapter listenerAdapter = new DrawerListenerAdapter(toggle, drawer);
            sideNav.addDragListener(listenerAdapter);
            sideNav.addDragStateListener(listenerAdapter);
        }
    }

    public void refreshToolbar(){
        View oldRoot = contentView.getChildAt(0);
        SlidingRootNavLayout newRoot = createAndInitNewRoot(oldRoot);
        ActionBarToggleAdapter dlAdapter = new ActionBarToggleAdapter(activity);
        dlAdapter.setAdaptee(newRoot);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, dlAdapter, toolbar,
                R.string.srn_drawer_open,
                R.string.srn_drawer_close);
        toggle.syncState();
    }
    private int dpToPx(int dp) {
        return Math.round(activity.getResources().getDisplayMetrics().density * dp);
    }

}
