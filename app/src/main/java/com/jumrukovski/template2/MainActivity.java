package com.jumrukovski.template2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jumrukovski.template2.base.BaseActivity;
import com.jumrukovski.template2.base.BaseBindingAdapter;
import com.jumrukovski.template2.data.model.Item;
import com.jumrukovski.template2.data.model.Result;
import com.jumrukovski.template2.databinding.ActivityMainBinding;
import com.jumrukovski.template2.domain.GetPopularTvShowsUseCase;
import com.jumrukovski.template2.domain.GetTopRatedTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

public class MainActivity extends BaseActivity {

    BaseBindingAdapter.ItemClickListener<Item> itemClickListener = (item, position) -> {
        // do some stuff on item click
    };

    private ActivityMainBinding binding;

    @Inject
    ShowAdapter adapter;

    @Inject
    GetPopularTvShowsUseCase getPopularTvShowsUseCase;

    @Inject
    GetTopRatedTvShowsUseCase getTopRatedTvShowsUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_popular) {
            getPopularTvShowsUseCase.execute(new PopularShowsSubscriber(), "en", "1");
        } else if (item.getItemId() == R.id.action_top_rated) {
            getTopRatedTvShowsUseCase.execute(new TopRatedShowsSubscriber(), "en", "1");
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {
        initRecyclerView();
        setAdapterItemClick();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        binding.itemsRecyclerView.setLayoutManager(layoutManager);
        binding.itemsRecyclerView.setAdapter(adapter);
    }

    private void setAdapterItemClick() {
        adapter.setItemClickListener(itemClickListener);
    }

    private void clearData() {
        adapter.clear();
    }

    private void provideItems(List<Item> items) {
        adapter.addItems(items);
    }

    @Override
    protected void onDestroy() {
        getPopularTvShowsUseCase.dispose();
        getTopRatedTvShowsUseCase.dispose();
        super.onDestroy();
    }

    private class PopularShowsSubscriber extends DisposableSingleObserver<Result<List<Item>>> {

        @Override
        public void onSuccess(Result<List<Item>> value) {
            clearData();
            provideItems(value.getResults());
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }
    }

    private class TopRatedShowsSubscriber extends DisposableSingleObserver<Result<List<Item>>> {

        @Override
        public void onSuccess(Result<List<Item>> value) {
            clearData();
            provideItems(value.getResults());
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
