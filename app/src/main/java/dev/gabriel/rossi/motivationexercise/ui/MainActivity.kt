package dev.gabriel.rossi.motivationexercise.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import dev.gabriel.rossi.motivationexercise.infra.MotivationConstants
import dev.gabriel.rossi.motivationexercise.R
import dev.gabriel.rossi.motivationexercise.data.Mock
import dev.gabriel.rossi.motivationexercise.infra.SecurityPreferences
import dev.gabriel.rossi.motivationexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {



    private lateinit var binding: ActivityMainBinding
    private var categoryID = MotivationConstants.FILTER.ALL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()


        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textHelloName.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_new_phrase -> {
                handleNextPhrase()
            }
            in listOf(
                R.id.image_all,
                R.id.image_happy,
                R.id.image_sunny
            ) -> {
                handleFilter(view.id)
            }
            R.id.text_hello_name -> {
                changeUserName()
            }
        }
    }

    private fun handleNextPhrase() {
        binding.textPhrases.text = Mock().getPhrase(categoryID)
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.purple_light_icons))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.purple_light_icons))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.purple_light_icons))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
                categoryID = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
                categoryID = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))
                categoryID = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textHelloName.text = "Olá, $name!"
    }

    private fun changeUserName() {
        startActivity(Intent(this, UserActivity::class.java))
        finish()
        SecurityPreferences(this).clearCache()
    }



}