###### Kotlin-Fragment-104
#### **Handling configuration changes while adding, removing and replacing fragments**

## **When configuration change can happen?**

Changing screen orientation, user enabling multi window, user making keyboard available, or anything that can delay app 
usage might cause configuration changes. When configuration changes, the *system destroys the fragment and activity and 
restarts by executing on create*. As developers, we have to make sure that our application won’t lose user's data after 
configuration changes. And to restore all users previous state we need to handle this configuration changes, and at the 
same time, we don't want a slow user experience while restoring data. 
