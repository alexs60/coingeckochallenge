package com.alessandrofarandagancio.geckowrapper.ui.fitness.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.alessandrofarandagancio.geckowrapper.databinding.FragmentListBinding
import com.alessandrofarandagancio.geckowrapper.model.UICoin
import com.alessandrofarandagancio.geckowrapper.ui.coin.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val coinViewModel: CoinViewModel by activityViewModels()

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var coinItemAdapter = CoinItemAdapter { coin -> adapterOnClick(coin) }
        binding.recyclerView.adapter = coinItemAdapter

        coinViewModel.coinListResponse.observe(viewLifecycleOwner, Observer {
            coinItemAdapter.submitList(it)
        })

        return root
    }

    private fun adapterOnClick(coin: UICoin) {
        //coinViewModel.goToDetails(this, R.id.action_ListFragment_to_DetailsFragment, business);
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}