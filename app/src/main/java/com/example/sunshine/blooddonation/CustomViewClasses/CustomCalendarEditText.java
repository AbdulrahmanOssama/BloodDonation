package com.example.sunshine.blooddonation.CustomViewClasses;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import com.example.sunshine.blooddonation.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomCalendarEditText extends LinearLayout {
    //vector drawable to set on EditText
    Drawable mIcon =null;
    Context mContext;
    //background that control the shape of layout
    Drawable mbackground=null;
    // text view  to set after user select date from calendar
    TextView textView;
    // image button that represent the calendar
    ImageButton imageButton;
    // hint for text view calenadar.
    String mHint;

    public CustomCalendarEditText(Context context) {
        super(context);
        this.mContext = context;
        init(null);
    }

    public CustomCalendarEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    public CustomCalendarEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }


    public void init(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomCalendarEditText, 0, 0);
        if(typedArray!=null) {
            mIcon=typedArray.getDrawable(R.styleable.CustomCalendarEditText_CalendarIcon);
            mbackground=typedArray.getDrawable(R.styleable.CustomCalendarEditText_CompoundBackgroundCalendar);
            mHint=typedArray.getString(R.styleable.CustomCalendarEditText_hintCalendar);
            typedArray.recycle();
        }
        View rootView = inflate(mContext, R.layout.calendar_edittext_compound_control, this);
        rootView.setBackground(mbackground);
        textView = rootView.findViewById(R.id.calendarText);
        imageButton = rootView.findViewById(R.id.calendar);
        textView.setHint(mHint);
        initCalendar();

    }

    public void initCalendar() {
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog().show();

            }
        });

    }





    private DatePickerDialog.OnDateSetListener dateListener() {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                Calendar mycalendar = Calendar.getInstance();
                mycalendar.set(Calendar.YEAR, year);
                mycalendar.set(Calendar.MONTH, month);
                mycalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                textView.setText(formatDate(mycalendar.getTime()));
            }


        };
    }

    private DatePickerDialog datePickerDialog() {
        Calendar myCalendar = Calendar.getInstance();
        return new DatePickerDialog(mContext, dateListener(), myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private String formatDate(Date date) {
        String Format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Format, Locale.ENGLISH);
        return simpleDateFormat.format(date);

    }


}
