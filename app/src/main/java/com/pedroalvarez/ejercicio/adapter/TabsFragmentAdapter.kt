package com.pedroalvarez.ejercicio.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabsFragmentAdapter(fm: FragmentManager, behavior: Int):
    FragmentPagerAdapter(fm, behavior){

    private val listFragment: MutableList<Fragment> = ArrayList()
    private val tittleList: MutableList<String> = ArrayList()

    fun addItem(fragment: Fragment, tittle: String){
        listFragment.add(fragment)
        tittleList.add(tittle)
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tittleList[position]
    }
}