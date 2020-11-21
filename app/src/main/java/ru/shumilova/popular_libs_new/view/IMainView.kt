package ru.shumilova.popular_libs_new.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import java.io.File

@AddToEndSingle
interface IMainView : MvpView {
    fun showImage(file: File)
    fun showError(exception: Throwable)
}