TimeLine
========
An App.net client that just lists the most recent posts from the public timeline.  
The timeline can be fetched here:   https://alpha-api.app.net/stream/0/posts/stream/global

Component used - 

1 android.support.v4.widget.SwipeRefreshLayout - Pull to Refresh 

2 App compact light theme 

3 GSON with  Date JsonDeserializer to handle date format (yyyy-MM-dd'T'HH:mm:ss'Z')

4 Volley is used for image loading and API call using seperate request queue 

5 GSON Generic Request Using Volley and call back listener to Requesting Activity 

6 Date comparator to sort the date to Most recent in Data set.




