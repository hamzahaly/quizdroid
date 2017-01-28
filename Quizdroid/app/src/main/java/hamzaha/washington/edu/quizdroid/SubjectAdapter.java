package hamzaha.washington.edu.quizdroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by iguest on 1/27/17.
 */

public class SubjectAdapter extends BaseAdapter {
    private ArrayList<Subject> dataSource;
    private Context context;
    private LayoutInflater inflater;
    public SubjectAdapter(Context context, ArrayList<Subject> subjects) {
        this.context = context;
        dataSource = subjects;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return dataSource.size();
    };

    @Override
    public Subject getItem(int position) {
        return dataSource.get(position);
    };

    public long getItemId(int position) {
        return position;
    };

    public View getView(int position, View convertView, ViewGroup parent) {
        Subject subject = getItem(position);

        View rowView = inflater.inflate(R.layout.list_item_subject, parent, false);
        TextView subjectTitle = (TextView) rowView.findViewById(R.id.subject_title);
        subjectTitle.setText(subject.getSubjectName());
        return rowView;
    };
}
