package com.jiyue.duoshicibao.util.share_preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 可以抽取出来使用的SharePreferenceUtil，与应用逻辑无耦合
 */
public class SharePreferenceUtil {

    // 文件名
    private static final String FILE_NAME = "Important";
    //上下文Context
    private static Context context;

    /**
     * 使用Application的上下文Context完成赋值
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        SharePreferenceUtil.context = context;
    }

    /**
     * 返回对应的SharePreferences对象
     *
     * @return {@link SharedPreferences}
     */
    private static SharedPreferences sharedPreferences() {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 统一的入值操作
     *
     * @param key   键名
     * @param value 对应的值
     */
    public static void putValue(String key, Object value) {
        SharedPreferences.Editor editor = sharedPreferences().edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        }
        editor.commit();
    }

    /**
     * 获取本地字符串，若不存在则返回空字符串
     *
     * @param key 键值
     * @return 本地字符串
     */
    public static String getString(String key) {
        return getString(key, "");
    }

    /**
     * 获取本地字符串，若不存在则返回对应默认值
     *
     * @param key          键值
     * @param defaultValue 默认值
     * @return 本地字符串
     */
    public static String getString(String key, String defaultValue) {
        return sharedPreferences().getString(key, defaultValue);
    }

    /**
     * 获取本地整数，若不存在则返回0
     *
     * @param key 键值
     * @return 本地整数
     */
    public static int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * 获取本地整数，若不存在则返回默认值
     *
     * @param key          键值
     * @param defaultValue 默认值
     * @return 本地整数
     */
    public static int getInt(String key, int defaultValue) {
        return sharedPreferences().getInt(key, defaultValue);
    }

    /**
     * 获取本地浮点数，若不存在则返回0
     *
     * @param key 键值
     * @return 本地浮点数
     */
    public static float getFloat(String key) {
        return getFloat(key, 0);
    }

    /**
     * 获取本地浮点数，若不存在则返回默认值
     *
     * @param key          键值
     * @param defaultValue 默认值
     * @return 本地浮点数
     */
    public static float getFloat(String key, float defaultValue) {
        return sharedPreferences().getFloat(key, defaultValue);
    }

    /**
     * 获取本地长整数，若不存在则返回0
     *
     * @param key 键值
     * @return 本地长整数
     */
    public static long getLong(String key) {
        return getLong(key, 0);
    }

    /**
     * 获取本地长整数，若不存在则返回默认值
     *
     * @param key          键值
     * @param defaultValue 默认值
     * @return 本地长整数
     */
    public static long getLong(String key, long defaultValue) {
        return sharedPreferences().getLong(key, defaultValue);
    }

    /**
     * 获取本地布尔值，若不存在则返回false
     *
     * @param key 键值
     * @return 本地布尔值
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * 获取本地布尔值，若不存在则返回默认值
     *
     * @param key          键值
     * @param defaultValue 默认值
     * @return 本地布尔值
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences().getBoolean(key, defaultValue);
    }
}
