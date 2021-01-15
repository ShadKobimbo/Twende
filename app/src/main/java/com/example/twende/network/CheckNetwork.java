package com.example.twende.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class CheckNetwork {

    private Context context;
    private Boolean isConnected = false;

    public CheckNetwork(Context context) {
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean registerNetworkCallback() {

        try {

            ConnectivityManager cm
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkRequest.Builder builder = new NetworkRequest.Builder();

            cm.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback(){
                @Override
                public void onAvailable(Network network) {
                    isConnected = true;
                }
                @Override
                public void onLost(Network network) {
                    isConnected = false;
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isConnected;
    }
}
