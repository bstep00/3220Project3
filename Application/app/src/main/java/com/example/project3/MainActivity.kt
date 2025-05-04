package com.example.project3   // use the package Android Studio created

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.project3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageMap = mapOf(
            binding.btnRed   to R.drawable.pic_red,
            binding.btnGreen to R.drawable.pic_green,
            binding.btnBlue  to R.drawable.pic_blue
        )

        imageMap.forEach { (button, resId) ->
            button.setOnClickListener { crossFadeTo(resId) }
        }
    }

    private fun crossFadeTo(newResId: Int) {
        val current = binding.mainImage.drawable
        val next    = ResourcesCompat.getDrawable(resources, newResId, null)!!
        val fade    = TransitionDrawable(arrayOf(current, next))
        binding.mainImage.setImageDrawable(fade)
        fade.startTransition(300)   // 0.3‑second cross‑fade
    }
}
