package ru.shumilova.popular_libs_new

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.shumilova.popular_libs_new.mvp.presenter.Presenter
import ru.shumilova.popular_libs_new.mvp.view.MainView


class MainActivity : AppCompatActivity(), MainView,
    View.OnClickListener {
    private var presenter: Presenter? = null
    private var buttonCounter1: Button? = null
    private var buttonCounter2: Button? = null
    private var buttonCounter3: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)
        buttonCounter1 = findViewById(R.id.btn_counter1)
        buttonCounter2 = findViewById(R.id.btn_counter2)
        buttonCounter3 = findViewById(R.id.btn_counter3)
        buttonCounter1?.setOnClickListener(this)
        buttonCounter2?.setOnClickListener(this)
        buttonCounter3?.setOnClickListener(this)
    }

    override fun setButtonText(index: Int, text: String?) {
        when (index) {
            0 -> buttonCounter1!!.text = text
            1 -> buttonCounter2!!.text = text
            2 -> buttonCounter3!!.text = text
        }
    }

    override fun onClick(view: View) {
        presenter?.counterClick(view.id)
    }
}