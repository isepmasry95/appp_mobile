# II.3510-Android-Demo
Simple example of an Android application, which showcases navigation between Activities, the use of ListViews, 
and the consumption of a web service. This example has been developed for the II.3510 mobile development course at Institut Supérieur d'Électronique de Paris (ISEP), Paris, France.

This application uses https://jsonplaceholder.typicode.com/ to retrieve data from a dummy web service.

### Creating user interfaces with XML or dynamically
In this application, we show how to create the structure of some user interfaces using the XML files. However, we sometimes 
need to dynamically add widgets to some activities, and this demo shows how to proceed to just do that.

In particular, we show how to create and display ListViews. However, the implementation could be perfected to add a
"Load more entries" kind of feature. Doing so would improve the performances of the application.

### Navigation between activities
In this application, we simply show how to create Intent and pass information (i.e., extras) from an activity to another. 
Of course, we also show how to retrieve these extras on the newly displayed activity.

### Consuming a web service
As stated previously, the application uses https://jsonplaceholder.typicode.com/ to retrieve some dummy data. The application
uses all the available resources except for Photos (because there are too many photos, and there is no way to limit the 
number of photos we get from a single request).

The requests are made using Android Volley (more information on this particular library here: 
https://developer.android.com/training/volley/index.html). A similar implementation will also be made using the AsyncTask class in a future commit.
