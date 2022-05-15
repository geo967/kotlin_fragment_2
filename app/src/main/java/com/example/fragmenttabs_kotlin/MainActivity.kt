package com.example.fragmenttabs_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttabs_kotlin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SendMessage {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainBinding.inflate(layoutInflater)
        val rootLayout=binding.root
        super.onCreate(savedInstanceState)
        setContentView(rootLayout)
        setSupportActionBar(toolbar_id)

        viewPagerAdapter= ViewPagerAdapter(supportFragmentManager)
        binding.viewPagerId.adapter=viewPagerAdapter

        binding.tabs.setupWithViewPager(viewPager_id)
    }

    override fun sendData(message: String?) {
        val tag="android:switcher:"+R.id.viewPager_id.toString()+":"+1
        val f=supportFragmentManager.findFragmentByTag(tag) as FragmentTwo?

        f!!.displayReceivedData(message!!)
        val currentItem=getItem(+1)
        viewPager_id.currentItem=currentItem+1
    }
    private fun getItem(i:Int)=viewPager_id.currentItem+i
}