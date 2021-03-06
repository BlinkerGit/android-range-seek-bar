/*
Copyright 2015 Alex Florescu
Copyright 2014 Yahoo Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.florescu.android.rangeseekbar.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class DemoActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Setup the new range seek bar
        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(this);
        // Set the range
        rangeSeekBar.setRangeType(RangeSeekBar.RangeType.GENERATED);
        rangeSeekBar.setTextFormatter(new DecimalFormat("\u00A4###,###,###"));
        rangeSeekBar.setIncrements(Arrays.asList(1000, 5000, 25000), Arrays.asList(50000, 200000));
        rangeSeekBar.setRangeValues(0, 1000000);

        // Add to layout
        LinearLayout layout = (LinearLayout) findViewById(R.id.seekbar_placeholder);
        layout.addView(rangeSeekBar);

        RangeSeekBar<Integer> predefined = (RangeSeekBar<Integer>) findViewById(R.id.predefined);
        predefined.setPredefinedRangeValues(new ArrayList<Integer>(){{
            add(10);
            add(25);
            add(50);
            add(75);
            add(100);
            add(200);
            add(300);
            add(500);
            add(1000000);
        }});

        // Seek bar for which we will set text color in code
        RangeSeekBar rangeSeekBarTextColorWithCode = (RangeSeekBar) findViewById(R.id.rangeSeekBarTextColorWithCode);
        rangeSeekBarTextColorWithCode.setTextAboveThumbsColorResource(android.R.color.holo_blue_bright);
    }
}
