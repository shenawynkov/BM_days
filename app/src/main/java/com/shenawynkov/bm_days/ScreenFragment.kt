package com.shenawynkov.bm_days

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.Coil
import coil.load
import com.bumptech.glide.Glide

class ScreenFragment : Fragment(R.layout.fragment_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)


        imageView.load("https://storage.googleapis.com/gweb-uniblog-publish-prod/original_images/tenor_1.gif")


    }

    fun init(view: View) {
        val name = arguments?.getString("name") ?: ""

        val tvName = view.findViewById<TextView>(R.id.tv_name).apply {
            text = name
        }
        val btnSubmit = view.findViewById<Button>(R.id.btn_submit)
        val edtName = view.findViewById<EditText>(R.id.edt_name)

        btnSubmit.setOnClickListener {
            tvName.text = edtName.text
            (requireActivity() as MainActivity).switchFragments()

        }

    }

    override fun onPause() {
        super.onPause()
    }
}