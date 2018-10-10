//package com.mad.quickpick.trippreferences.preferences;
//
//import android.content.Intent;
//import android.content.res.Resources;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.text.Html;
//import android.text.Spanned;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GoogleApiAvailability;
//import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
//import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.location.places.GeoDataClient;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlaceAutocomplete;
//import com.mad.quickpick.R;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//import static com.google.android.gms.location.places.Places.getGeoDataClient;
//
//public class TripPreferencesActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
//    private static final int PLACE_PICKER_REQUEST = 1;
//
////    private GoogleApiClient mGoogleApiClient;
//
////    @BindView(R.id.preferences_next_fab)
////    public FloatingActionButton mFab;
//
//    @BindView(R.id.preferences_how_much_spinner)
//    public Spinner mHowMuchSpinner;
//
//    @BindView(R.id.preferences_location_selected_tv)
//    public TextView mWhereToTV;
//
//    @BindView(R.id.preferences_eat_checkbox)
//    public CheckBox mEatCheckBox;
//
//    @BindView(R.id.preferences_drink_checkbox)
//    public CheckBox mDrinkCheckBox;
//
//    @BindView(R.id.preferences_explore_checkbox)
//    public CheckBox mExploreCheckBox;
//
//    @BindView(R.id.preferences_relax_checkbox)
//    public CheckBox mRelaxCheckBox;
//
//    @BindView(R.id.preferences_where_to_button)
//    public Button mWhereToButton;
//
//    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
//
//    private TextView mPlaceDetailsText;
//
//    private TextView mPlaceAttribution;
//
//    public static final String TAG = "TripPreferences";
//    //private PlaceAutocompleteAdapter mPlaceAutocompleteAdapter;
//    private GoogleApiClient mGoogleApiClient;
//
//    protected GeoDataClient mGeoDataClient;
//
//    //String howMuch = mHowMuchSpinner.getSelectedItem().toString();
//    //String whereAt = mWhereToTV.toString();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_preferences);
//        ButterKnife.bind(this);
//
//        mPlaceDetailsText = (TextView) findViewById(R.id.place_details);
//        mPlaceAttribution = (TextView) findViewById(R.id.place_attribution);
//
//    }
//
////    @OnItemSelected(R.id.preferences_how_much_spinner)
////    public void spinnerItemSelected(Spinner spinner, int position) {
////        String text = mHowMuchSpinner.getSelectedItem().toString();
////    }
//
//    @OnClick(R.id.preferences_where_to_button)
//    void startAutocomplete() {
//        openAutocompleteActivity();
//        //Toast.makeText(TripPreferencesActvity.this, "Opening Autocomplete", Toast.LENGTH_SHORT).show();
//    }
//
//    private void openAutocompleteActivity() {
//        try {
//            // The autocomplete activity requires Google Play Services to be available. The intent
//            // builder checks this and throws an exception if it is not the case.
//            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
//                    .build(this);
//            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
//        } catch (GooglePlayServicesRepairableException e) {
//            // Indicates that Google Play Services is either not installed or not up to date. Prompt
//            // the user to correct the issue.
//            GoogleApiAvailability.getInstance().getErrorDialog(this, e.getConnectionStatusCode(),
//                    0 /* requestCode */).show();
//        } catch (GooglePlayServicesNotAvailableException e) {
//            // Indicates that Google Play Services is not available and the problem is not easily
//            // resolvable.
//            String message = "Google Play Services is not available: " +
//                    GoogleApiAvailability.getInstance().getErrorString(e.errorCode);
//
//            Log.e(TAG, message);
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /**
//     * Called after the autocomplete activity has finished to return its result.
//     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Check that the result was from the autocomplete widget.
//        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
//            if (resultCode == RESULT_OK) {
//                // Get the user's selected place from the Intent.
//                Place place = PlaceAutocomplete.getPlace(this, data);
//                Log.i(TAG, "Place Selected: " + place.getName());
//
//                // Format the place's details and display them in the TextView.
////                mPlaceDetailsText.setText(formatPlaceDetails(getResources(), place.getName(),
////                        place.getId(), place.getAddress(), place.getPhoneNumber(),
////                        place.getWebsiteUri()));
//                mWhereToTV.setText(formatPlaceDetails(getResources(), place.getName()));
//
//                // Display attributions if required.
//                CharSequence attributions = place.getAttributions();
//                if (!TextUtils.isEmpty(attributions)) {
//                    mPlaceAttribution.setText(Html.fromHtml(attributions.toString()));
//                } else {
//                    mPlaceAttribution.setText("");
//                }
//            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
//                Status status = PlaceAutocomplete.getStatus(this, data);
//                Log.e(TAG, "Error: Status = " + status.toString());
//            } else if (resultCode == RESULT_CANCELED) {
//                // Indicates that the activity closed before a selection was made. For example if
//                // the user pressed the back button.
//            }
//        }
//    }
//
//    /**
//     * Helper method to format information about a place nicely.
//     */
//    private static Spanned formatPlaceDetails(Resources res, CharSequence name) {
//                                              //String id,
//                                              //CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
////        Log.e(TAG, res.getString(R.string.place_details, name, id, address, phoneNumber,
////                websiteUri));
////        return Html.fromHtml(res.getString(R.string.place_details, name, id, address, phoneNumber,
////                websiteUri));
//        return Html.fromHtml(res.getString(R.string.preferences_location_selected_tv, name));
//
//    }
//
//    @OnClick (R.id.preferences_next_fab)
//    public void makeToast(){
//        Toast.makeText(TripPreferencesActivity.this, "Finding places to eat/drink/relax/explore in "
//                + " costing ", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//}
