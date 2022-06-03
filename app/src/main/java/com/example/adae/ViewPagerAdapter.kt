package com.example.adae

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.adae.ArenaFragments.*


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0->{
                FirstFragment()
            }
            1->{
                SecFragment()
            }
            2->{
                ThirdFragment()
            }
            3->{
                ForthFragment()
            }
            4->{
                FifthFragment()
            }
            5->{
                SixthFragment()
            }

            else->{
                Fragment()
            }

        }   }
}
