package com.webmangalist.demowebmangalist.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class KitsuAPI {


    private String infoAPI;

    public KitsuAPI(){
        //empty constructor
    }


    //Pour recuperer les donnees de l'API (sous JSON) en String
    public String requestManga(String manga){
        try {
            manga = manga.replace(" ", "+");
            //System.out.println(manga);
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://kitsu.io/api/edge/manga?filter%5Btext%5D="+ manga))
                .header("Accept", "application/vnd.api+json")
                .header("Content-Type", "application/vnd.api+json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            return response.body();
        } catch (Exception e) {
            //System.out.println("error API");
            return "errorAPI";
        }
    }

     //On parse la reponse JSON pour ne recuperer que les titres des mangas
     public List<String> parseManga(String jsonString){
        List<String> canonicalTitles = new ArrayList();
        JSONObject response = new JSONObject(jsonString);
        JSONArray data = new JSONArray(response.getJSONArray("data")) ;
        for (int i = 0; i < data.length(); i++){
            JSONObject manga = new JSONObject(data.getJSONObject(i).toString());
            JSONObject attributes = new JSONObject(manga.getJSONObject("attributes").toString());
            String canonicalTitle = attributes.getString("canonicalTitle");
            canonicalTitles.add(canonicalTitle);
        }
        
        return canonicalTitles;
    }

    //On retourne le nom des mangas correspondants à celui en entrée
    public List<String> getMangaNames(String manga){
        return this.parseManga(this.requestManga(manga));
    }
}
