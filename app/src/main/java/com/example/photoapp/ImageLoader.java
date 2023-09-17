package com.example.photoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoader {

    private Context context;

    public ImageLoader(Context context) {
        this.context = context;
    }

    public void loadImage(String imageUrl, ImageView imageView) {
        ImageLoadTask task = new ImageLoadTask(imageView);
        task.execute(imageUrl);
    }

    private static class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {
        private WeakReference<ImageView> imageViewReference;

        public ImageLoadTask(ImageView imageView) {
            imageViewReference = new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String imageUrl = params[0];
            Bitmap bitmap = null;

            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            ImageView imageView = imageViewReference.get();
            if (imageView != null && result != null) {
                imageView.setImageBitmap(result);
            }
        }
    }
}
