package com.skin.demo.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewStub;

import com.skin.demo.BaseActivity;
import com.skin.demo.R;
import com.skin.demo.mdtab.MDFirstFragment;

public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initToolbar();
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub);
        viewStub.setLayoutResource(R.layout.fragment_view_stub);
        viewStub.inflate();
        MDFirstFragment fragment = (MDFirstFragment) getSupportFragmentManager().findFragmentById(R.id.md_fragment);
        Log.e("TestActivity", "fragment = " + fragment);
    }
}
