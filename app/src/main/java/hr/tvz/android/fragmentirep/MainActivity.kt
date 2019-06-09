package hr.tvz.android.fragmentirep

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: BeersAdapter
    private var beers = ArrayList<Beer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReveivers()

        beers = getBeers()

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

    private fun getBeers(): ArrayList<Beer> {
        // mock
        return arrayListOf<Beer>(
            Beer(
                "Blue",
                "Labatt Breweries Ontario",
                "5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/94449_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Canadian",
                "Molson'S Brewery Of Canada Limited",
                "5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60483_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Bud Light",
                "Labatt Breweries Ontario",
                "4%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60473_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Busch",
                "LABATT",
                "4.7%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60477_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Laker Ice",
                "The Brick Brewing Co",
                "5.5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60766_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Moosehead",
                "MOOSEHEAD BREWERIES LIMITED",
                "5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/69530_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Carling Ice",
                "MOLSON",
                "5.5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60744_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Grolsch Premium Lager",
                "Grolsche Bierbrouwerij B.V.",
                "5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60674_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Old Milwaukee",
                "Sleeman Brewing & Malting Co",
                "4.9%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60706_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Molson Dry",
                "Molson'S Brewery Of Canada Limited",
                "5.5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60543_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Rolling Rock Pale Lager",
                "Labatt Breweries Ontario",
                "4.5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/90780_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Creemore Lager",
                "CREEMORE SPRINGS BREWERY",
                "5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60495_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Lakeport Pilsener",
                "Lakeport Brewing Corporation",
                "5%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60762_l.png",
                "https://www.thebeerguy.ca"
            ),
            Beer(
                "Brava",
                "BRAVA BREWING COMPANY",
                "4.9%",
                "https://d9n7s0cf8h13p.cloudfront.net/images/products/60741_l.png",
                "https://www.thebeerguy.ca"
            )
        )
    }
}
