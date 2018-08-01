package com.pedropereira.navigationsample.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pedropereira.navigationsample.R
import kotlinx.android.synthetic.main.fragment_register_phone.*

class RegisterPhoneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_phone, container, false)
    }

    override fun onResume() {
        super.onResume()

        next_button.setOnClickListener { it.findNavController()
                .navigate(R.id.action_registerPhoneFragment_to_registerPersonalFragment) }
    }
}
