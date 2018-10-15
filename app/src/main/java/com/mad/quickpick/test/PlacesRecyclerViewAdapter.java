package com.mad.quickpick.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mad.quickpick.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacesRecyclerViewAdapter extends
        RecyclerView.Adapter<PlacesRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "PlacesRecyclerViewAdapt";
    private final GeoDataClient mGeoDataClient;

    private ArrayList<Place> mPlacesList;
    private Context mContext;
    //private GoogleApiClient mGoogleApiClient;
    /**
     * Current results returned by this adapter.
     */
    private ArrayList<Place> mResultList=new ArrayList<>();


    public PlacesRecyclerViewAdapter(ArrayList<Place> list, Context context, GeoDataClient geoDataClient, ) {
        mPlacesList = list;
        mContext = context;
        mGeoDataClient = geoDataClient;
    }
    @Override
    public int getItemCount() {
        return mPlacesList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load();

        final int itemPos = position;
        final Place place = mPlacesList.get(position);
        holder.name.setText(place.getName());
        holder.address.setText(place.getAddress());
        holder.phone.setText(place.getPhoneNumber());
        if(place.getWebsiteUri() != null){
            holder.website.setText(place.getWebsiteUri().toString());
        }

        if(place.getRating() > -1){
            holder.ratingBar.setNumStars((int)place.getRating());
        }else{
            holder.ratingBar.setVisibility(View.GONE);
        }

        if (!places.getPhotoRefrence().equals("null")) {
            String photorefrence = places.getPhotoRefrence();
            String url = baseUrl + photorefrence + "&key=" + key;


            final String placeId = places.getPlaceId();
            final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeId);
            photoMetadataResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoMetadataResponse>() {
                @Override
                public void onComplete(@NonNull Task<PlacePhotoMetadataResponse> task) {
                    // Get the list of photos.
                    PlacePhotoMetadataResponse photos = task.getResult();
                    // Get the PlacePhotoMetadataBuffer (metadata for all of the photos).
                    PlacePhotoMetadataBuffer photoMetadataBuffer = photos.getPhotoMetadata();
                    // Get the first photo in the list.
                    PlacePhotoMetadata photoMetadata = photoMetadataBuffer.get(0);
                    // Get the attribution text.
                    CharSequence attribution = photoMetadata.getAttributions();
                    // Get a full-size bitmap for the photo.
                    Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(photoMetadata);
                    photoResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoResponse>() {
                        @Override
                        public void onComplete(@NonNull Task<PlacePhotoResponse> task) {
                            PlacePhotoResponse photo = task.getResult();
                            Bitmap bitmap = photo.getBitmap();
                            holder.placeListIV.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rec_image)
        ImageView image;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.address)
        TextView address;

        @BindView(R.id.phone)
        TextView phone;

        @BindView(R.id.website)
        TextView website;

        @BindView(R.id.rating)
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            ButterKnife.bind(this, itemView);
            super(itemView);
        }
    }
}