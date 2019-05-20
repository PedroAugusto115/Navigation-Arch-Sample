package com.pedropereira.navigationsample.fragment.logged


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.hawk.Hawk
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.activity.MainActivity
import com.pedropereira.navigationsample.model.LOGGED_USER_KEY
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val title by lazy(LazyThreadSafetyMode.NONE) { arguments?.getString("title") ?: "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()

        screen_title.text = title

        button.setOnClickListener {
            Hawk.delete(LOGGED_USER_KEY)

            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

            activity?.finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("***HOME_FRAGMENT***", "onCreate executed")
    }

    override fun onDestroy() {
        Log.i("***HOME_FRAGMENT***", "onDestroy executed")
        super.onDestroy()
    }
}
