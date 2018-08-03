package com.pedropereira.navigationsample.fragment.notlogged


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.orhanobut.hawk.Hawk
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.LOGGED_USER_KEY
import com.pedropereira.navigationsample.model.USER_ARG
import com.pedropereira.navigationsample.model.USER_LIST_KEY
import com.pedropereira.navigationsample.model.User

class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!Hawk.contains(USER_LIST_KEY)){
            Hawk.put(USER_LIST_KEY, mutableListOf<User>())
        }
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed(Runnable {
            val user: User? = Hawk.get(LOGGED_USER_KEY, null)

            val bundle = Bundle()
            bundle.putParcelable(USER_ARG, user)

            user?.let {
                findNavController().navigate(R.id.action_splashFragment_to_loggedActivity, bundle)
                activity?.finish()
                return@Runnable
            }
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)

        }, 4000)
    }
}
