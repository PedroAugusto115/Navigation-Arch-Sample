package com.pedropereira.navigationsample.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.orhanobut.hawk.Hawk
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.LOGGED_USER_KEY
import com.pedropereira.navigationsample.model.USER_ARG
import com.pedropereira.navigationsample.model.USER_LIST_KEY
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onResume() {
        super.onResume()

        login.setOnClickListener{ validateAndLogin() }

        register.setOnClickListener { redirectRegister(it) }
    }

    private fun redirectRegister(it: View) {
        val user = Hawk.get(LOGGED_USER_KEY, User())

        val bundle = Bundle()
        bundle.putParcelable(USER_ARG, user)

        it.findNavController()
                .navigate(R.id.action_loginFragment_to_registerEmailFragment, bundle)
    }

    private fun validateAndLogin() {
        val login = user_email.text.toString()
        val pass = user_password.text.toString()

        val users = Hawk.get(USER_LIST_KEY, mutableListOf<User>())

        for(user in users){
            if((user.email.equals(login) || user.phone.equals(login))
                    && user.password == pass) {
                Hawk.put(LOGGED_USER_KEY, user)

                val bundle = Bundle()
                bundle.putParcelable(USER_ARG, user)
                findNavController().navigate(R.id.action_loginFragment_to_loggedActivity, bundle)
                return
            }
        }
    }
}
