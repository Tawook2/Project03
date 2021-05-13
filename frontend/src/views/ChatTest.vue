<template>
<div class="container clearfix">
    <div class="people-list" id="people-list">
        <div class="search">
            <label>{{ userData.username}}</label>
        </div>
        <ul class="list" id="usersList">
            <a href="#" onclick="selectUser('${user.id}','${user.name}')"><li class="clearfix">
                        <img src="https://source.unsplash.com/featured/face=2" width="55px" height="55px" alt="avatar" />
                        <div class="about">
                            <div id="userNameAppender_${user.name}" class="name">{{ userData}}</div>
                            <div class="status">
                                <i class="fa fa-circle offline"></i>
                            </div>
                        </div>
                    </li></a>
        </ul>
    </div>

    <div class="chat">
        <div class="chat-header clearfix">
            <img alt="avatar" height="55px"
                 src="https://source.unsplash.com/featured/face=3" width="55px"/>

            <div class="chat-about">
                <div class="chat-with" id="selectedUserId"></div>
                <div class="chat-num-messages"></div>
            </div>
            <i class="fa fa-star"></i>
        </div> <!-- end chat-header -->

        <div class="chat-history">
            <ul>
				
            </ul>

        </div> <!-- end chat-history -->

        <div class="chat-message clearfix">
            <textarea id="message-to-send" name="message-to-send" placeholder="Type your message" rows="3"></textarea>

            <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
            <i class="fa fa-file-image-o"></i>

            <button id="sendBtn">Send</button>

            <button v-on:click="sendMessage('Hello World')">sendMessage</button>

        </div> <!-- end chat-message -->

    </div> <!-- end chat -->

</div> <!-- end container -->
</template>

<style src="../assets/css/chattest.css"></style>




<script>
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'

export default {
    name: 'App',
    components: {
        
    },

    data: function() {
        return {
        userData : 'test01',
        socket: null,
        stompClient: null,
        url: 'http://localhost:8081/fleamarket',
        // userId : 'test01',
        }
    },
    methods: {
            connectToChat(userId) {
            console.log(userId)
            console.log("connecting to chat...")
            this.socket = new SockJS(this.url + '/ws');
            this.stompClient = Stomp.over(this.socket);
            this.stompClient.connect({}, function (frame) {
                console.log("connected to: " + frame);
                // stompClient.subscribe("/topic/messages/" + userId, function (response) {
                //     let data = JSON.parse(response.body);
                            
                //     render(data.content, data.senderId);
                            
                // });
            });
        }
    },

    created: function(){
        this.connectToChat("test01");
    }

   
//     data: function(){
//     return {
//         userData : "test01",
//         connection: null
//     }
// },
//     methods: {
//         sendMessage: function(message){
//         console.log(this.connection)
//         this.connection.send(message);
//     }
// },

//     created: function(){
//         console.log("Starting Connection to WebSocket server")
//         this.connection = new WebSocket("wss://echo.websocket.org")

//         this.connection.onopen = function(event){
//         console.log(event)
//         console.log("Successfully connected to the echo WebSocket Server");
//     }

//     this.connection.onmessage = function(event){
//       console.log(event)
//     }
//   }
    
    
}

</script>


