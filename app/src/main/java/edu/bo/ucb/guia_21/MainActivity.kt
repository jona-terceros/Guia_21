package edu.bo.ucb.guia_21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myBook = Book("Android 101")
        val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
        val bookRepository = BookRepository(bookDao)

        GlobalScope.launch {
            bookRepository.insert(myBook)
            val list = bookRepository.getListBook()
            list.forEach {
                Log.d("DBTEST", "El id del libro es ${it.id} , (${it.title})" )
            }
        }




    }
}