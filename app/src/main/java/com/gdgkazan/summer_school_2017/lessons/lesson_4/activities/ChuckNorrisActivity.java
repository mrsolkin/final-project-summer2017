package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdgkazan.summer_school_2017.R;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.ApiFactory;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.ChuckService;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by olgasmirnova on 20.08.17.
 */

public class ChuckNorrisActivity extends AppCompatActivity{

    private RecyclerView chucknorrislist;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chucknorris);
        chucknorrislist = (RecyclerView) findViewById(R.id.list);
        chucknorrislist.setLayoutManager(new LinearLayoutManager(this));
        initViews();
        getJoke();

    }
    private void initViews() {
    }

    private class ChuckAdapter extends RecyclerView.Adapter<JokeViewHolder>{
        List<String> jokes;
        public ChuckAdapter(List<String> jokes){
            this.jokes = jokes;
        }
        @Override
        public JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new JokeViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeViewHolder holder, int position) {
            String joke = jokes.get(position);
            holder.bindJoke(joke);
        }

        @Override
        public int getItemCount() {
            return jokes.size();
        }
    }
    private class JokeViewHolder extends RecyclerView.ViewHolder{
        private TextView joke;

        public void bindJoke (String joke){
            this.joke.setText(joke);
        }
        public JokeViewHolder(LayoutInflater inflator, ViewGroup parent) {
            super(inflator.inflate(R.layout.list_chuck, parent, false));
            joke = (TextView) itemView.findViewById(R.id.joke);
        }
    }
    private void getJoke() {

        ChuckService service = ApiFactory.getRetrofitInstance().create(ChuckService.class);
        service.getJoke("Olga","Smirnova").enqueue(new Callback<ChuckJoke>() {
            @Override
            public void onResponse(Call<ChuckJoke> call, Response<ChuckJoke> response) {
               ChuckJoke chuckjokeresponse = response.body();
                List<String> jokes = new ArrayList<String>();
                for (ChuckJoke.Value chuckJoke: chuckjokeresponse.list){
                    jokes.add(String.valueOf(chuckJoke.joke));
                }
                Log.d("one", "onResponse: "+jokes.size());
                chucknorrislist.setAdapter(new ChuckAdapter(jokes));
            }

            @Override
            public void onFailure(Call<ChuckJoke> call, Throwable t) {

            }
        });


    }

}
