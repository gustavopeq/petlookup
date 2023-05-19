package gustavo.projects.petlookup.core

import android.content.SharedPreferences
import gustavo.projects.petlookup.network.utils.Constants.USER_TOKEN
import javax.inject.Inject

class SessionPreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    fun saveAuthToken(token: String) {
        val editor = preferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return preferences.getString(USER_TOKEN, null)
    }
}