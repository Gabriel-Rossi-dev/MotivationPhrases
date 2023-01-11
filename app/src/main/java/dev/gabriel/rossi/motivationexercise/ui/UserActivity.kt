package dev.gabriel.rossi.motivationexercise.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.gabriel.rossi.motivationexercise.infra.MotivationConstants
import dev.gabriel.rossi.motivationexercise.R
import dev.gabriel.rossi.motivationexercise.infra.SecurityPreferences
import dev.gabriel.rossi.motivationexercise.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveName.setOnClickListener(this)

        supportActionBar?.hide()
        verifyUserName()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save_name) {
            handleSave()

        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun handleSave() {
        val name = binding.editTextYourName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }


}