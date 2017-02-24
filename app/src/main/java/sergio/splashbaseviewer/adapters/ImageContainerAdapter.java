package sergio.splashbaseviewer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import sergio.splashbaseviewer.R;
import sergio.splashbaseviewer.utils.models.SplashImage;
import sergio.splashbaseviewer.utils.models.SplashImageResponse;

/**
 * @author s.ruiz
 */

public class ImageContainerAdapter extends BaseAdapter {

    private List<SplashImage> images = new ArrayList<>();

    public void setImages(List<SplashImageResponse> images) {
        for (SplashImageResponse imageResponse :
                images) {
            this.images.add(new SplashImage((long)imageResponse.getId(), imageResponse.getUrl()));
        }
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public SplashImage getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return images.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.splash_base_card, null);
            holder = new ImageViewHolder();

            holder.image_id = (TextView) convertView.findViewById(R.id.iv_id);
            holder.image = (ImageView) convertView.findViewById(R.id.iv_image);

            convertView.setTag(holder);
        } else {
            holder = (ImageViewHolder) convertView.getTag();
        }

        SplashImage splashImage = getItem(position);
        if (splashImage != null) {
            holder.image_id.setText(String.valueOf(splashImage.getId()));
            Picasso.with(parent.getContext()).load(splashImage.getImage()).into(holder.image);
        }

        return convertView;
    }

    class ImageViewHolder {
        private TextView image_id;
        private ImageView image;
    }
}
