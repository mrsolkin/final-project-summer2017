package com.gdgkazan.summer_school_2017.lessons.lesson_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdgkazan.summer_school_2017.R;
import com.gdgkazan.summer_school_2017.lessons.lesson_2.models.CapitalModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timur Valiev
 */
public class SecondLessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_second_lesson);

        RecyclerView citiesListView = (RecyclerView) findViewById(R.id.rvCountries);

        // Создаём и задаём менеджер лэйаутов
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        citiesListView.setLayoutManager(layoutManager);

        // Создаём список тестовых данных
        List<CapitalModel> cities = generateCitiesList();

        // Создаём и задаём адаптер данных
        final CitiesAdapter citiesAdapter = new CitiesAdapter(cities);
        citiesListView.setAdapter(citiesAdapter);

        // Создаём и задаём класс, отвечающий за "декорирование" элементов (добавляем разделители)
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        citiesListView.addItemDecoration(itemDecoration);

        // Создаём и задаём класс, отвечающий за анимации
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        citiesListView.setItemAnimator(itemAnimator);

        findViewById(R.id.btnAddElements).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<CapitalModel> newlist = new ArrayList<>();
                newlist.add(new CapitalModel("Новые Москва", "Россия"));
                newlist.add(new CapitalModel("Новые Казань", "Россия"));
                newlist.add(new CapitalModel("Новые Челны", "Россия"));
                newlist.add(new CapitalModel("Новые Берлин", "Германия"));
                newlist.add(new CapitalModel("Новые Пекин", "Китай"));
                citiesAdapter.add(3, newlist);
            }
        });
    }

    private List<CapitalModel> generateCitiesList() {
        List<CapitalModel> cities = new ArrayList<>();
        cities.add(new CapitalModel("Москва", "Россия"));
        cities.add(new CapitalModel("Казань", "Россия"));
        cities.add(new CapitalModel("Челны", "Россия"));
        cities.add(new CapitalModel("Берлин", "Германия"));
        cities.add(new CapitalModel("Пекин", "Россия"));
        cities.add(new CapitalModel("Сингапур", "Сингапур"));
        cities.add(new CapitalModel("Москва", "Россия"));
        cities.add(new CapitalModel("Казань", "Китай"));
        cities.add(new CapitalModel("Челны", "Россия"));
        cities.add(new CapitalModel("Берлин", "Германия"));
        cities.add(new CapitalModel("Пекин", "Россия"));
        cities.add(new CapitalModel("Сингапур", "Сингапур"));
        cities.add(new CapitalModel("Москва", "Россия"));
        cities.add(new CapitalModel("Казань", "Россия"));
        cities.add(new CapitalModel("Челны", "Россия"));
        cities.add(new CapitalModel("Берлин", "Германия"));
        cities.add(new CapitalModel("Пекин", "Россия"));
        cities.add(new CapitalModel("Сингапур", "Сингапур"));
        cities.add(new CapitalModel("Москва", "Россия"));
        cities.add(new CapitalModel("Казань", "Россия"));
        cities.add(new CapitalModel("Челны", "Россия"));
        cities.add(new CapitalModel("Берлин", "Германия"));
        cities.add(new CapitalModel("Пекин", "Россия"));
        cities.add(new CapitalModel("Сингапур", "Сингапур"));
        return cities;
    }

    class CitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> {

        private List<CapitalModel> cities;

        public CitiesAdapter(List<CapitalModel> cities) {
            this.cities = cities;
        }

        @Override
        public CitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View rowView = layoutInflater.inflate(R.layout.li_city, parent, false);
            return new CitiesViewHolder(rowView);
        }

        @Override
        public void onBindViewHolder(CitiesViewHolder holder, int position) {
            // Задаём имя города
            String cityName = cities.get(position).getCityName();
            TextView cityNameView = holder.cityNameView;
            cityNameView.setText(cityName);

            // Задаём имя страны
            String countryName = cities.get(position).getCountryName();
            TextView countryNameView = holder.countryNameView;
            countryNameView.setText(countryName);
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }

        public void add(int i, List<CapitalModel> newlist) {
            cities.addAll(i, newlist);
            notifyItemRangeInserted(i, newlist.size());
        }
    }

    class CitiesViewHolder extends RecyclerView.ViewHolder {

        public TextView cityNameView;
        public TextView countryNameView;

        public CitiesViewHolder(View itemView) {
            super(itemView);
            cityNameView = (TextView) itemView.findViewById(R.id.tvCityName);
            countryNameView = (TextView) itemView.findViewById(R.id.tvCountryName);
        }
    }


}
