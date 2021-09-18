package com.webmangalist.demowebmangalist.controllers;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webmangalist.demowebmangalist.models.Manga;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController{

    @GetMapping("/")
    public String index(@RequestParam(required = false) String manga, ModelMap modelMap) throws Exception{

        /*String enviedecrever = "{'data':[{'id': 1,'type': 'manga','links': {'self': 'https://enviedemourir?'},'attributes':{'createdAt': '12/08/2020','canonicalTitle': 'Berserk'}},{'id': 2,'type': 'manga','links': {'self': 'https://enviedecrever?'},'attributes':{'createdAt': '12/12/2099','canonicalTitle': 'Attack of the tits'}},],'meta' : 'ayyayayayyay'}";
        System.out.println("\n\n\n\n jsonstring  : "+enviedecrever+"\n\n\n\n\n\n");
        modelMap.addAttribute("infoAPI", enviedecrever);

        JSONObject response = new JSONObject(enviedecrever);
        JSONArray data = new JSONArray(response.getJSONArray("data")) ;
        JSONObject mangaa = new JSONObject(data.getJSONObject(0).toString());
        JSONObject attributes = new JSONObject(mangaa.getJSONObject("attributes").toString());
        String canonicalTitle = attributes.getString("canonicalTitle");

        modelMap.addAttribute("infoAPI", canonicalTitle);
        */

        //modelMap.addAttribute("manga", manga);
        String responseBody = getAPI(manga);
        System.out.println(parseJSONMangaSearch(responseBody).toString());
        modelMap.addAttribute("search_mangas", parseJSONMangaSearch(responseBody));
        
        return "home";
    }

    //Pour recuperer les donnees de l'API (sous JSON)
    public String getAPI(String manga){
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
            System.out.println("error API");
            return "error API";
        }
    }
    
    //On parse la reponse JSON pour ne recuperer que les titres des mangas
    public List<String> parseJSONMangaSearch(String responseBody){
        List<String> canonicalTitles = new ArrayList<>();
        JSONObject response = new JSONObject(responseBody);
        JSONArray data = new JSONArray(response.getJSONArray("data")) ;
        for (int i = 0; i < data.length(); i++){
            //System.out.println("\n\n\n\n DATA  " +i+" : "+data.getJSONObject(i)+"\n\n\n\n\n\n");
            JSONObject manga = new JSONObject(data.getJSONObject(i).toString());
            //System.out.println("\n\n\n\n MANGA :"+manga+"\n\n\n\n\n\n");
            JSONObject attributes = new JSONObject(manga.getJSONObject("attributes").toString());
            //System.out.println("\n\n\n\n ATTRIBUTES :"+attributes+"\n\n\n\n\n\n");
            String canonicalTitle = attributes.getString("canonicalTitle");
            canonicalTitles.add(canonicalTitle);
        }
        
        return canonicalTitles;
    }

}