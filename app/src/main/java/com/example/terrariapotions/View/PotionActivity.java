package com.example.terrariapotions.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.PotionNew;
import com.example.terrariapotions.R;
import com.example.terrariapotions.Remote.ChuckNorisRequest;
import com.example.terrariapotions.Repo.IResponse;
import com.example.terrariapotions.View.Adapter.PotionAdapter;
import com.example.terrariapotions.ViewModel.PotionViewModel;

import java.util.ArrayList;


public class PotionActivity extends AppCompatActivity implements IResponse {
    private static final String TAG = PotionActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private PotionAdapter potionAdapter;
    private ArrayList<PotionNew> listOfPotions;
    private PotionViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potion);

        listOfPotions = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(PotionViewModel.class);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        potionAdapter = new PotionAdapter(listOfPotions);
        recyclerView.setAdapter(potionAdapter);

        observePotion();

        ChuckNorisRequest chuckNorisRequest = new ChuckNorisRequest();
        chuckNorisRequest.getChuckNorisJoke(this);

        //TEST
        ImagePotion potionImage = viewModel.getImagePotionByName("Healing Potion");
        int imageID =  potionImage.getImageID();
        Log.d(TAG, " image ID: "+  imageID);

        viewModel.updatePotion(5, imageID );
    }

    private void observePotion() {
        viewModel.getPotions().observe(this, potions -> {
            listOfPotions = (ArrayList<PotionNew>) potions;
            potionAdapter.setPotionList(potions);
            potionAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void getResponse(ChuckNoris chuckNoris) {
        Toast.makeText(this, chuckNoris.getValue(), Toast.LENGTH_LONG).show();

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
