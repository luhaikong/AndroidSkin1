package com.skin.demo.zip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.skin.demo.BaseActivity;
import com.skin.demo.R;
import com.skin.demo.loader.ZipSDCardLoader;

import skin.support.SkinCompatManager;
import skin.support.utils.SkinPreference;

public class ZipActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        findViewById(R.id.default_theme).setOnClickListener(this);
        findViewById(R.id.default_zip_theme).setOnClickListener(this);
        findViewById(R.id.zip_theme).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SkinPreference.getInstance().getSkinStrategy() == ZipSDCardLoader.SKIN_LOADER_STRATEGY_ZIP) {
            mToolbar.setTitle("图片来自Zip包");
        } else {
            mToolbar.setTitle("图片来自应用本身");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.default_theme:
                SkinCompatManager.getInstance().restoreDefaultTheme();
                mToolbar.setTitle("图片来自应用本身");
                break;
            case R.id.default_zip_theme:
                SkinCompatManager.getInstance().loadSkin("", ZipSDCardLoader.SKIN_LOADER_STRATEGY_ZIP);
                mToolbar.setTitle("图片来自Zip包");
                break;
            case R.id.zip_theme:
                SkinCompatManager.getInstance().loadSkin("night.skin", ZipSDCardLoader.SKIN_LOADER_STRATEGY_ZIP);
                mToolbar.setTitle("图片来自Zip包");
                break;
        }
    }
}
