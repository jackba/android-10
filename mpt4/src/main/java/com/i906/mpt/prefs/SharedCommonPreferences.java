package com.i906.mpt.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Noorzaini Ilhami
 */
public class SharedCommonPreferences implements CommonPreferences {

    private final static String KEY_IS_FIRST_START = "is_first_start";

    private final SharedPreferences mPrefs;

    public SharedCommonPreferences(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public boolean isFirstStart() {
        return mPrefs.getBoolean(KEY_IS_FIRST_START, true);
    }

    @Override
    public void setFirstStart(boolean firstStart) {
        mPrefs.edit()
                .putBoolean(KEY_IS_FIRST_START, firstStart)
                .apply();
    }

    @Override
    public int getHijriOffset() {
        return Integer.valueOf(mPrefs.getString("hijri_offset", "0"));
    }
}
