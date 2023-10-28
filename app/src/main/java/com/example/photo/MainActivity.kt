package com.example.photo

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.photo.foto.TirarFoto

class MainActivity : AppCompatActivity() {

    private lateinit var photoImageView : ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photoImageView = findViewById(R.id.photoImageView);
        val tirarfoto = findViewById<Button>(R.id.takePhotoButton);



        tirarfoto.setOnClickListener(){
            val foto = TirarFoto (this)
            foto.chamarcamera();
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TirarFoto.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            photoImageView.setImageBitmap(imageBitmap)
        }
    }
}