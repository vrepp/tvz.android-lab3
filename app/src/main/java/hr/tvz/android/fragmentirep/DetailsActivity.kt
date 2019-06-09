package hr.tvz.android.fragmentirep

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*

class DetailsActivity : AppCompatActivity() {

    private var item: Beer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)

        item = intent.getParcelableExtra<Beer>(BeersAdapter.ViewHolder.BEER_KEY).also { bindBeer(it) }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_share) {
            actionShare()
        } else if (item?.itemId == R.id.action_open_url) {
            actionOpenUrl()
        }

        return true
    }

    private fun actionShare() {
        item?.let {
            val intent = Intent(it.name)
            sendBroadcast(intent)
        }
    }

    private fun actionOpenUrl() {
        item?.let {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(it.url)
            startActivity(intent)
        }
    }

    private fun bindBeer(beer: Beer) {
        beer_name.text = beer.name
        beer_brewer.text = beer.brewer
        beer_alcohol.text = beer.alcohol
        Picasso.get()
            .load(beer.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(beer_image)

        beer_image.setOnClickListener{ v: View? ->
            v?.let {
                val context = it.context
                val showImageIntent = Intent(context, ImageActivity::class.java)
                showImageIntent.putExtra(BeersAdapter.ViewHolder.BEER_KEY, beer)
                context.startActivity(showImageIntent)
            }
        }
    }
}
