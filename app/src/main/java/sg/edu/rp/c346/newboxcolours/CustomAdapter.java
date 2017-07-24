package sg.edu.rp.c346.newboxcolours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15039523 on 24/7/2017.
 */

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    //Step 3a
    //Modify your data class name <Em>
    ArrayList<ColourRow> boxlist;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ColourRow> objects) { //Only change the third argument
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        boxlist = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Standard code don't need to modify.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

// step 3 :code ourselves : Obtain the UI Elements and assign to Variables.
        TextView tvColour =(TextView) rowView.findViewById(R.id.textViewColour);

        ImageView tvBox1 = (ImageView) rowView.findViewById(R.id.imageViewBox1);
        ImageView tvBox2 = (ImageView) rowView.findViewById(R.id.imageViewBox2);


        ColourRow currentItem = boxlist.get(position);//standard code
        tvColour.setText(currentItem.getColour1());
        tvColour.setText((currentItem.getColour2()));


        if(currentItem.getColour1().equals("blue")){
            tvBox1.setImageResource(R.drawable.blue_box);
        } else if (currentItem.getColour1().equals("orange")){
            tvBox1.setImageResource(R.drawable.orange_box);

        }else{
            tvBox1.setImageResource((R.drawable.brown_box));
        }

        if(currentItem.getColour2().equals("blue")){
            tvBox2.setImageResource(R.drawable.blue_box);
        } else if (currentItem.getColour2().equals("orange")){
            tvBox2.setImageResource(R.drawable.orange_box);

        }else{
            tvBox2.setImageResource((R.drawable.brown_box));
        }

        // Obtain the to-do item based on the "position"






//return the View corresponding to the data at the specified partition
        return rowView;
    }
}

