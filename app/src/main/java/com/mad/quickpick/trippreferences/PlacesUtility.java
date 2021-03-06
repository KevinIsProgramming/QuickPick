//package com.mad.quickpick.trippreferences;
//
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.text.Html;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GoogleApiAvailability;
//import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
//import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlaceAutocomplete;
//
//public class PlacesUtility extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
//
//    private static final String TAG = "PlacesActivity";
//
//    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
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
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//}
