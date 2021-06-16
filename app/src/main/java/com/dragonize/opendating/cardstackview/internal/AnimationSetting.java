package com.dragonize.opendating.cardstackview.internal;

import android.view.animation.Interpolator;

import com.dragonize.opendating.cardstackview.Direction;

public interface AnimationSetting {
    Direction getDirection();
    int getDuration();
    Interpolator getInterpolator();
}
