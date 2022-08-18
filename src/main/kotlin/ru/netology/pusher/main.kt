package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()
    FirebaseApp.initializeApp(options)
//    val message1 = likeAction()
//    FirebaseMessaging.getInstance().send(message1)
    val message2 = newPostAction()
    FirebaseMessaging.getInstance().send(message2)
}

fun likeAction(): Message = Message.builder()
    .putData("action", "LIKE")
    .putData(
        "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
    )
    .setToken(token)
    .build()

fun newPostAction(): Message = Message.builder()
    .putData("action", "NEW_POST")
    .putData(
        "content", """{
          "postAuthor": "Andrei",
          "postContent": "Push-уведомления – это маленькие окна с сообщениями, 
          |всплывающие на экране устройства. Они содержат совершенно разную информацию: 
          |от новостей и акций до обновлений и персональных предложений. 
          |Push-уведомления – отличный маркетинговый инструмент с  высокой конверсией, 
          |главное – пользоваться им правильно."          
        }""".trimMargin()
    )
    .setToken(token)
    .build()
