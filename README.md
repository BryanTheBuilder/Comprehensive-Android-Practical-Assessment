# Comprehensive-Android-Practical-Assessment

One of the difficulties that I ran into was loading picasso images from a retrofit api call since calling it from the retrofit
onResponse method would not populate my imageviews. I imagine there was some issue with having the retrofit call be asynchronous
while picasso is not asynchronous and interacts directly with the UI. Other difficulties including managing time around this error
and making an effort to add dimens and strings to xml values directory. Image resizing was also something I didnt think wold eat
up my time the way it did but some careful research led me to correct implementation
