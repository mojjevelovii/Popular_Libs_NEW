package ru.shumilova.popular_libs_new.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.shumilova.popular_libs_new.model.ImgRepository
import ru.shumilova.popular_libs_new.view.IMainView

class Presenter : MvpPresenter<IMainView>() {
    private val imgRepository: ImgRepository = ImgRepository()
    private var disposable: Disposable? = null
    fun startConvert() {
        val file = imgRepository.getImage()
        file?.let {
            disposable = imgRepository.saveToPng(it)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { file -> viewState.showImage(file) },
                    { error -> viewState.showError(error) }
                )
        } ?: viewState.showError(Throwable("File not found!"))

    }

    fun cancelConvertation() {
        disposable?.dispose()
    }

    override fun onDestroy() {
        disposable?.dispose()
    }
}