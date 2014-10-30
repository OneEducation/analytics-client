/*
 * Copyright (C) 2014 Martin Abente Lahaye - martin.abente.lahaye@gmail.com.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

package org.OneEducation.HarvestClient;

import java.lang.Long;

import android.util.Log;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;


class HarvestSettings {

   static final Long INTERVAL = 15L;
   static final Long PERSIST = 300L;
   static final Long ATTEMPT_INTERVAL = 1800L;
   static final Long REPORT_INTERVAL = 518400L;
   static final String SERVER = "https://192.168.0.12/analytics/report";
   static final String KEY = "analytics";

   private Context context;

   public HarvestSettings(Context _context){
      context = _context;
   }

   public Long getLastReported(){
       Log.i("HarvestSettings", "getLastReported");
       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
       return preferences.getLong("lastReported", 0);
   }

   public void setLastReported(Long lastReported){
       Log.i("HarvestSettings", "setLastReported");
       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
       Editor editor = preferences.edit();
       editor.putLong("lastReported", lastReported);
       editor.commit();
   }
}
