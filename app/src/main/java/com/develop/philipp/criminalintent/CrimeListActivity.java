package com.develop.philipp.criminalintent;

import android.support.v4.app.Fragment;
import com.develop.philipp.criminalintent.fragments.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
