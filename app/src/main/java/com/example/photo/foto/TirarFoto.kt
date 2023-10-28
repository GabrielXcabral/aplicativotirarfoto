package com.example.photo.foto

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.MediaStore

class TirarFoto(private val context: Context) {

    fun chamarcamera(){
        val fotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (fotoIntent.resolveActivity(context.packageManager) != null) {
            (context as Activity).startActivityForResult(fotoIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }

}
