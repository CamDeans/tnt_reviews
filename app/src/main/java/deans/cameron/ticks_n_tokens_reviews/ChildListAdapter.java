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

public class ChildListAdapter extends ArrayAdapter<AddDetailsData> {

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
        TextView childName;
        TextView childAge;
        TextView chore1;
        TextView chore2;
        TextView chore3;
        TextView tntNumberSelection;
        TextView award;
        TextView punishment;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public ChildListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<AddDetailsData> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the add details information
        String childName = getItem(position).getChildName();
        int childAge = getItem(position).getChildAge();
        String chore1 = getItem(position).getChore1();
        String chore2 = getItem(position).getChore2();
        String chore3 = getItem(position).getChore3();
        int tntNumberSelection = getItem(position).getTntNumberSelection();
        String award = getItem(position).getAward();
        String punishment = getItem(position).getPunishment();

        // Create the add details object with the information
        AddDetailsData addDetailsData = new AddDetailsData(childName, childAge, chore1, chore2, chore3, tntNumberSelection, award, punishment);

        // Create the view result for sowing the animation
        final View result;

        // ViewHolder object
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.childName = (TextView) convertView.findViewById(R.id.isChildName);
            holder.childAge = (TextView) convertView.findViewById(R.id.isChildAge);
            holder.chore1 = (TextView) convertView.findViewById(R.id.isChore1);
            holder.chore2 = (TextView) convertView.findViewById(R.id.isChore2);
            holder.chore3 = (TextView) convertView.findViewById(R.id.isChore3);
            holder.tntNumberSelection = (TextView) convertView.findViewById(R.id.isTntNumberSelection);
            holder.award = (TextView) convertView.findViewById(R.id.isAward);
            holder.punishment = (TextView) convertView.findViewById(R.id.isPunishment);

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

        holder.childName.setText(childName);
        holder.childAge.setText(String.valueOf(childAge));
        holder.chore1.setText(chore1);
        holder.chore2.setText(chore2);
        holder.chore3.setText(chore3);
        holder.tntNumberSelection.setText(String.valueOf(tntNumberSelection));
        holder.award.setText(award);
        holder.punishment.setText(punishment);

        return convertView;
    }
}