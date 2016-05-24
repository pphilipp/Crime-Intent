package com.develop.philipp.criminalintent.model;

import android.content.Context;
import android.util.Log;

import com.develop.philipp.criminalintent.utils.CriminalIntentJSONSerializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class CrimeLab {
    private static final String LOG_TAG = CrimeLab.class.getSimpleName();
    private static final String FILENAME = "crimes.json";
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private CriminalIntentJSONSerializer mSerializer;


    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);
        try {
            mCrimes = mSerializer.loadCrimes();
        } catch (Exception e) {
            mCrimes = new ArrayList<Crime>();
            Log.e(LOG_TAG, "Error loading crimes: ", e);
        }
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

    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Log.d(LOG_TAG, "crimes saved to file");
            return true;
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error saving crimes: ", e);
            return false;
        }
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
