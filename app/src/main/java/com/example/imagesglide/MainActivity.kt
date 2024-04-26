package com.example.imagesglide

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.imagesglide.databinding.ActivityMainBinding
import loadFromUrl

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //viewbinding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        Log.d("LOG", "onCREATE"  )
        viewBinding.button.setOnClickListener{
            viewBinding.progressBar.visibility = View.VISIBLE
            val listener = object: RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    viewBinding.progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "Error loading image", Toast.LENGTH_SHORT).show()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: com.bumptech.glide.load.DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    viewBinding.progressBar.visibility = View.GONE
                    return false
                }
            }
            viewBinding.imageView.loadFromUrl("http://picsum.photos/600", listener)
        }

        viewBinding.button2.setOnClickListener(){
            val intent = Intent(this, DetailsActivity::class.java).apply {
                //add parameters
                putExtra("name", "John")
            }
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("LOG", "onSTART"  )
    }

    override fun onResume() {
        super.onResume()
        Log.d("LOG", "onRESUME"  )
    }

    override fun onPause() {
        super.onPause()
        Log.d("LOG", "onPAUSE"  )
    }
    override  fun onStop() {
        super.onStop()
        Log.d("LOG", "onSTOP"  )
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("LOG", "onDESTROY"  )
    }
}