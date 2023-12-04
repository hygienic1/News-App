package com.kwasi.newsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import com.kwasi.newsapp.utilities.Constants;

import static com.kwasi.newsapp.utilities.Constants.API_KEY;
import static com.kwasi.newsapp.utilities.Constants.API_KEY_PARAM;
import static com.kwasi.newsapp.utilities.Constants.FORMAT;
import static com.kwasi.newsapp.utilities.Constants.FORMAT_PARAM;
import static com.kwasi.newsapp.utilities.Constants.FROM_DATE_PARAM;
import static com.kwasi.newsapp.utilities.Constants.ORDER_BY_PARAM;
import static com.kwasi.newsapp.utilities.Constants.ORDER_DATE_PARAM;
import static com.kwasi.newsapp.utilities.Constants.PAGE_SIZE_PARAM;
import static com.kwasi.newsapp.utilities.Constants.QUERY_PARAM;
import static com.kwasi.newsapp.utilities.Constants.SECTION_PARAM;
import static com.kwasi.newsapp.utilities.Constants.SHOW_FIELDS;
import static com.kwasi.newsapp.utilities.Constants.SHOW_FIELDS_PARAM;
import static com.kwasi.newsapp.utilities.Constants.SHOW_TAGS;
import static com.kwasi.newsapp.utilities.Constants.SHOW_TAGS_PARAM;

public final class NewsPreferences {

    public static Uri.Builder getPreferredUri(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        String numOfItems = sharedPrefs.getString(
                context.getString(R.string.settings_number_of_items_key),
                context.getString(R.string.settings_number_of_items_default));

        String orderBy = sharedPrefs.getString(
                context.getString(R.string.settings_order_by_key),
                context.getString(R.string.settings_order_by_default));

        String orderDate = sharedPrefs.getString(
                context.getString(R.string.settings_order_date_key),
                context.getString(R.string.settings_order_date_default));

        String fromDate = sharedPrefs.getString(
                context.getString(R.string.settings_from_date_key),
                context.getString(R.string.settings_from_date_default));

        Uri baseUri = Uri.parse(Constants.NEWS_REQUEST_URL);

        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter(QUERY_PARAM, "");
        uriBuilder.appendQueryParameter(ORDER_BY_PARAM, orderBy);
        uriBuilder.appendQueryParameter(PAGE_SIZE_PARAM, numOfItems);
        uriBuilder.appendQueryParameter(ORDER_DATE_PARAM, orderDate);
        uriBuilder.appendQueryParameter(FROM_DATE_PARAM, fromDate);
        uriBuilder.appendQueryParameter(SHOW_FIELDS_PARAM, SHOW_FIELDS);
        uriBuilder.appendQueryParameter(FORMAT_PARAM, FORMAT);
        uriBuilder.appendQueryParameter(SHOW_TAGS_PARAM, SHOW_TAGS);
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        return uriBuilder;
    }
    public static String getPreferredUrl(Context context, String section) {
        Uri.Builder uriBuilder = getPreferredUri(context);
        return uriBuilder.appendQueryParameter(SECTION_PARAM, section).toString();
    }
}
