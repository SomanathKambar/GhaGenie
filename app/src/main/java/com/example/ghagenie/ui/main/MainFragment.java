package com.example.ghagenie.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghagenie.R;
import com.example.ghagenie.ui.adapter.NoteAdapter;
import com.example.ghagenie.ui.base.GenieBaseAdapter;
import com.example.ghagenie.ui.base.IRecyclerEventCallback;
import com.example.ghagenie.ui.model.NoteItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainFragment extends Fragment implements IRecyclerEventCallback {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private GenieBaseAdapter mNoteAdapter;
    private FloatingActionButton addNote;
    private int counter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        initialize();
    }

    private void initialize(){
        View view = getView();
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mRecyclerView = view.findViewById(R.id.content_recycler);
        addNote = view.findViewById(R.id.add_note);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        mViewModel.getNotesForTesting().observe(getViewLifecycleOwner(), items -> {
//            if (mNoteAdapter == null) {
//                mNoteAdapter = new NoteAdapter(MainFragment.this, items);
//                mRecyclerView.setAdapter(mNoteAdapter);
//            } else {
//                mNoteAdapter.addItems(items);
//            }
//        });
        NoteRepo.getInstance(getContext()).getAllNotes().observe(this,items -> {
            if (mNoteAdapter == null) {
                mNoteAdapter = new NoteAdapter(MainFragment.this, items);
                mRecyclerView.setAdapter(mNoteAdapter);
            } else {
                mNoteAdapter.addItem(items.get(items.size() -1));
            }
        });
        addNote.setOnClickListener(v -> {
            //mViewModel.addItemsForTest();
            NoteRepo.getInstance(getContext()).insertNote(new NoteItem("NotekascgsabchSGBCJSBCb " +
                    "alsjdgfuksdagfakusdgbfbvsdhslkacdlanilisdgv ldalashdvknfnhc.qskfsa" +
                    ".mlasfsagirc dhigai;fehqc;,ldlkjfilgmhqlyermcoaxvcanegvuq " +
                    "cfgyugrfbuenhfiwqfigfDFGBWQLIUGTALIFMDLOIQWGIFDH;Oa;oirjm9q3m8yrnp aigtuschf" +
                    " ffmvd;Hnbkzyg.jvdh.KNJdk./bdvhfisON" +
                    " "+ counter++,"some " +
                    "desc."));
        });
    }

}