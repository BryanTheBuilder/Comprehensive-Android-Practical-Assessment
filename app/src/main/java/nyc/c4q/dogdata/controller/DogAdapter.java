package nyc.c4q.dogdata.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import nyc.c4q.dogdata.PhotoActivity;
import nyc.c4q.dogdata.R;

/**
 * Created by c4q on 2/25/18.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> implements
    OnClickListener {

  private List<String> dogResponseList = new ArrayList<>();
  private Context context;

  public DogAdapter(List<String> dogResponseList) {
    this.dogResponseList = dogResponseList;
  }

  @Override
  public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    context = parent.getContext();
    View view = LayoutInflater.from(context).inflate(R.layout.dog_item, parent, false);
    return new DogViewHolder(view);
  }

  @Override
  public void onBindViewHolder(DogViewHolder holder, int position) {
    String url = dogResponseList.get(position);
    Picasso.with(context).load(url).into(holder.dogImage);
    holder.itemView.setTag(url);
    holder.itemView.setOnClickListener(this);
  }

  @Override
  public int getItemCount() {
    return (dogResponseList == null) ? 0 : dogResponseList.size();
  }

  @Override
  public void onClick(View v) {
    String url = (String) v.getTag();
    Intent intent = new Intent(context, PhotoActivity.class);
    intent.putExtra("url", url);
    context.startActivity(intent);
  }

  public class DogViewHolder extends ViewHolder {

    public ImageView dogImage;

    public DogViewHolder(View itemView) {
      super(itemView);
      dogImage = itemView.findViewById(R.id.dogitem_image);
    }
  }
}
