package com.zhi.www.filestore;

import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/10.
 */
public class ToastUtils {
    public static void make(@StringRes int resId){
        String content = App.getContext().getResources().getString(resId);
        Toast.makeText(App.getContext(), content, Toast.LENGTH_SHORT).show();
    }
}
