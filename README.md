# CovidHub_forCovidHacks2020
The ultimate Coronavirus Hub to find the closest Covid testing center, to stay updated on the latest Covid news, to never forget your mask at home, and more!
## Inspiration
One of the biggest reasons the United States was late to respond to the pandemic was because of the lack of testing. With no tests, the government nor the people could tell if Covid was a problem or not in the US. Once the tests started becoming more widespread and available, the nation soon came to realize that this was the biggest pandemic in 100 years. What makes this virus so deadly is the fact that not only is it very transmissible, but also you can be asymptomatic and have no idea you have the virus, while going outside to the grocery store, partying at someone's house, sharing food with your friends, etc. You have no idea you have the virus and now you have possibly infected many more people. This is why it is important that most people, if not everyone, gets tested for the virus to see if they need to quarantine at home or not. This will also give the government a better idea of the state of the virus and give statisticians/health experts a better number to calculate the exact infection fatality rate. 

According to the a poll shown on the New York Times, only about 59 in 100 Americans wear a mask when they leave the house, which is significantly lower compared to the other countries who have handled the virus better. With many studies coming out saying how the virus can be maintained if everyone wore a mask, it is also very important people do not forget their mask when they go outside. 

When researching for Covid specific news to see what exactly is happening and what the status is on vaccines and treatments, usually people have to dig for the information. It is important that the public is informed on the status regarding this pandemic, and have the news easily accessible to them. 

With these three problems: testing, masking, and staying updated. I have created CovidHub. The ultimate Coronavirus application that allows users to find the closest testing center, remind themselves to wear a mask before leaving the house, and also staying up to date on the latest coronavirus news. 

## What it does
CovidHub ultimately does three things. The main feature is being able to find the closest Covid testing location to get a test to see if you are infected or not. Another feature allows users to set the time of when they are going to leave the house so that a notification/reminder will be sent to the user's phone to remind them to not forget their mask. The final feature is an organized RSS feed for coronavirus updates from the New York Times Health section to keep the general public informed on the issues and status of the impact. On the bottom of the home screen there are a couple add-ons including a button to go straight to the CDC guidelines and another button that takes users to the Worldometers Coronavirus data and graphs. 

## How I built it
I built this application using Java and Android Studio, because I have a lot of experience using these. I first started with the "finding the closest testing location" part of the application, which required an API key and lots of reading/watching tutorials, since this was my first time working with this stuff. I later did the RSS Covid News Feed, which was a piece of cake for me, because I have built multiple RSS feeds in the past and have experience with RecyclerViews, CardViews, and parsing XML files. Finally I worked on the Notification updates to remind the user to wear a mask. I used various important libraries to do this including TimePickerDialog, Calender, and NotificationChannel. At last I changed up the colors, inserted some cool icons, and added a couple add-ons (buttons) at the bottom of the screen to allow users to go to important websites (CDC and Worldometers) for more information. 

## Challenges I ran into
A challenge I ran into was using Places API to find nearby places (nearby coronavirus testing locations). I tried many different things and coded the whole process completely, but it just didn't seem to work at the end. I have a feeling its a problem with my API key or I may not have Places API properly enabled, but I am not sure. I spent the most time on figuring out this problem, but with the time constraints I moved on to the other aspects of CovidHub. The other challenge I had was formatting the home page of the application. Although it may seem easy, I had a pretty difficult time constraining everything and making it not look weird. I probably had to redo the constrains completely like 5 times. Also, as a one man team, I had a problem with time :)

## Accomplishments that I'm proud of
The biggest thing I am proud of is being able to get the current location of the user and somewhat being able to use the Google APIs. I've programmed many different applications in the past, but I have never used Google Maps SDK or Places API nor get a working Map up on the phone. So that was exciting to see the some parts of it work. However, there is still a lot of improvement that needs to be done and a lot I need to learn regarding this. I am also proud of how the application looks as a whole. Usually when I program apps, I don't care about the looks at all, mainly because I am bad at designing the UI and also I don't pay attention to it. However, I put time and effort in making the app look somewhat good with the icons and colored buttons, and I am proud of it overall. It would be better with UI softwares like Flutter or React Native, but I have yet to learn those. And most of all, doing all this in 24 hours was a great accomplishment for me. 

## What I learned
The biggest thing I learned was using the Google Maps SDK and Places API in Android Studio to show your current location and nearby places. I learned about the process in getting an API key from google and integrating it into the android application. I also learned a lot about notifications and having to create different notification channels to send updates to the user's phone at a certain time. I found some great websites where you can download icons to put in your application for free to make the application's UI look better. I learned how to efficiently go from one Activity to another in the android application, using Intent library. I had to parse both XML and JSON formatted code in my application, so I gained more knowledge regarding that, however I already knew how to do this. 

## What's next for CovidHub
There are many improvements that can be done for this application. For the mask reminders, right now only 1 reminder can be set at once. In the future, it will be better to have multiple reminders and for the date to be set as well. Also it would be nice to have google calenders integrated into CovidHub so that it can go off the schedule from the calender and give the necessary notifications and updates automatically. For the RSS Covid News Feed, right now the news is solely from the New York Times Health section. In the future I will integrate many different sources including WHO, John Hopkins, CDC, etc along with mainstream media news to have an ultimate RSS Feed with all the relevant Covid news to keep the public updated. For finding the nearest testing center, other than having the closest testing centers actually show up, in the future, having the users click on a certain test center so they can call, look at timings, or open the address on google maps, will be useful.

