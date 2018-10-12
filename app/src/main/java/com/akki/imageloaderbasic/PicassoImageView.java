package com.akki.imageloaderbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoImageView extends AppCompatActivity {

    private LinearLayout imgControllerLayout;
    private ImageView previousImgControl, nextImgControl;
    private ImageView imageView;
    private int imgCount;
    View.OnContextClickListener mPreviousImgClicklistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_imageview_layout);

        initViews();

        String imageUrl = "http://www.cameraegg.org/wp-content/uploads/2015/06/canon-powershot-g3-x-sample-images-1.jpg";
        showImage(imageUrl);
    }

    private void initViews() {
        //Initializing the ImageView
        imageView = (ImageView) findViewById(R.id.imageView);

        imgControllerLayout = findViewById(R.id.img_controller_layout);
        previousImgControl = findViewById(R.id.img_show_prevous);
        nextImgControl = findViewById(R.id.img_show_next);

        if(imgCount <= 1) {
            previousImgControl.setClickable(false);
            previousImgControl.setEnabled(false);
            Utils.setImgGrayedOut(previousImgControl, true);
            previousImgControl.setOnClickListener(null);
        } else {
            previousImgControl.setClickable(true);
            previousImgControl.setEnabled(true);
            Utils.setImgGrayedOut(previousImgControl, false);
            //previousImgControl.setOnClickListener(null);
        }

         previousImgControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Show previous image
                //Toast.makeText(PicassoImageView.this, "Show Previous image", Toast.LENGTH_SHORT).show();
                showImage("http://www.cameraegg.org/wp-content/uploads/2015/06/canon-powershot-g3-x-sample-images-1.jpg");
            }
        });

        nextImgControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Show next image
                Toast.makeText(PicassoImageView.this, "Show Next image", Toast.LENGTH_SHORT).show();
                showImage("http://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg");
                imgCount++;
                previousImgControl.setClickable(true);
                previousImgControl.setEnabled(true);
                Utils.setImgGrayedOut(previousImgControl, false);
            }
        });

    }

    private void showImage(String imgUrl) {
        //Loading Image from URL
        /*Picasso.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.progress_animation)  // optional
                .error(R.drawable.error) // optional
                .resize(400,400) // optional
                .into(imageView);*/

        imageView.invalidate();
        Picasso.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error) // optional
                .resize(400,400)
                .into(imageView, new Callback(){
                    @Override
                    public void onSuccess(){
                        imgControllerLayout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(){
                        //TODO
                    }
        });
    }

}
