package ru.shumilova.popular_libs_new.mvp.view

import ru.shumilova.popular_libs_new.mvp.model.ClickButtonType

interface MainView {
    fun setButtonText(index: ClickButtonType, text: String?)
}