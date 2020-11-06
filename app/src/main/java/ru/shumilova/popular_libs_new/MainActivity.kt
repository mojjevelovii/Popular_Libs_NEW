package ru.shumilova.popular_libs_new

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.shumilova.popular_libs_new.mvp.model.ClickButtonType
import ru.shumilova.popular_libs_new.mvp.presenter.Presenter
import ru.shumilova.popular_libs_new.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView,
    View.OnClickListener {
    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)

        btn_counter1.setOnClickListener(this)
        btn_counter2.setOnClickListener(this)
        btn_counter3.setOnClickListener(this)
    }

    override fun setButtonText(index: ClickButtonType, text: String?) {
        when (index) {
            ClickButtonType.BUTTON_ONE -> btn_counter1.text = text
            ClickButtonType.BUTTON_TWO -> btn_counter2.text = text
            ClickButtonType.BUTTON_THREE -> btn_counter3.text = text
        }
    }

    override fun onClick(view: View) {
        val id = when (view.id) {
            R.id.btn_counter1 -> ClickButtonType.BUTTON_ONE
            R.id.btn_counter2 -> ClickButtonType.BUTTON_TWO
            R.id.btn_counter3 -> ClickButtonType.BUTTON_THREE
            else -> null
        }
        id?.let { presenter?.counterClick(it) }
    }
}