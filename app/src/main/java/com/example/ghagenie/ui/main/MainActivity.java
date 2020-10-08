package com.example.ghagenie.ui.main;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ghagenie.R;
import com.example.ghagenie.ui.adapter.NoteAdapter;
import com.example.ghagenie.ui.base.GenieBaseActivity;
import com.example.ghagenie.ui.base.GenieBaseAdapter;
import com.example.ghagenie.ui.main.MainFragment;

public class MainActivity extends GenieBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    @LayoutRes
    @Override
    protected int getLayoutResourceId() {
        return R.layout.main_activity;
    }

}