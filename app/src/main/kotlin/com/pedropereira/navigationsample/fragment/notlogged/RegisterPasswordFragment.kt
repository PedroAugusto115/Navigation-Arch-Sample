package com.pedropereira.navigationsample.fragment.notlogged


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.orhanobut.hawk.Hawk
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.LOGGED_USER_KEY
import com.pedropereira.navigationsample.model.USER_ARG
import com.pedropereira.navigationsample.model.USER_LIST_KEY
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.fragment_register_password.*

class RegisterPasswordFragment : Fragment() {

    private lateinit var user: User

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_password, container, false)
    }

    override fun onResume() {
        super.onResume()

        user = RegisterPasswordFragmentArgs.fromBundle(arguments!!).user

        finish_button.setOnClickListener{
            val pass = password.text.toString()
            val confirmPass = confirm_password.text.toString()

            if(pass == confirmPass){
                user.password = pass

                Hawk.put(LOGGED_USER_KEY, user)

                val userList = Hawk.get(USER_LIST_KEY, mutableListOf<User>())
                userList.add(user)
                Hawk.put(USER_LIST_KEY, userList)

                val action = RegisterPasswordFragmentDirections
                        .actionRegisterPasswordFragmentToLoggedActivity(user)

                it.findNavController().navigate(action)

                activity?.finish()
            }
        }
    }
}
