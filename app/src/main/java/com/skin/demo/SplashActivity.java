package com.skin.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.skin.demo.actionbar.ActionbarTestActivity;
import com.skin.demo.alert.AlertDialogActivity;
import com.skin.demo.picker.ColorPickerActivity;
import com.skin.demo.constraint.ConstraintLayoutActivity;
import com.skin.demo.flycotablayout.ui.SimpleHomeActivity;
import com.skin.demo.mdtab.MaterialDesignActivity;
import com.skin.demo.picker.DrawablePickerActivity;
import com.skin.demo.tab.MainActivity;
import com.skin.demo.test.TestActivity;
import com.skin.demo.window.WindowManagerActivity;
import com.skin.demo.zip.ZipActivity;

/**
 * Created by ximsf on 2017/3/8.
 */

public class SplashActivity extends BaseActivity {
    private ListView mListView;
    private Context mContext = this;
    private final String[] mItems = {
            "基础控件",
            "Material Design",
            "ConstraintLayout",
            "FlycoTabLayout",
            "AlertDialog",
            "WindowManager",
            "Test",
            "Actionbar",
            "Color Picker",
            "Drawable Picker",
            "Zip包资源加载"
    };
    private final Class<?>[] mClasses = {
            MainActivity.class,
            MaterialDesignActivity.class,
            ConstraintLayoutActivity.class,
            SimpleHomeActivity.class,
            AlertDialogActivity.class,
            WindowManagerActivity.class,
            TestActivity.class,
            ActionbarTestActivity.class,
            ColorPickerActivity.class,
            DrawablePickerActivity.class,
            ZipActivity.class
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initToolbar();

        mListView = (ListView) findViewById(R.id.list);
        mListView.setCacheColorHint(Color.TRANSPARENT);
        mListView.setFadingEdgeLength(0);
        mListView.setAdapter(new HomeAdapter(mContext, mItems));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, mClasses[position]);
                startActivity(intent);
            }
        });
    }

    public class HomeAdapter extends BaseAdapter {
        private String[] mItems;
        private DisplayMetrics mDisplayMetrics;

        public HomeAdapter(Context context, String[] items) {
            this.mItems = items;
            mDisplayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        }

        @Override
        public int getCount() {
            return mItems.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            int padding = (int) (mDisplayMetrics.density * 10);


            TextView tv = (TextView) getLayoutInflater().inflate(R.layout.simple_spinner_item, null);
            tv.setText(mItems[position]);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTextAppearance(SplashActivity.this, R.style.SkinCompatTextAppearance);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(padding, padding, padding, padding);
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                    AbsListView.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(lp);
            return tv;
        }
    }
}
