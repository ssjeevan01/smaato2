# smaato2
Pre requisite:

User should have the Android-Studio installed in his machine

Things done:

1. This project requires us to show an ad.
2. To show an ad we need two parameters,
    i) publisherId (check the variable called 'publisherId' in SmaatoApplication.java class)
    ii) adSpaceId (check the variable called 'adspaceId' in MainActivity.java class)
3. To get the above two IDs, we need to create an account and app under https://spx.smaato.com/
4. But for the testing purposes, I used the sample publisherId and adspaceId mentioned in the site https://developers.smaato.com/nextgen-sdk-android-integration/ (search for Ads for Testing Purposes)
5. Three types of ads are available with different adSpaceId;
    i) banner,
   ii) interstitial
   iii) rewarded video ad.
6. I chose banner Rich Media ad and used that ID - in MainActivity.java.
7. When you click the button "Show The Ad". It will make an "AdRequest" and the response will be shown in the "BannerView". Please find the attachment.
8. When you click the ad, a new web page will be opened.
9. You will get the callback "onAdClicked" whenever you click the ad. (Check line number 34 in MainActivity)
10. Test are written using the espresso
11. Could not complete Tap Ad, method call since it cannot be done using espresso, we can use mockito but it requires sometime.

Hope this information is sufficient!!
