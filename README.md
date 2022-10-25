# Social Media
An application where users can login and browse and perform operations as they do on social media platforms

## Description
In this application Users can choose to send friend request to other users, view the friends list of a friend and make posts and comments. This is designed to behave in a general social media like way and has basic social media features.

## Used Technologies
- Backend: Spring Boot, Spring Security, Spring Data JPA , MySql
- Frontend: Thymeleaf

## Features
**1. Login/Logout authentication**

Login and logout have been secured and passwords have been encrypted with Spring security

![alt text](Readme%20Attachments/loginlogout.jpg)

**2. Home page**

![alt text](Readme%20Attachments/homepage.jpg)

**3. Create post**

After "Post" button the post is created and shown at the last place in the post page

![alt text](Readme%20Attachments/post.jpg)

**4. View post**

Clicking "View posts" button on home page takes the user to the posts page and shows them all of their posts

![alt text](Readme%20Attachments/viewpost.jpg)

**5. View Friend Requests**

Clicking "View Friend Request" button on home page takes the user to the requests page and shows them all of their received requests

![alt text](Readme%20Attachments/viewrequest.jpg)

The user can either accept or reject the request. Until the receiver rejects the request they cannot send a request to the sender

![alt text](Readme%20Attachments/userpage.jpg)

After the receiver has rejected the request, they can send a request to the sender

![alt text](Readme%20Attachments/userpage2.jpg)

**6. User profile page**

The user can got to any of the users' profile page from the home page

![alt text](Readme%20Attachments/selectuser.jpg)

If the user is a friend the all of the user's friends will be shown in a dropdown at the top of the profile page

![alt text](Readme%20Attachments/userpage3.jpg)

If the user is not a friend then a send friend request option will be shown

![alt text](Readme%20Attachments/userpage4.jpg)

**7. View Comments**

By clicking view comments anyone can view all the comments made in a post

![alt text](Readme%20Attachments/comment.jpg)


**7. Write Comment**

By clicking creating a comment anyone can make a comment on the post and it will be shown to everyone

![alt text](Readme%20Attachments/writecomment.jpg)

**7. User Registration**

![alt text](Readme%20Attachments/userreg.jpg)


## ER-Diagram
![alt text](Readme%20Attachments/er-diagram.jpg)





