package deans.cameron.ticks_n_tokens_reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ReviewListAdapter extends ArrayAdapter<AddReviewDetailsData> {

/*
 * Created by Cameron M Deans on 04/04/2023
 */
 private static final String TAG = "ChildListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a view
     */
    static class ViewHolder {
        TextView tickCount;
        TextView tokenCount;
        TextView reviewMessage;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public ReviewListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<AddReviewDetailsData> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the add details information
        int tickCount = getItem(position).getTickCount();
        int tokenCount = getItem(position).getTokenCount();
        String reviewMessage = getItem(position).getReviewMessage();

        // Create the add review details object with the information
        AddReviewDetailsData addReviewDetailsData = new AddReviewDetailsData(tickCount, tokenCount, reviewMessage);

        // Create the view result for sowing the animation
        final View result;

        // ViewHolder object
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.tickCount = (TextView) convertView.findViewById(R.id.isTickCount);
            holder.tokenCount = (TextView) convertView.findViewById(R.id.isTokenCount);
            holder.reviewMessage = (TextView) convertView.findViewById(R.id.isReview);
            result = convertView;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        convertView.setTag(holder);

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.tickCount.setText(String.valueOf(tickCount));
        holder.tokenCount.setText(String.valueOf(tokenCount));
        holder.reviewMessage.setText(reviewMessage);

        return convertView;
    }
}