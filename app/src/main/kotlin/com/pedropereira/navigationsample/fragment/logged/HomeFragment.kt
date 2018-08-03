package com.pedropereira.navigationsample.fragment.logged


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.hawk.Hawk
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.LOGGED_USER_KEY
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var user: User? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()

        //user = intent.extras.getParcelable(USER_ARG)

        //textView.text = getString(R.string.logged_text, user?.name)

        button.setOnClickListener {
            Hawk.delete(LOGGED_USER_KEY)

            activity?.finish()
        }
    }
}
