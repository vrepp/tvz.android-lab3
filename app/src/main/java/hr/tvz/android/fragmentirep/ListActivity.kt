package hr.tvz.android.fragmentirep

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: BeersAdapter
    private var beers = ArrayList<Beer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        registerReveivers()

        beers = ArrayList(Beers.getBeers())

        setupRecyclerView()
    }

    private fun registerReveivers() {
        registerReceiver(BatteryLowReceiver(), IntentFilter("android.intent.action.BATTERY_LOW"))
    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        adapter = BeersAdapter(beers)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}
