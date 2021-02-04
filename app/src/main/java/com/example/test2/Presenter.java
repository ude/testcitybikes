package com.example.test2;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.test2.model.Network;
import com.example.test2.model.NetworkList;
import com.example.test2.model.StationModel;
import com.example.test2.model.StationResponse;
import com.example.test2.repository.remote.CityBikesInterfaceApi;
import com.example.test2.repository.remote.Injection;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


interface NetworksLoadedCallback {
    void onNetworksLoaded(List<Network> networks, Exception error);
}

interface StationDetailLoadedCallback {
    void detailsLoaded(List<StationModel> networks, Exception error);
}

public class Presenter extends ViewModel {
    private List<Network> networks = new ArrayList<>();
    private CityBikesInterfaceApi networkAPI = Injection.INSTANCE.getApi();

    //La función devuelve un parametro vacio, los valores los devolvemos usando la interface porque la llamada es (puede ser) asincróna
    public void loadNetworks(NetworksLoadedCallback callback){
        if (networks.size() > 0){
            callback.onNetworksLoaded(networks, null);
        } else {
            networkAPI.getNetworks().enqueue(new Callback<NetworkList>() {
                @Override
                public void onResponse(Call<NetworkList> call, Response<NetworkList> response) {
                    if (response.body()!=null && response.isSuccessful()){
                        networks.clear();
                        networks.addAll(response.body().getNetworks());
                        callback.onNetworksLoaded(response.body().getNetworks(), null);
                    }
                }
                
                @Override
                public void onFailure(Call<NetworkList> call, Throwable t) {
                    callback.onNetworksLoaded(null, new Exception(t.getLocalizedMessage()));
                }
            });
        }
    }

    public void loadStations(String networkId, StationDetailLoadedCallback callback){
        List<StationModel> filteredList = new ArrayList();
        networkAPI.getStations(networkId).enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
                filteredList.clear();
                for (StationModel model : response.body().getNetwork().getStations()){
                    if (model.getLatitude() != 0 && model.getLongitude()!=0 && model.getName() != null){
                        filteredList.add(model);
                    }
                }
                callback.detailsLoaded(response.body().getNetwork().getStations(), null);
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {
             callback.detailsLoaded(null, new Exception(t.getCause()));
            }
        });
    }
}
