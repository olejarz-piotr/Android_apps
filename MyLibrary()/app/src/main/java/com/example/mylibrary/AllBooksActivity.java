package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";
    private RecyclerView booksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Log.d(TAG, "onCreate: started");

        booksRecView=findViewById(R.id.booksRecView);
        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));


//        books.add(new Book("Metro 2033", "Dmitrij Głuchowski", 578,
//                "https://s.lubimyczytac.pl/upload/books/4864000/4864254/693340-352x500.jpg", "Rosyjska powieść postapokaliptyczna napisana przez Dmitrija Głuchowskiego, pierwsza część trylogii. Akcja powieści rozgrywa się w moskiewskim metrze w 2033 roku, 20 lat po wojnie nuklearnej."));
//
//        books.add(new Book("Przełęcz Diatłowa. Tajemnica dziewięciorga", "Anna Matwiejewa", 302,
//                "https://www.swiatksiazki.pl/media/catalog/product/cache/43fcb9e324267e3fb85b10f84b2cbfd1/4/x/4x99906627440.jpg", "Wciągająca opowieść inspirowana tragicznymi wydarzeniami na Uralu sprzed ponad sześćdziesięciu lat, które do dzisiaj rozpalają wyobraźnię łowców zagadek.\n" +
//                "\n" +
//                "Czy rosyjskiej pisarce uda się rozwiązać jedną z największych tajemnic XX wieku?"));
//
//        books.add(new Book("Shaq bez cenzury", "Shaquille O’Neal, Jackie MacMullan", 325,
//                "https://s.lubimyczytac.pl/upload/books/154000/154278/352x500.jpg", "216 cm wzrostu, 140 kg wagi, a do tego niesłychana koordynacja, siła, eksplozywność, nieustępliwość i… wesołkowatość. Oto cały Shaquille O’Neal – postać wszechstronna zarówno na boisku, gdy dominował nad przeciwnikami, jak i poza nim, kiedy nagrywał kawałki z topowymi raperami bądź grał główną rolę w filmach o superbohaterach i komediach."));


        Util util=new Util();
        ArrayList<Book>books=new ArrayList<>();
        books=util.getAllBooks();
        adapter.setBooks(books);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }
}
