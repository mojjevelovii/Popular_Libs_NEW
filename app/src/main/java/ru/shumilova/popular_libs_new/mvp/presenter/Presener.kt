package ru.shumilova.popular_libs_new.mvp.presenter

import ru.shumilova.popular_libs_new.mvp.model.ClickButtonType
import ru.shumilova.popular_libs_new.mvp.model.Model
import ru.shumilova.popular_libs_new.mvp.view.MainView

class Presenter(private val view: MainView) {
    private val model: Model = Model()
    fun counterClick(id: ClickButtonType) {
        val result = when (id) {
            ClickButtonType.BUTTON_ONE -> getCount(0)
            ClickButtonType.BUTTON_TWO -> getCount(1)
            ClickButtonType.BUTTON_THREE -> getCount(2)
        }
        view.setButtonText(id, result)
    }
    
    private fun getCount(index: Int): String {
        return model.next(index).toString()
    }
}