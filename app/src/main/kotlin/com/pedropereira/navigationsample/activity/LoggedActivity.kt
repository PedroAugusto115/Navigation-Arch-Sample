package com.pedropereira.navigationsample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pedropereira.navigationsample.R
import kotlinx.android.synthetic.main.activity_logged.*

class LoggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)
    }

    override fun onResume() {
        super.onResume()

        button.setOnClickListener { this.finish() }
    }
}
