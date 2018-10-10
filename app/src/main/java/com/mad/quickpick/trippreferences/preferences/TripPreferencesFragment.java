//package com.mad.quickpick.trippreferences.preferences;
//
//import android.content.res.Resources;
//import android.support.v4.app.Fragment;
//import android.text.Html;
//import android.text.Spanned;
//import android.widget.Toast;
//
//import com.mad.quickpick.R;
//
//import butterknife.OnClick;
//
//public class TripPreferencesFragment extends Fragment {
//
//
//
//    @OnClick(R.id.preferences_where_to_button)
//    void startAutocomplete() {
//        //openAutocompleteActivity();
//        //Toast.makeText(TripPreferencesActvity.this, "Opening Autocomplete", Toast.LENGTH_SHORT).show();
//    }
//
//
//
//    /**
//     * Helper method to format information about a place nicely.
//     */
//    private static Spanned formatPlaceDetails(Resources res, CharSequence name) {
//        //String id,
//        //CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
////        Log.e(TAG, res.getString(R.string.place_details, name, id, address, phoneNumber,
////                websiteUri));
////        return Html.fromHtml(res.getString(R.string.place_details, name, id, address, phoneNumber,
////                websiteUri));
//        return Html.fromHtml(res.getString(R.string.preferences_location_selected_tv, name));
//
//    }
//
//    @OnClick(R.id.preferences_next_fab)
//    public void makeToast(){
//        Toast.makeText(getActivity(), "Finding places to eat/drink/relax/explore in "
//                + " costing ", Toast.LENGTH_SHORT).show();
//    }
//}
