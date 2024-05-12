package com.example.tutoratfsi.Model.DAO;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitEtudiant {
        private static Retrofit retrofit = null;

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(APITutorat.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

        public static APITutorat getApiTutorat() {
            return getRetrofitInstance().create(APITutorat.class);
        }
}
