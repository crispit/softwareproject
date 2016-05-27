package com.example.fredrikhansson.komigennuraa;

/**
 * Created by Mikael on 2016-04-20.
 */

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class ListRowAdapter extends ArrayAdapter<ErrorReport> {

    private final Activity activity;
    private final List<ErrorReport> errorReports;
    private ErrorReport er;
    private final int row;

    public ListRowAdapter(Activity act, List<ErrorReport> arrayList) {
        super(act, R.layout.row, arrayList);
        this.activity = act;
        this.row = R.layout.row;
        this.errorReports = arrayList;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((errorReports == null) || ((position + 1) > errorReports.size()))
            return view;

        er = errorReports.get(position);

        holder.errorSymptom = (TextView) view.findViewById(R.id.errorsymptom);
        holder.errorGrade = (TextView) view.findViewById(R.id.errorgrade);
        holder.errorComment = (TextView) view.findViewById(R.id.errorcomment);
        holder.errorDate = (TextView) view.findViewById(R.id.errordate);

        if (holder.errorSymptom != null && null != er.getSymptom()
                && er.getSymptom().trim().length() > 0) {
            holder.errorSymptom.setText(Html.fromHtml(er.getSymptom()));
        }
        if (holder.errorGrade != null //&& null != er.getGrade()
                //&& er.getGrade().trim().length() > 0
                ) {
            holder.errorGrade.setText(TextUtils.concat(activity.getString(R.string.Grade2), " ", Integer.toString(er.getGrade())));
        }
        if (holder.errorComment != null && null != er.getComment()
                && er.getComment().trim().length() > 0) {
            holder.errorComment.setText(Html.fromHtml(er.getComment()));
        }
        if (holder.errorDate != null && null != er.getPubdate()
                && er.getPubdate().trim().length() > 0) {
            holder.errorDate.setText(Html.fromHtml(er.getPubdate()));
        }

        //here set your color as per position
        if (er.getStatus().equals("Okommenterad")) {
            view.setBackgroundResource(R.drawable.list_bg_uncompleted);
        } else if (er.getStatus().equals("Kommenterad")) {
            view.setBackgroundResource(R.drawable.list_bg_completed);
        } else if (er.getStatus().equals("Löst")) {
            view.setBackgroundResource(R.drawable.list_bg_fixed);
        }

        return view;
    }

    public class ViewHolder {

        public TextView errorSymptom, errorGrade, errorComment, errorDate;

    }

}
