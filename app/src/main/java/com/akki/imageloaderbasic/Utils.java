package com.akki.imageloaderbasic;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.OutputStream;

public class Utils {
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
                int count=is.read(bytes, 0, buffer_size);
                if(count==-1)
                    break;
                os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }

    public static void setImgGrayedOut(ImageView view, Boolean doGrayedOut) {
        // if not grayed
        if(doGrayedOut) {
            view.setColorFilter(Color.argb(150,200,200,200));
            //PorterDuffColorFilter greyFilter = new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            //view.setColorFilter(greyFilter);
        } else {
            view.clearColorFilter();
            view.setTag("");
        }
    }
}
