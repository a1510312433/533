package rx.dong.com.rxjoke.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.dong.com.rxjoke.R;
import rx.dong.com.rxjoke.model.ContentlistEntity;
import rx.dong.com.rxjoke.util.TimeUtil;

/**
 * Created by JDD on 2016/4/23 0023.
 */
public class JokeAdapter extends RecyclerView.Adapter {

    private List<ContentlistEntity> jokeList;
    Context context;

    public JokeAdapter(Context context, List<ContentlistEntity> jokeList) {
        this.context = context;
        this.jokeList = jokeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_list_item,
                parent, false);
        JokeViewHolder holder = new JokeViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder jokeViewHolder = (JokeViewHolder) holder;
        jokeViewHolder.title.setText("#" + jokeList.get(position).getTitle() + "#");
        jokeViewHolder.time.setText(TimeUtil.getDateBySplit(jokeList.get(position).getCt()));
        /*使html中<标签>得以转化*/
        jokeViewHolder.content.setText(Html.fromHtml(jokeList.get(position).getText().toString()));
//        jokeViewHolder.img;

//        if(position%2==0){
//            jokeViewHolder.img.setBackgroundResource(R.mipmap.a533);
//        }else{
//            jokeViewHolder.img.setBackgroundResource(R.mipmap.ic_launcher);
//        }


        if (position % 2 == 0) {
            Glide.with(context)
                    .load(R.drawable.huaha)
                    .asGif()
                    .centerCrop()
//                    .dontAnimate()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(jokeViewHolder.img);

        } else {
            jokeViewHolder.img.setBackgroundResource(R.mipmap.a533);
        }
        jokeViewHolder.img.setTag(R.id.image_tag, position);


//        jokeViewHolder.img.setTag(R.id.image_tag, position);
//
////        if(Integer.parseInt(jokeViewHolder.img.getTag().toString()) != position){
////            if (position % 2 == 0) {
//                Glide.with(context)
//                        .load(R.drawable.huaha)
//                        .asGif()
//                        .centerCrop()
////                    .dontAnimate()
//                        .placeholder(R.mipmap.a533)
//                        .error(R.mipmap.ic_launcher)
//                        .into(jokeViewHolder.img);
//
////            }else{
////                jokeViewHolder.img.setBackgroundResource(R.mipmap.a533);
////            }
//        jokeViewHolder.img.setTag(R.id.image_tag, position);
//        }

//        else {
//            jokeViewHolder.img.setBackgroundResource(R.mipmap.ic_launcher);
//        }

//        Glide.with(context)
//        .load(R.drawable.sea)
//                .asBitmap()
//                .centerCrop()
//// .dontAnimate()
//                .placeholder(R.mipmap.a533)
//                .error(R.mipmap.ic_launcher)
//// .diskCacheStrategy(DiskCacheStrategy.ALL)
//// .crossFade(100)
//                .transform(new MyTransformation(context))
//                .into(jokeViewHolder.img);
//        jokeViewHolder.img.setTag(R.id.image_tag,position);
    }

    class MyTransformation implements Transformation {

        @Override
        public Resource transform(Resource resource, int outWidth, int outHeight) {
            return null;
        }

        @Override
        public String getId() {
            return null;
        }
    }


    static class JokeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.content)
        TextView content;
        @Bind(R.id.img)
        ImageView img;

        public JokeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
