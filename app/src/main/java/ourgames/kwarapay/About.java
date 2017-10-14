package ourgames.kwarapay;

/**
 * Created by User on 7/24/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.graphics.drawable.Drawable;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;


public class About extends Activity implements OnClickListener{

    //---the images to display---
    Integer[] imageIDs = {
            R.drawable.a, R.drawable.a1, R.drawable.b1, R.drawable.c1,
            R.drawable.b,R.drawable.c, R.drawable.d, R.drawable.e,R.drawable.f,
            R.drawable.g,R.drawable.h, R.drawable.i,R.drawable.j,R.drawable.k,
            R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p,
            R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u,R.drawable.v,
            R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_choice);


        //for buttons
        View aboutKwaraPay = findViewById(R.id.abt_kwp);
        aboutKwaraPay.setOnClickListener(this);
        View contactDeveloper = findViewById(R.id.cont_dev);
        contactDeveloper.setOnClickListener(this);

        //for gallery
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id)
            {
                Toast.makeText(getBaseContext(),
                        "pic" + (position + 1) + "selected",
                        Toast.LENGTH_SHORT).show();

                //---display the images selected---
                ImageView imageView =
                        (ImageView) findViewById(R.id.img_view);
                imageView.setImageResource(imageIDs[position]);

            }

        });

    }
    //for base adapter
    public class ImageAdapter extends BaseAdapter
    {
        Context context;
        int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
//---setting the style---
            TypedArray a = obtainStyledAttributes(
                    R.styleable.Gallery1);
            itemBackground = a.getResourceId(
                    R.styleable.Gallery1_android_galleryItemBackground,
                    0);
            a.recycle();
        }
        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }
        //---returns the item---
        public Object getItem(int position) {
            return position;
        }
        //---returns the ID of an item---
        public long getItemId(int position) {
            return position;
        }
        //---returns an ImageView view---
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setImageResource(imageIDs[position]);
                imageView.setScaleType(
                        ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(
                        new Gallery.LayoutParams(350, 320));
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.abt_kwp:
                Intent y = new Intent(this, AboutKwp.class);
                startActivity(y);
                break;
            case R.id.cont_dev:
                Intent z = new Intent(this, AboutDev.class);
                startActivity(z);
                break;
        }
    }
}