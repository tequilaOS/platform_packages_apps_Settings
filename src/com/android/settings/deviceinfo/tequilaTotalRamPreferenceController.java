/*
 * Copyright (C) 2022 tequilaOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo;

import android.content.Context;
import android.text.format.Formatter;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class tequilaTotalRamPreferenceController extends BasePreferenceController {

    private static final String TAG = "tequilaTotalRamCtrl";

    public tequilaTotalRamPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        MemInfo memInfo = mStatsManager.getMemInfo();

        double totalRam = memInfo.realTotalRam;

        String tequilaTotalRam = Formatter.formatShortFileSize(context, (long) totalRam);

        if (!tequilaTotalRam.isEmpty()) {
            return tequilaTotalRam;
        } else {
            return mContext.getString(R.string.unknown);
        }
    }
}
