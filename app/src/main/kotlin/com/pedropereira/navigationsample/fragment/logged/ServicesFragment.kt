package com.pedropereira.navigationsample.fragment.logged


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedropereira.navigationsample.R
import kotlinx.android.synthetic.main.fragment_home.*

class ServicesFragment : Fragment() {

    private val title by lazy(LazyThreadSafetyMode.NONE) { arguments?.getString("title") ?: "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onResume() {
        super.onResume()
        screen_title.text = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("***SERVICE_FRAGMENT***", "onCreate executed")
    }

    override fun onDestroy() {
        Log.i("***SERVICE_FRAGMENT***", "onDestroy executed")
        super.onDestroy()
    }
}
