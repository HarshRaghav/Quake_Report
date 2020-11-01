package android.example.myquake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class custom_adapter extends ArrayAdapter<Earthquake> {
    public custom_adapter(Context context, int resource,List<Earthquake> objects) {
        super(context, 0, objects);
    }

    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Earthquake quake = getItem(position);

        double magni=quake.getMag();
        DecimalFormat df=new DecimalFormat("0.00");
        String magni2=df.format(magni);
        TextView textView = (TextView)listItemView.findViewById(R.id.magnitude);
        textView.setText(magni2);


        String A="Near the";
        String B=quake.getPlace();
        if(B.contains("of")){
            String[] str=quake.getPlace().split("of");
            A=str[0]+" of";
            B=str[1];
        }
        TextView textView1a= (TextView)listItemView.findViewById(R.id.location_offset);
        textView1a.setText(A);
        TextView textView1b= (TextView)listItemView.findViewById(R.id.location);
        textView1b.setText(B);

        long d=quake.getDate();
        Date date=new Date(d);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM DD,YYYY");
        String dateDisplay=simpleDateFormat.format(date);
        TextView textView2 = (TextView)listItemView.findViewById(R.id.date);
        textView2.setText(dateDisplay);
        SimpleDateFormat simpleTimeFormat= new SimpleDateFormat("h:mm:a");
        String timeDisplay=simpleTimeFormat.format(date);
        TextView textView3 = (TextView)listItemView.findViewById(R.id.time);
        textView3.setText(timeDisplay);

        GradientDrawable magnCircle = (GradientDrawable)textView.getBackground();
        int magnitudeColor = getMagnitudeColor(quake.getMag());
        magnCircle.setColor(magnitudeColor);

        return listItemView;

    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
