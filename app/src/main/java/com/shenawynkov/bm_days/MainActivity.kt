package com.shenawynkov.bm_days

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    var fragment1:Fragment = ScreenFragment().apply {
        val bundle = Bundle()

        this.arguments = bundle
    }
    var fragment2:Fragment = RedFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState==null)
        {

        displayFragments()

        }

    }

    fun switchFragments()
    {
       val temp= fragment1
        fragment1= fragment2
        fragment2 = temp
        displayFragments()
    }

    private fun displayFragments()
    {
        supportFragmentManager.beginTransaction().remove(fragment1).remove(fragment2).commitNow()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment1 )
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container2, fragment2)
            .commit()

    }

}
