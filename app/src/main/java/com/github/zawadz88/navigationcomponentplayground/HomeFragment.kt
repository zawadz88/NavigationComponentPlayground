package com.github.zawadz88.navigationcomponentplayground

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.fragmentLoginButton
import kotlinx.android.synthetic.main.fragment_home.fragmentLoginWithPasswordButton
import kotlinx.android.synthetic.main.fragment_home.fragmentOfferButton
import kotlinx.android.synthetic.main.fragment_home.sendNotificationButton

private const val NOTIFICATION_CHANNEL_ID = "dummy channel id"

class HomeFragment : BaseFragment() {

    override val hasUpNavigation: Boolean = false

    private val notificationManager: NotificationManager by lazy { requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentLoginButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCollectiveLoginFragment())
        }
        fragmentLoginWithPasswordButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginWithPasswordFragment())
        }
        fragmentOfferButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToOfferFragment(1234))
        }
        sendNotificationButton.setOnClickListener { prepareAndSendNotification() }
    }

    private fun prepareAndSendNotification() {
        val myId = 888
        val offerFragmentArgs = OfferFragmentArgs(myId)
        val pendingIntent = NavDeepLinkBuilder(requireContext())
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.offerFragment)
            .setArguments(offerFragmentArgs.toBundle())
            .createPendingIntent()
        setUpChannel()
        val builder = NotificationCompat.Builder(requireContext(), NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Check out this offer!")
            .setContentText("It's really worth it. Show me offer $myId")
            .setAutoCancel(true)
            .setColor(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            .setContentIntent(pendingIntent)
        notificationManager.notify(myId, builder.build())
    }

    private fun setUpChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val jobAlertsChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Dummy channel name",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(jobAlertsChannel)
        }
    }
}
