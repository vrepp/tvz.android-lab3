package hr.tvz.android.fragmentirep

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.content_image.beer_image

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val item = intent.getParcelableExtra<Beer>(BeersAdapter.ViewHolder.BEER_KEY)
        Picasso.get()
            .load(item.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(beer_image)
    }

}
