package com.pedroalvarez.ejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pedroalvarez.ejercicio.adapter.TabsFragmentAdapter
import com.pedroalvarez.ejercicio.fragment.FavoritesFragment
import com.pedroalvarez.ejercicio.fragment.NewsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Tabs
        val adapter = TabsFragmentAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        adapter.addItem(NewsFragment(), getString(R.string.tab_text_1))
        adapter.addItem(FavoritesFragment(), getString(R.string.tab_text_2))

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
        showToolbar(getResources().getString(R.string.app_name), false)
    }
    private fun showToolbar(tittle: String?, upButton: Boolean) {
        val toolbar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(tittle)
        supportActionBar!!.setDisplayHomeAsUpEnabled(upButton)
    }
}