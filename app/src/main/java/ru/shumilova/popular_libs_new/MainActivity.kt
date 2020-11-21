package ru.shumilova.popular_libs_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import moxy.MvpAppCompatActivity
import ru.shumilova.popular_libs_new.view.IMainView

class MainActivity : MvpAppCompatActivity(), IMainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}