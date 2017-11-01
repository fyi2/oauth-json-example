package com.example.tony.testshell.Adapters

/**
 * Created by Tony on 11/1/2017.
 */
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.tony.testshell.Fragments.TestOneFragment
import com.example.tony.testshell.Fragments.TestTwoFragment


class TabbedMenuAdapter(fm:FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): android.support.v4.app.Fragment {
        when(position) {
            0 -> return TestOneFragment()
            1 -> return TestTwoFragment()
        }
        return null!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0 -> return "POP-UP"
            1 -> return "RECYCLER"
        }
        return null!!
    }

}
