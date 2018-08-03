package com.pedropereira.navigationsample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.orhanobut.hawk.Hawk
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.LOGGED_USER_KEY
import com.pedropereira.navigationsample.model.USER_ARG
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.activity_logged.*

class LoggedActivity : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)
    }

    override fun onResume() {
        super.onResume()

        user = intent.extras.getParcelable(USER_ARG)

        textView.text = getString(R.string.logged_text, user?.name)

        button.setOnClickListener {
            Hawk.delete(LOGGED_USER_KEY)

            this.finish()
        }
    }
}
