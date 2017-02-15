package hamzaha.washington.edu.quizdroid;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by iguest on 1/27/17.
 */

public class TopicAdapter extends BaseAdapter {
    private ArrayList<Topic> dataSource;
    private Context context;
    private LayoutInflater inflater;
    public TopicAdapter(Context context, ArrayList<Topic> topics) {
        this.context = context;
        dataSource = topics;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return dataSource.size();
    };

    @Override
    public Topic getItem(int position) {
        return dataSource.get(position);
    };

    public long getItemId(int position) {
        return position;
    };

    public View getView(int position, View convertView, ViewGroup parent) {
        Topic topic = getItem(position);

        View rowView = inflater.inflate(R.layout.list_item_subject, parent, false);
        TextView topicTitle = (TextView) rowView.findViewById(R.id.subject_title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgIcon);
        topicTitle.setText(topic.getTopicName());
        imageView.setImageResource(topic.getImgLocation());
        return rowView;
    };
}
