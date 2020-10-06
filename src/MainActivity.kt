class MainActivity : AppCompatActivity() {

    private val unityGameID = "xxxxxxx"
    private val testMode = true
    private val rewardedPlacement = "xxxxxxxx"
    private val interstitialPlacement = "xxxxxxxxx"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second_main)

        /////////////////////////// Unity Ads initialization
        val adListener = UnityVideoAdsListener()
        UnityAds.addListener(adListener)
        UnityAds.initialize(applicationContext, unityGameID, testMode)
        ////////////////////////// Unity Ads initialization


        ////////////// Show the ad on a button click
        binding.adAnimationView.setOnClickListener {
            showRewardedVideoAd()
        }

    }

    private fun showRewardedVideoAd() {
        // Rewarded video ad
        if (UnityAds.isReady(rewardedPlacement)) {
            UnityAds.show(this, rewardedPlacement)

        } else {
            // Interstitial Video ad
            showUnityInterstitialAd()
        }
    }

    private fun showUnityInterstitialAd() {
        if (UnityAds.isReady(interstitialPlacement)) {
            UnityAds.show(this, interstitialPlacement)
        }
    }

    private inner class UnityVideoAdsListener : IUnityAdsListener {

        override fun onUnityAdsReady(placementId: String?) {
            // This function never gets called because (UnityAds.isInitialized() == false)
        }

        override fun onUnityAdsStart(placementId: String?) {
        }

        override fun onUnityAdsFinish(placementId: String?, p1: UnityAds.FinishState?) {
        }

        override fun onUnityAdsError(p0: UnityAds.UnityAdsError?, p1: String?) {
            // This function never gets called because (UnityAds.isInitialized() == false)
        }
    }

}