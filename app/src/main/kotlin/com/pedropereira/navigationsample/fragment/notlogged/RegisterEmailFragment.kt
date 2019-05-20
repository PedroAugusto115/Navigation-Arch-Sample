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
import kotlinx.android.synthetic.main.fragment_register_email.*

class RegisterEmailFragment : Fragment() {

    private lateinit var user: User

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_email, container, false)
    }

    override fun onResume() {
        super.onResume()

        user = RegisterEmailFragmentArgs.fromBundle(arguments).user

        next_button.setOnClickListener {
            user.email = user_email.text.toString()

            val action = RegisterEmailFragmentDirections
                    .actionRegisterEmailFragmentToRegisterPersonalFragment(user)
            it.findNavController().navigate(action)
        }


        use_phone.setOnClickListener {
            val action = RegisterEmailFragmentDirections
                    .actionRegisterEmailFragmentToRegisterPhoneFragment(user)

            it.findNavController().navigate(action)
        }
    }
}
