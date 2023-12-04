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

public class CultureFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = CultureFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String cultureUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.culture));
        Log.e(LOG_TAG, cultureUrl);

        return new NewsLoader(getActivity(), cultureUrl);
    }
}
