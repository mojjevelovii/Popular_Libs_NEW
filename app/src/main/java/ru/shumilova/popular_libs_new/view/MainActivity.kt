package ru.shumilova.popular_libs_new.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.shumilova.popular_libs_new.R
import ru.shumilova.popular_libs_new.presenter.Presenter
import java.io.File

class MainActivity : MvpAppCompatActivity(), IMainView {
    private val presenter: Presenter by moxyPresenter { Presenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_convert.setOnClickListener { presenter.startConvert() }
    }

    override fun showImage(file: File) {
        Glide.with(this).load(file).centerCrop().into(iv_img)
    }

    override fun showError(exception: Throwable) {
        exception.message?.let { Snackbar.make(btn_convert, it, Snackbar.LENGTH_LONG).show() }
    }
}