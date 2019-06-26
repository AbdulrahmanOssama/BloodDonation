package com.example.sunshine.blooddonation.CustomViewClasses;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.sunshine.blooddonation.R;


public class CustomSpinnerEditText extends LinearLayout {
    Context mContext;
    //ref to autocomleteText
    AutoCompleteTextView meditText;
    //ref to mspinner
    Spinner mspinner;
    //mhint for autocompletetext
    String mhint = null;
    //background for the compound view
    Drawable mbackground = null;

    public CustomSpinnerEditText(Context context) {
        super(context);
        this.mContext = context;
        init(null);
    }

    public CustomSpinnerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);


    }

    public CustomSpinnerEditText(Context mContext, AttributeSet attrs, int defStyleAttr) {
        super(mContext, attrs, defStyleAttr);
        this.mContext = mContext;
        init(attrs);

    }

    public void init(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomSpinnerEditText, 0, 0);
        if (typedArray != null) {
            mhint = typedArray.getString(R.styleable.CustomSpinnerEditText_hint);
            mbackground = typedArray.getDrawable(R.styleable.CustomSpinnerEditText_CompoundBackgroundSpinner);
            typedArray.recycle();
        }
        View rootView = inflate(mContext, R.layout.spinner_edittext_compound_control, this);
        rootView.setBackground(mbackground);
        meditText = rootView.findViewById(R.id.AutoCompleteTextView);
        mspinner = rootView.findViewById(R.id.spinner);
        initSpinner(mspinner, meditText);
        initAutoCompleteEditText(meditText, mspinner, mhint);

    }

    public void initSpinner(Spinner spinner, final AutoCompleteTextView editText) {
        // Create an ArrayAdapter using the string array and a default mspinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext,
                R.array.governorates, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the mspinner
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //when user select an item from mspinner, autocomplete text is also set to the text user has selected.

                editText.setText((String) parent.getItemAtPosition(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        //register the listener for mspinner
        spinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void initAutoCompleteEditText(AutoCompleteTextView editText, Spinner spinner, String hint) {
        editText.setHint(hint);
        String[] res = getResources().getStringArray(R.array.governorates);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, res);
        editText.setAdapter(arrayAdapter);
    }

}
