package hr.tvz.android.fragmentirep

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.beer_item.view.*

class BeersAdapter(private val beers: ArrayList<Beer>) : RecyclerView.Adapter<BeersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.beer_item, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val beer = beers[p1]
        p0.bindBeer(beer)
    }

    override fun getItemCount(): Int = beers.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view: View = itemView
        private var beer: Beer? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            v?.let {
                val context = it.context
                val showDetailsIntent = Intent(context, DetailsActivity::class.java)
                showDetailsIntent.putExtra(BEER_KEY, beer)
                context.startActivity(showDetailsIntent)
            }
        }

        companion object {
            const val BEER_KEY = "BEER"
        }

        fun bindBeer(beer: Beer) {
            this.beer = beer
            view.beer_name.text = beer.name
            view.beer_alcohol.text = beer.alcohol
            Picasso.get()
                .load(beer.imageUrl)
                .resize(40, 40)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(view.beer_image)
        }
    }
}