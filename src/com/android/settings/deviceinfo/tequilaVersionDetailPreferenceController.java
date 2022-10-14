/*
 * Copyright (C) 2019 The LineageOS Project
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
import android.content.Intent;
import android.os.SystemProperties;

import com.android.settings.R;

public class tequilaVersionDetailPreferenceController extends BasePreferenceController {

    private static final String TAG = "tequilaVersionDialogCtrl";

    private static final String KEY_TEQUILA_VERSION_PROP = "ro.tequila.display.version";

    public tequilaVersionDetailPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
    String tequilaVer = SystemProperties.get(KEY_TEQUILA_VERSION_PROP);
    if (!tequilaVer.isEmpty())
        return tequilaVer;
    else
        return mContext.getString(R.string.unknown);
    }
}
