package com.orbitalsonic.badgeonactionitem

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var tvItemBadge:TextView
    private var mBadgeCount = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onclickMethod()
    }

    private fun onclickMethod(){
        val btnSubtractCount:Button = findViewById(R.id.btn_subtract_count)
        btnSubtractCount.setOnClickListener {
            mBadgeCount -= 1
            setupBadge(mBadgeCount)
        }

        val btnAddCount:Button = findViewById(R.id.btn_add_count)
        btnAddCount.setOnClickListener {
            mBadgeCount += 1
            setupBadge(mBadgeCount)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)


        val menuItem = menu.findItem(R.id.nav_water)

        val actionView: View = menuItem.actionView
        tvItemBadge = actionView.findViewById(R.id.item_badge_text)

        setupBadge(mBadgeCount)
        actionView.setOnClickListener { onOptionsItemSelected(menuItem) }


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.nav_setting -> {
                showMessage("Setting")
             true
            }
            R.id.nav_water -> {
                showMessage("Water")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    private fun setupBadge(mCount:Int) {
        tvItemBadge.text = "$mCount"
    }
}