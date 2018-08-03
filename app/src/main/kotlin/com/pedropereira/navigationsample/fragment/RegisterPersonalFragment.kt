package com.pedropereira.navigationsample.fragment


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

    private var user: User? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_personal, container, false)
    }

    override fun onResume() {
        super.onResume()

        user = arguments?.getParcelable(USER_ARG)

        next_button.setOnClickListener {
            user?.name = user_full_name.text.toString()
            user?.age = Integer.parseInt(user_age.text.toString())
            user?.city = user_city.text.toString()

            val bundle = Bundle()
            bundle.putParcelable(USER_ARG, user)

            it.findNavController()
                .navigate(R.id.action_registerPersonalFragment_to_registerPasswordFragment, bundle)
        }
    }
}
