package com.pedropereira.navigationsample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.activity_logged.*

class LoggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)
        setupNavigation()
    }

    override fun onSupportNavigateUp() =
            findNavController(R.id.bottom_navigation_fragment).navigateUp()

    private fun setupNavigation() {
        val navController = findNavController(R.id.bottom_navigation_fragment)
        setupActionBarWithNavController(navController)
        bottom_navigation.setupWithNavController(navController)
    }
}
