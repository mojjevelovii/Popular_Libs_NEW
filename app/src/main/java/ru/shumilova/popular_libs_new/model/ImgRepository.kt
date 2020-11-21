package ru.shumilova.popular_libs_new.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.rxjava3.core.Single
import ru.shumilova.popular_libs_new.App
import java.io.File
import java.io.FileOutputStream

class ImgRepository {
    fun getImage(): File? {
        val directory = getContextCache()
        val file = File(directory, "img.jpg")
        return if (file.exists()) file else null
    }

    fun saveToPng(file: File): Single<File> = Single.fromCallable { convertToPng(file) }

    private fun convertToPng(file: File): File {
        var fileOutputStream: FileOutputStream? = null
        val directory = getContextCache()
        val convertedFile = File(directory, "newImg.png")
        try {
            val bitmap = BitmapFactory.decodeFile(file.path)
            fileOutputStream = FileOutputStream(convertedFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } finally {
            fileOutputStream?.close()
        }
        return convertedFile
    }

    private fun getContextCache() = App.application?.applicationContext?.cacheDir
}