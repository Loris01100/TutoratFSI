package com.example.tutoratfsi.Model.DAO;

import com.example.tutoratfsi.Model.BO.Etudiant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APITutorat {
    String BASE_URL = "https://olen-ort.fr/p2024/Ma2l/";

    @FormUrlEncoded
    @POST("api.php")
    Call<Etudiant> getEtudiant(@Field("identifiant") String username, @Field("mdpUtilisateur") String password);

    // Méthode pour obtenir tous les étudiants, si votre API le permet
    @GET("getAllEtudiants.php")
    Call<ArrayList<Etudiant>> getAllEtudiants();
}
