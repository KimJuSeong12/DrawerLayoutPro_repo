package com.example.drawerlayoutpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.drawerlayoutpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 액션바 대신에 툴바로 대체
        setSupportActionBar(binding.toolbar)
        // 2. ActionBarDrawerToggle 버튼 적용
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.drawer_open,R.string.drawer_close)
        // 3. 업버튼 활성화
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 4. 토글 sync
        toggle.syncState()
    }
    // 메뉴 토글버튼을 눌렀을 때 네비게이션바를 보여주는 역할
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}