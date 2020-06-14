package com.example.terrariapotions.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.terrariapotions.Model.Category;
import com.example.terrariapotions.Model.CategoryPotion;
import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.Ingredient;
import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.Model.PotionIngredient;
import com.example.terrariapotions.R;
import com.example.terrariapotions.Remote.ChuckNorisRequest;
import com.example.terrariapotions.Repo.IResponse;
import com.example.terrariapotions.View.Adapter.PotionAdapter;
import com.example.terrariapotions.ViewModel.PotionViewModel;

import java.util.ArrayList;
import java.util.List;


public class PotionActivity extends AppCompatActivity implements IResponse {
    private static final String TAG = PotionActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private PotionAdapter potionAdapter;
    private ArrayList<Potion> listOfPotions;
    private ArrayList<CategoryPotion> listOfCategoryPotions;
    private PotionViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potion);

        listOfPotions = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(PotionViewModel.class);
        recyclerView = findViewById(R.id.rv);
        //Performance??
        recyclerView.setHasFixedSize(true);
        //Linear Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adapter
        potionAdapter = new PotionAdapter(listOfPotions);
        recyclerView.setAdapter(potionAdapter);

        observePotion();
        ChuckNorisRequest chuckNorisRequest = new ChuckNorisRequest();
////        chuckNorisRequest.getChuckNorisJoke(this);
        chuckNorisRequest.getPotionsData(this);
//        chuckNorisRequest.getListOfCategories(this);
//        chuckNorisRequest.getListOfCategoryPotions(this);
//        chuckNorisRequest.getListOfImagePotions(this);
//        chuckNorisRequest.getListOfIngredients(this);
//        chuckNorisRequest.getListOfPotionIngredients(this);



        //TEST
//        ImagePotion potionImage = viewModel.getImagePotionByName("Healing Potion");
//        int imageID =  potionImage.getImageID();
//        Log.d(TAG, " image ID: "+  imageID);
//
//        viewModel.updatePotion(5, imageID );
    }

    private void observePotion() {
        viewModel.getPotions().observe(this, potions -> {
            listOfPotions = (ArrayList<Potion>) potions;
            potionAdapter.setPotionList(potions);
            potionAdapter.notifyDataSetChanged();
        });
    }
    private void observeCategoryPotions(){
        viewModel.getCategoryPotions().observe(this, categoryPotions -> {
            listOfCategoryPotions = (ArrayList<CategoryPotion>) categoryPotions;


        });
    }

    @Override
    public void getResponse(ChuckNoris chuckNoris) {
        Toast.makeText(this, chuckNoris.getValue(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void getListOfCategories(List<Category> categories) {
        Toast.makeText(this, categories.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void getListOfCategoryPotions(List<CategoryPotion> categoryPotions) {
        Toast.makeText(this, categoryPotions.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void getListOfImagePotions(List<ImagePotion> imagePotions) {
        Toast.makeText(this, imagePotions.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void getListOfIngredients(List<Ingredient> ingredients) {
        Toast.makeText(this, ingredients.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void getPotionsData(List<Potion> potions) {
        Toast.makeText(this, potions.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void getListOfPotionIngredients(List<PotionIngredient> potionIngredients) {
        Toast.makeText(this, potionIngredients.toString(), Toast.LENGTH_LONG).show();
    }


//    private void observePotion() {
//        viewModel.getPotions().observe(this, new Observer<List<Potion>>() {
//            @Override
//            public void onChanged(List<Potion> potions) {
//
//            }
//        });
//    }



    
}
