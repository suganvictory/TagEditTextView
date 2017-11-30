package com.tagedittextview;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tagedittextlibrary.Utils.SingletonLibrary;
import com.tagedittextlibrary.Widgets.TagsEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.mTagsEditTextKeyword)
    TagsEditText mTagsEditTextKeyword;
    @BindView(R.id.addkey)
    LinearLayout addkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        addkey.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addkey:
                AddKeywordTagsfromDialog();
                break;
        }
    }

    private void AddKeywordTagsfromDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.addkeypoints);
        final EditText addkeys = (EditText) dialog.findViewById(R.id.addkeys);
        Button Cancel = (Button) dialog.findViewById(R.id.cancel);
        Button Add = (Button) dialog.findViewById(R.id.add);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(addkeys.getWindowToken(), 0);
                dialog.dismiss();
            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (addkeys.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Keyword", Toast.LENGTH_SHORT).show();
                } else {
                    SingletonLibrary.getInstance().arrayListKeys.add(addkeys.getText().toString());
                    SingletonLibrary.getInstance().stringArrKeys = new String[SingletonLibrary.getInstance().arrayListKeys.size()];
                    SingletonLibrary.getInstance().stringArrKeys = SingletonLibrary.getInstance().arrayListKeys.toArray(SingletonLibrary.getInstance().stringArrKeys);
                    mTagsEditTextKeyword.setTags(SingletonLibrary.getInstance().stringArrKeys);

                    InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(addkeys.getWindowToken(), 0);
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        addkeys.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        Window windo = dialog.getWindow();
        windo.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

}
