package com.webmangalist.demowebmangalist.controllers;


import java.util.ArrayList;
import java.util.List;

import com.webmangalist.demowebmangalist.models.KitsuAPI;

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
        System.out.println("\n\n\n\n INITIALISATION INDEX\n\n\n\n\n\n");
        if(manga != null){
            System.out.println("\n\n\n\n AOLKhnliokdfuh qikf\n\n\n\n\n\n");
            return searchManga(manga, modelMap);
        }else{
            return "home";
        }
    }


    
    @GetMapping("/search")
    public String searchManga(@RequestParam(required = false) String manga, ModelMap modelMap) throws Exception{

        /*String enviedecrever = "{'data':[{'id': 1,'type': 'manga','links': {'self': 'https://enviedemourir?'},'attributes':{'createdAt': '12/08/2020','canonicalTitle': 'Berserk'}},{'id': 2,'type': 'manga','links': {'self': 'https://enviedecrever?'},'attributes':{'createdAt': '12/12/2099','canonicalTitle': 'Attack of the tits'}},],'meta' : 'ayyayayayyay'}";
        System.out.println("\n\n\n\n jsonstring  : "+enviedecrever+"\n\n\n\n\n\n");
        modelMap.addAttribute("infoAPI", enviedecrever);
        JSONObject response = new JSONObject(enviedecrever);
        JSONArray data = new JSONArray(response.getJSONArray("data")) ;
        JSONObject mangaa = new JSONObject(data.getJSONObject(0).toString());
        JSONObject attributes = new JSONObject(mangaa.getJSONObject("attributes").toString());
        String canonicalTitle = attributes.getString("canonicalTitle");
        modelMap.addAttribute("infoAPI", canonicalTitle);*/
        
        KitsuAPI api = new KitsuAPI();
        if(!api.requestManga(manga).equals("") && api.requestManga(manga) != null){
            modelMap.addAttribute("search_mangas", api.getMangaNames(manga));
        }
            
        return "search";
    }

}