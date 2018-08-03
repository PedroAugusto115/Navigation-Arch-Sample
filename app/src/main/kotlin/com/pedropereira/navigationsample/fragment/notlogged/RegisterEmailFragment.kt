package com.pedropereira.navigationsample.fragment.notlogged


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.pedropereira.navigationsample.R
import com.pedropereira.navigationsample.model.USER_ARG
import com.pedropereira.navigationsample.model.User
import kotlinx.android.synthetic.main.fragment_register_email.*

class RegisterEmailFragment : Fragment() {

    private var user: User? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_email, container, false)
    }

    override fun onResume() {
        super.onResume()

        user = arguments?.getParcelable(USER_ARG)


        next_button.setOnClickListener {
            user?.email = user_email.text.toString()

            val bundle = Bundle()
            bundle.putParcelable(USER_ARG, user)

            it.findNavController()
                    .navigate(R.id.action_registerEmailFragment_to_registerPersonalFragment, bundle)
        }


        use_phone.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable(USER_ARG, user)

            it.findNavController()
                .navigate(R.id.action_registerEmailFragment_to_registerPhoneFragment, bundle)
        }
    }
}
