package com.github.jorgecastilloprz.easymvp.ui.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jorgecastilloprz.easymvp.R;
import com.github.jorgecastilloprz.easymvp.mvp.model.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jorge on 2/02/15.
 */
public class GameStaggeredAdapter extends RecyclerView.Adapter<GameStaggeredAdapter.ViewHolder> implements View.OnClickListener {

    private List<Game> gameCollection;
    private OnItemClickListener onItemClickListener;

    private static final int VIEWTYPE_LONG = 1;
    private static final int VIEWTYPE_SHORT = 2;

    /**
     * Injectable constructor allows adapter injection
     */
    @Inject public GameStaggeredAdapter() {
        gameCollection = new ArrayList<>();
    }

    /**
     * Used to set the game collection after adapter injection
     * @param collectionToSet
     */
    public void setGameCollection(List<Game> collectionToSet) {
        this.gameCollection = collectionToSet;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        Random typeRandom = new Random();
        if (typeRandom.nextInt(3) % 3 == 0) {
            return VIEWTYPE_SHORT;
        } else {
            return VIEWTYPE_LONG;
        }
    }

    @Override
    public GameStaggeredAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (VIEWTYPE_LONG == viewType) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_grid_item_long, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_grid_item, parent, false);
        }
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(GameStaggeredAdapter.ViewHolder holder, int position) {
        Game gameItem = gameCollection.get(position);
        holder.gameImage.setImageBitmap(null);
        holder.gameItemName.setText(gameItem.getName());
        Picasso.with(holder.gameImage.getContext()).load(gameItem.getImage()).into(holder.gameImage);
        holder.itemView.setTag(gameItem);
    }

    @Override
    public int getItemCount() {
        return gameCollection.size();
    }

    @Override
    public void onClick(final View v) {
        // Give some time to the ripple to finish the effect
        if (onItemClickListener != null) {
            new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    onItemClickListener.onItemClick(v, (Game) v.getTag());
                }
            }, 200);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;

        @InjectView(R.id.gameItemImage)
        ImageView gameImage;
        @InjectView(R.id.gameItemName)
        TextView gameItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;

            ButterKnife.inject(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Game game);
    }
}
