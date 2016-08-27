/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Austin Donovan (addonovan)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package addonovan.kftc.config

import addonovan.kftc.R
import android.preference.PreferenceScreen

/**
 * !Description!
 *
 * @author addonovan
 * @since 8/27/16
 */
class FragmentProfile : CustomFragment()
{
    //
    // Values
    //

    override val PreferenceResource: Int = R.xml.prefs_profile;

    /** The name of the opmode to configure. */
    private val OpModeName: String by lazy()
    {
        arguments[ OPMODE_NAME ]!! as String;
    }

    /** The name of the profile we're configuring. */
    private val ProfileName: String by lazy()
    {
        arguments[ PROFILE_NAME ]!! as String;
    }

    //
    // Actions
    //

    override fun onBackPressed(): Boolean
    {
        switchTo( FragmentOpModeConfig(), OPMODE_NAME to OpModeName );
        return true;
    }

    override fun onCreate()
    {
        setTitle( ProfileName );
        val profile = Configurations.opModeConfigFor( OpModeName ).getProfile( ProfileName );

        val deleteProfile = findPreference( "delete_profile" ) as PreferenceScreen;
        deleteProfile.setOnPreferenceClickListener {

            // TODO ask the user to confirm

            true;
        };
    }

}