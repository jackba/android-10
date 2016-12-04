package com.i906.mpt.settings;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.Preference;

import com.i906.mpt.R;
import com.i906.mpt.analytics.AnalyticsProvider;
import com.i906.mpt.internal.Dagger;

/**
 * @author Noorzaini Ilhami
 */
public class MoreFragment extends BasePreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_more);

        Preference dashclock = findPreference("dashclock_visibility");
        dashclock.setEnabled(isAppInstalled("net.nurik.roman.dashclock"));

        SettingsActivity.bindPreferenceSummaryToValue(dashclock);
        SettingsActivity.bindPreferenceSummaryToValue(findPreference("hijri_offset"));

        Dagger.getGraph(getActivity())
                .getAnalyticsProvider()
                .trackViewedScreen(AnalyticsProvider.SCREEN_SETTINGS_MORE);
    }

    private boolean isAppInstalled(String packageName) {
        PackageManager pm = getActivity().getPackageManager();

        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            //
        }

        return false;
    }
}
