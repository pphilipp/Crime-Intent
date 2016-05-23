package com.develop.philipp.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;


    private CrimeLab(Context context) {
        mAppContext = context;
        mCrimes = new ArrayList<>();
//        addFakeListCrimes();

    }

    public static CrimeLab get(Context c) {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }

        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c: mCrimes) {
            if (c.getId().equals(id))
                return c;
        }

        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    private void addFakeListCrimes() {
        //add default data
        for (int i = 0; i < 5; i++) {
            Crime c = new Crime();
            c.setTitle("Crime ->" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }
}
