package com.example.ghagenie.ui.base;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public abstract class GenieBaseActivity extends AppCompatActivity implements IRecyclerEventCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();
}