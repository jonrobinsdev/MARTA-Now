package robins.martanow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TrainArrivalFragment extends Fragment {

    ImageView trainIcon;
    TextView description;
    Button editButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.train_item, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        trainIcon = (ImageView) view.findViewById(R.id.trainIcon);
        description = (TextView) view.findViewById(R.id.description);
        editButton = (Button) view.findViewById(R.id.editButton);
    }

    public void setDescription(String description){
        this.description.setText(description);
    }
}