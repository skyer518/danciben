package cn.com.u2be.danciben;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.com.u2be.danciben.entity.Word;
import cn.com.u2be.danciben.loader.PersenterLoaderCallBack;
import cn.com.u2be.danciben.persenter.ImportPersenter;
import cn.com.u2be.danciben.persenter.WordPersenter;
import cn.com.u2be.danciben.view.WordsView;
import me.seewhy.indexableRecyclerView.IndexableRecyclerView;
import me.seewhy.indexableRecyclerView.IndexableRecyclerViewAdapter;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, WordsView {


    private static final String P_Word = "Q";
    private static final String P_Import = "W";


    @InjectView(R.id.irv_words)
    IndexableRecyclerView irvWords;

    private IndexableRecyclerViewAdapter indexableRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initPersenter();

        this.indexableRecyclerViewAdapter = new IndexableRecyclerViewAdapter(this, new ArrayList<Word>(0));
        irvWords.setAdapter(indexableRecyclerViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WordPersenter wordPersenter = (WordPersenter) persenterArrayMap.get(P_Word);
        wordPersenter.LoadWords(this);

    }

    private void initPersenter() {

        persenterArrayMap = new HashMap<>(0);
        persenterArrayMap.put(P_Word, new WordPersenter());
        persenterArrayMap.put(P_Import, new ImportPersenter());

        getLoaderManager().initLoader(0, null, new PersenterLoaderCallBack(this, getPersenterArrayMap()));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            gotoReviseView();
        } else if (id == R.id.nav_slideshow) {
            gotoExamView();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            ImportPersenter importPersenter = (ImportPersenter) persenterArrayMap.get(P_Import);
            importPersenter.improt(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void gotoReviseView() {
        Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
    }

    private void gotoExamView() {
        Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
    }

    @Override
    public void showData(List<Word> words) {
        Log.i("eeee", "00___________________________________00");

        this.indexableRecyclerViewAdapter.setmWords(words);
        irvWords.setAdapter(indexableRecyclerViewAdapter);
        this.indexableRecyclerViewAdapter.notifyDataSetChanged();
    }


}
