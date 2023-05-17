package gustavo.projects.petlookup.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gustavo.projects.petlookup.R
import gustavo.projects.petlookup.network.ApiClient
import gustavo.projects.petlookup.network.SessionManager
import gustavo.projects.petlookup.network.models.AnimalsResponse
import gustavo.projects.petlookup.network.models.UserTokenRequest
import gustavo.projects.petlookup.network.models.UserTokenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        apiClient = ApiClient()
        sessionManager = SessionManager(requireContext())

        apiClient.getApiService(requireContext()).getToken(UserTokenRequest()).enqueue(
            object : Callback<UserTokenResponse> {
                override fun onFailure(call: Call<UserTokenResponse>, t: Throwable) {
                    println("PRINT - on Failure")
                }

                override fun onResponse(
                    call: Call<UserTokenResponse>,
                    response: Response<UserTokenResponse>
                ) {
                    val userTokenResponse = response.body()

                    userTokenResponse?.accessToken?.let { token ->
                        println("PRINT - Access Token: $token")
                        sessionManager.saveAuthToken(token)
                    }
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}