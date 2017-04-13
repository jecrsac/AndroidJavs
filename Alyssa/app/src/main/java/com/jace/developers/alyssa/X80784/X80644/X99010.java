package com.jace.developers.alyssa.X80784.X80644;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class X99010 extends BaseAdapter {
    private Context mContext;
    Vector<ImageView> mySDCardImages;
    Integer[] mThumbIds;


    public X99010(Context c, String rootPath) {
        mContext = c;
        mySDCardImages = new Vector<>();
        List<Integer> drawablesId = new ArrayList<>();
        File sdDir = new File(rootPath);
        File[] sdDirFiles = sdDir.listFiles();

        if (sdDirFiles != null) {
            for(File singleFile : sdDirFiles) {
                ImageView myImageView = new ImageView(mContext);
                myImageView.setImageDrawable(Drawable.createFromPath(singleFile.getAbsolutePath()));
                drawablesId.add(myImageView.getId());
                mySDCardImages.add(myImageView);
            }
        }

        mThumbIds = drawablesId.toArray(new Integer[drawablesId.size()]);
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;


        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        imageView.setImageDrawable(mySDCardImages.get(position).getDrawable());
        return imageView;
    }
}
