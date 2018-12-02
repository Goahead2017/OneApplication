package com.cqupt.personal.oneapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 设置发布事件上传图片时的对话框
 */

public class PictureDialog extends Dialog {

    private Context context;
    private TextView tv1;
    private TextView tv2;
    private SendEventActivity sendEventActivity;

    public PictureDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public PictureDialog(@NonNull Context context, int themeResId, SendEventActivity sendEventActivity) {
        super(context, themeResId);
        this.context = context;
        this.sendEventActivity = sendEventActivity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.picture_dialog, null);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEventActivity.choosePhoto();
                dismiss();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEventActivity.takePhoto();
                dismiss();
            }
        });
        setContentView(view);
    }
}