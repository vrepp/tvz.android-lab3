package hr.tvz.android.fragmentirep

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Beer(
    val name: String,
    val brewer: String,
    val alcohol: String,
    val imageUrl: String,
    val url: String
) : Parcelable