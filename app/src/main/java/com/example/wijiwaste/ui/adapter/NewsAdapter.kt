import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wijiwaste.R
import com.example.wijiwaste.data.NewsItem
import com.example.wijiwaste.data.response.PostsItem

class NewsAdapter(private val postsList: List<PostsItem>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsImage: ImageView = view.findViewById(R.id.newsImage)
        val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        val newsDescription: TextView = view.findViewById(R.id.newsDescription)
        val newsDate: TextView = view.findViewById(R.id.newsDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val postsItem = postsList[position]
        holder.newsTitle.text = postsItem.title
        holder.newsDescription.text = postsItem.headline // Tampilkan headline sebagai deskripsi
        holder.newsDate.text = postsItem.pusblisedAt // Gunakan tanggal yang tepat
        Glide.with(holder.itemView.context).load(postsItem.image).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}
