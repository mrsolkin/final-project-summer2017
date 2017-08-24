package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdgkazan.summer_school_2017.R;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.ApiFactory;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.CoinList;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.CoinService;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.DIGS;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by olgasmirnova on 20.08.17.
 */

public class CoinsActivity extends AppCompatActivity{

    private RecyclerView coinmarket;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coinmarket);
        coinmarket = (RecyclerView) findViewById(R.id.coins_list);
        coinmarket.setLayoutManager(new LinearLayoutManager(this));
        initViews();
        getPrice();

    }
    private void initViews() {
    }

    private class CoinsAdapter extends RecyclerView.Adapter<CoinViewHolder>{
        List<DIGS> coins;
        public CoinsAdapter(List<DIGS> coins){
            this.coins = coins;
        }
        @Override
        public CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new CoinViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(CoinViewHolder holder, int position) {
            DIGS coins_list = coins.get(position);
            holder.bindCoins(coins_list);
        }

        @Override
        public int getItemCount() {
            return coins.size();
        }
    }
     class CoinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.name)
         TextView name;
        @BindView(R.id.symbol)
         TextView symbol;
        @BindView(R.id.logo)
         ImageView logo;
        @BindView(R.id.next_page)
         ImageView next_page;
         DIGS coin;


        public void bindCoins(DIGS coin){
            name.setText(coin.getCoinName());
            symbol.setText(coin.getName());
            this.coin = coin;
            Picasso.with(CoinsActivity.this)
                    .load("https://www.cryptocompare.com"+coin.getImageUrl()).into(logo);
        }
        public CoinViewHolder(LayoutInflater inflator, ViewGroup parent) {
            super(inflator.inflate(R.layout.coin, parent, false));
            ButterKnife.bind(this,itemView);
            next_page.setOnClickListener(this);
        }

         @Override
         public void onClick(View v) {
             Intent intent = new Intent(CoinsActivity.this,ScrollingActivity.class);
             intent.putExtra(ScrollingActivity.KEY_COIN_NAME,coin.getName());
             intent.putExtra(ScrollingActivity.KEY_COIN_SYMBOL,coin.getCoinName());
             startActivity(intent);
         }
     }
    private void getPrice() {

        CoinService service = ApiFactory.getsRetrofitInstanceForList().create(CoinService.class);
        service.getPrice().enqueue(new Callback<CoinList>() {
            @Override
            public void onResponse(Call<CoinList> call, Response<CoinList> response) {
                CoinList data = response.body();
                Log.d("text", "onResponse: ");
                List<DIGS> list = new ArrayList<DIGS>(data.getData().values());
                CoinsAdapter adapter = new CoinsAdapter(list);
                coinmarket.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<CoinList> call, Throwable t) {
                Log.d("error", "onFailure: ");

            }
        });


    }

}
