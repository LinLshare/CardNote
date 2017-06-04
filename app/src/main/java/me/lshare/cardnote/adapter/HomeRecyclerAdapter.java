package me.lshare.cardnote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.lshare.cardnote.R;
import me.lshare.cardnote.data.ShortCard;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.VH> {

  private List<ShortCard> shortCardList;
  private Context context;

  public HomeRecyclerAdapter(Context context) {
    this.context = context;
    shortCardList = new ArrayList<>();
    shortCardList.add(new ShortCard("马齿苋",
                                    "http://f.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=061352f18f44ebf86d716339e1c2b017/8694a4c27d1ed21b63874517a56eddc450da3ff1.jpg",
                                    "8分钟前"));
    shortCardList.add(new ShortCard("meinv",
                                    "http://img.7139.com/file/201207/04/299ac0ab2be96c216c6bd5255945cb6c.jpg",
                                    "8分钟前"));
    shortCardList.add(new ShortCard("meinv",
                                    "http://img.7139.com/file/201207/04/299ac0ab2be96c216c6bd5255945cb6c.jpg",
                                    "8分钟前"));
    shortCardList.add(new ShortCard("马齿苋",
                                    "http://f.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=061352f18f44ebf86d716339e1c2b017/8694a4c27d1ed21b63874517a56eddc450da3ff1.jpg",
                                    "8分钟前"));
    shortCardList.add(new ShortCard("马齿苋",
                                    "http://f.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=061352f18f44ebf86d716339e1c2b017/8694a4c27d1ed21b63874517a56eddc450da3ff1.jpg",
                                    "8分钟前"));
    shortCardList.add(new ShortCard("马齿苋",
                                    "http://f.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=061352f18f44ebf86d716339e1c2b017/8694a4c27d1ed21b63874517a56eddc450da3ff1.jpg",
                                    "8分钟前"));

  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView =
        LayoutInflater.from(context).inflate(R.layout.layout_item_home_page, parent, false);
    return new VH(itemView);
  }

  @Override
  public void onBindViewHolder(VH holder, int position) {
    ShortCard shortCard = shortCardList.get(position);
    holder.timeTextView.setText(shortCard.getTime());
    holder.titleTextView.setText(shortCard.getTitle());
    Picasso.with(context).load(shortCard.getCoverImageUrl()).into(holder.coverImageView);
  }

  @Override
  public int getItemCount() {
    return shortCardList.size();
  }

  static class VH extends RecyclerView.ViewHolder {
    TextView titleTextView;
    ImageView coverImageView;
    TextView timeTextView;

    VH(View itemView) {
      super(itemView);
      timeTextView = (TextView) itemView.findViewById(R.id.time_text_view);
      titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
      coverImageView = (ImageView) itemView.findViewById(R.id.cover_image_view);
    }
  }
}
