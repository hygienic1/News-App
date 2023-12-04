package com.kwasi.newsapp.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.loader.content.Loader;
import com.kwasi.newsapp.News;
import com.kwasi.newsapp.NewsLoader;
import com.kwasi.newsapp.NewsPreferences;
import com.kwasi.newsapp.R;

import java.util.List;

public class SocietyFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = SocietyFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String societyUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.society));
        Log.e(LOG_TAG, societyUrl);

        return new NewsLoader(getActivity(), societyUrl);
    }
}