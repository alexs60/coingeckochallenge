package com.alessandrofarandagancio.geckowrapper.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.alessandrofarandagancio.geckowrapper.R
import com.alessandrofarandagancio.geckowrapper.databinding.ActivityMainBinding
import com.alessandrofarandagancio.geckowrapper.ui.coin.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val coinViewModel: CoinViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavController()

        binding.loading.visibility = View.VISIBLE

        coinViewModel.coinListResponse.observe(this) {
            binding.loading.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        coinViewModel.refreshCoins()
    }

    private fun setupNavController() {
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

}