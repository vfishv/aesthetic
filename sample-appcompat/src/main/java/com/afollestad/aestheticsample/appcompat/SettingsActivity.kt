/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.afollestad.aestheticsample.appcompat

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.afollestad.aesthetic.AestheticActivity
import kotlinx.android.synthetic.main.activity_settings.toolbar

class SettingsFragment : PreferenceFragmentCompat() {

  override fun onCreatePreferences(
    savedInstanceState: Bundle?,
    rootKey: String?
  ) = setPreferencesFromResource(R.xml.preferences, rootKey)
}

class SettingsActivity : AestheticActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_settings)

    toolbar.setOnClickListener { finish() }

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, SettingsFragment())
          .commit()
    }
  }
}
