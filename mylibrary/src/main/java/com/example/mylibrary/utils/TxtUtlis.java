package com.example.mylibrary.utils;

import android.text.TextUtils;
import android.widget.TextView;

public class TxtUtlis {
    public static void setTextView(TextView textView,String wold){
        if (textView!=null&&!TextUtils.isEmpty(wold)){
                textView.setText(wold);
        }
    }
}
