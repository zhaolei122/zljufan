package com.bwie.gl_livevideo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bwie.gl_livevideo.R;
/**
 * SharePreferences工具类
 */
public class PreferencesUtil {

    public static SharedPreferences preferences;

    /*
     * 将数据存入配置文件的方法
     * void无返回类型
     */
    public static <T> String putPreferences(String key, T value, Context context) {
        checkSP(context);
        SharedPreferences.Editor editor = preferences.edit();
        if (value instanceof String) {
            editor.putString(key, value.toString());
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
        }
        editor.commit();
        return key;
    }

    /*
     * 检查配置文件是否存在
     */
    private static void checkSP(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(context.getString(R.string.sp_name), Context.MODE_PRIVATE);
        }
    }

    /*
     * 获取配置文件内容的方法
     * 返回类型为泛型：-T类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T getPreferences(String key, T value, Context context) {
        checkSP(context);
        Object o = null;
        if (value instanceof String) {
            o = preferences.getString(key, value.toString());
        } else if (value instanceof Boolean) {
            o = preferences.getBoolean(key,
                    ((Boolean) value).booleanValue());
        } else if (value instanceof Integer) {
            o = preferences.getInt(key,
                    ((Integer) value).intValue());
        } else if (value instanceof Float) {
            o = preferences.getFloat(key,
                    ((Float) value).floatValue());
        } else if (value instanceof Long) {
            o = preferences.getLong(key,
                    ((Long) value).longValue());
        }
        T t = (T) o;

        return t;
    }

    public static void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}


