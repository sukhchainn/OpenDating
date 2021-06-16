package com.dragonize.opendating.ui.home;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.dragonize.opendating.cardstackview.*;
import com.dragonize.opendating.R;
import com.dragonize.opendating.utils.LinearGradient;
import com.dragonize.opendating.vh.main.Profile;

public class HomeFragment extends Fragment {
    CardStackView cardStackView;
    CardStackLayoutManager cardStackLayoutManager;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.id_label_discover);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardStackView = view.findViewById(R.id.id_cardStackView);
        cardStackLayoutManager = new CardStackLayoutManager(requireContext());
        cardStackLayoutManager.setStackFrom(StackFrom.Bottom);
        cardStackLayoutManager.setVisibleCount(3);
        cardStackLayoutManager.setTranslationInterval(8.0f);
        cardStackLayoutManager.setScaleInterval(0.90f);
        cardStackLayoutManager.setMaxDegree(20.0f);
        cardStackLayoutManager.setSwipeThreshold(0.3f);
        cardStackLayoutManager.setCanScrollHorizontal(true);
        cardStackLayoutManager.setCanScrollVertical(true);
        cardStackView.setLayoutManager(cardStackLayoutManager);
        cardStackView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(requireContext()).inflate(R.layout.profile_at_home, parent, false);
                return new Profile(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                Profile profile = (Profile) holder;

                int topImageDominantColor = LinearGradient.getDominantColor(LinearGradient.drawableToBitmap(profile.profile_picture.getDrawable()));
                GradientDrawable gradientDrawable = LinearGradient.linearGradientTransparentTop(topImageDominantColor);
                profile.profile_detail_layout.setBackground(gradientDrawable);
            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }
}