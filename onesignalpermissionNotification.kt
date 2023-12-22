class OneSignalObserver : IPermissionObserver {
    override fun onNotificationPermissionChange(permission: Boolean) {
        if(!permission){
            try {
                CoroutineScope(Dispatchers.IO).launch {
                    OneSignal.Notifications.requestPermission(true)
                }
            }catch (e:Exception){
                Log.v("ONESIGNALOPPO", e.toString())
            }
        }
    }

}

//        val observerPermission = OneSignalObserver()
//        OneSignal.Notifications.addPermissionObserver(observer = observerPermission)
