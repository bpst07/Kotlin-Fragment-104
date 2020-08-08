package com.arrow.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var fragmentOne: FragmentOne = FragmentOne()
    private var fragmentTwo: FragmentTwo = FragmentTwo()

    private val fragmentOneTag = "Fragment One"
    private val fragmentTwoTag = "Fragment Two"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add "FragmentOne" to container (Main Activity)
        // provide tag name to handle configuration changes
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, fragmentOne, fragmentOneTag)
                    .commit()
        }

        // remove fragments button on-click listener
        buttonRemoveFragment.setOnClickListener {

            // Below code will not be able to handle configuration changes
            /*// remove fragment two if it is current fragment
            if (fragmentTwo.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .remove(fragmentTwo)
                        .commit()
            }

            // remove fragment one if it is current fragment
            if (fragmentOne.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .remove(fragmentOne)
                        .commit()
            }*/

            // this code handles configuration changes - Option 1 (findFragmentByTag) method
            /*val fragment1: FragmentOne? = supportFragmentManager
                    .findFragmentByTag(fragmentOneTag) as FragmentOne
            val fragment2: FragmentTwo? = supportFragmentManager
                    .findFragmentByTag(fragmentTwoTag) as FragmentTwo

            // remove fragment two if it is current fragment
            if (fragment1 != null && fragment1.isAdded) {
                if (fragment1.isAdded) {
                    supportFragmentManager
                            .beginTransaction()
                            .remove(fragment1)
                            .commit()
                }
            }

            // remove fragment one if it is current fragment
            if (fragment2 != null && fragment2.isAdded) {
                if (fragment2.isAdded) {
                    supportFragmentManager
                            .beginTransaction()
                            .remove(fragment2)
                            .commit()
                }
            }*/

            // this code handles configuration changes - Option 2 (findFragmentById) method
            val fragment: Fragment = supportFragmentManager
                    .findFragmentById(R.id.container) as Fragment

            if (fragment.isAdded) {
                if (fragment.isAdded) {
                    supportFragmentManager
                            .beginTransaction()
                            .remove(fragment)
                            .commit()
                }
            }
        }

        // replace fragment button on-click listener
        buttonChangeFragment.setOnClickListener {
            if (!fragmentOne.isAdded && !fragmentTwo.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragmentOne, fragmentOneTag)
                        .addToBackStack(null)
                        .commit()
            } else if (fragmentOne.isAdded && !fragmentTwo.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragmentTwo, fragmentTwoTag)
                        .addToBackStack(null)
                        .commit()
            } else if (!fragmentOne.isAdded && fragmentTwo.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragmentOne, fragmentOneTag)
                        .addToBackStack(null)
                        .commit()
            }
        }
    }
}