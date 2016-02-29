package com.develop.philipp.criminalintent;


import android.support.v4.app.Fragment;
import com.develop.philipp.criminalintent.fragments.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
