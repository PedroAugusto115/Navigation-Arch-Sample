package com.pedropereira.navigationsample.fragment.notlogged


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.USER_ARG
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.fragment_register_personal.*

class RegisterPersonalFragment : Fragment() {

    private lateinit var user: User

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_personal, container, false)
    }

    override fun onResume() {
        super.onResume()

        user = RegisterPersonalFragmentArgs.fromBundle(arguments!!).user

        next_button.setOnClickListener {
            user.name = user_full_name.text.toString()
            user.age = Integer.parseInt(user_age.text.toString())
            user.city = user_city.text.toString()

            val action = RegisterPersonalFragmentDirections
                    .actionRegisterPersonalFragmentToRegisterPasswordFragment(user)

            it.findNavController().navigate(action)
        }
    }
}
