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

public class WorldFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = WorldFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String worldUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.world));
        Log.e(LOG_TAG, worldUrl);

        return new NewsLoader(getActivity(), worldUrl);
    }
}
