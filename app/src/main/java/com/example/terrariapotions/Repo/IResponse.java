package com.example.terrariapotions.Repo;

import com.example.terrariapotions.Model.ChuckNoris;


//Callback to pass response from request class to repository
public interface IResponse {

   void getResponse(ChuckNoris chuckNoris);

   //void getPotionsData(List<Potion> potions);
}