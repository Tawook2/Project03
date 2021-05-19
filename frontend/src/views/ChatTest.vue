<template>
<div class="container clearfix">
    <div class="people-list" id="people-list">
        <div class="search">
            <label>{{ userData.username}}</label>
        </div>
        <ul class="list" id="usersList" >
            <a href="#" @click="selectUser(i.id, i.name)" :key="i.id" :value="i" v-for="i in userData">
                <li class="clearfix" >
                    <img src="https://source.unsplash.com/featured/face=2" width="55px" height="55px" alt="avatar" />
                    <div class="about">
                        <div id="userNameAppender_${user.name}" class="name">{{i.name}}</div>
                        <div class="status">
                            <i class="fa fa-circle offline"></i>
                        </div>
                    </div>
                </li>
            </a>
        </ul>
    </div>

    <div class="chat">
        <div class="chat-header clearfix">
            <img alt="avatar" height="55px"
                 src="https://source.unsplash.com/featured/face=3" width="55px"/>

            <div class="chat-about">
                <div class="chat-with" id="selectedUserId" v-text="opponent">{{opponent}}</div>
                <div class="chat-num-messages"></div>
            </div>
            <i class="fa fa-star"></i>
        </div> <!-- end chat-header -->

        <div class="chat-history">
            <ul>
				
            </ul>

        </div> <!-- end chat-history -->

        <div class="chat-message clearfix">
            <textarea id="message-to-send" name="message-to-send" placeholder="Type your message" rows="3" v-model="message"></textarea>

            <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
            <i class="fa fa-file-image-o"></i>
            
            <button id="sendBtn" @click="sendMessage(message)">Send</button>

            

        </div> <!-- end chat-message -->

    </div> <!-- end chat -->

</div> <!-- end container -->
</template>

<style src="../assets/css/chattest.css"></style>




<script>
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'
//import axios from '../api'

let socket = new SockJS('http://localhost:8081/fleamarket/ws');
let stompClient = Stomp.over(socket);

export default {
    name: 'App',
    
    components: {
        
    },

    data: function() {
        return {
        userData : [
            {
                id : 1,
                name : 'test01'
            },
            {
                id : 2,
                name : 'test02'
            },
            {
                id : 3,
                name : 'test03'
            },
        
        ],
        url: 'http://localhost:8081/fleamarket',
        data : null,
        selectedUser : '',
        opponent : '',
        message : '',
        loginedUser : 1,
        
        }
    },
    methods: {

            render(message, userId) {
                console.log(message);
                console.log(userId);
            //     scrollToBottom();
            //     // responses
            //     var templateResponse = Handlebars.compile($("#message-response-template").html());
            //     var contextResponse = {
            //         response: message,
            //         time: getCurrentTime(),
            //         userId: userId
            //     };

            //     setTimeout(function () {
            //         $chatHistoryList.append(templateResponse(contextResponse));
            //         scrollToBottom();
            //     }.bind(this), 1500);
            },

            connectToChat(userId) {
                //console.log(userId)
                console.log("connecting to chat...")
                console.log("URL : " + this.url + '/ws');

                

                console.log("웹소켓 확인" + socket);
                
                console.log("중간체크" + this.stompClient);
                stompClient.connect({}, function (frame) {
                    console.log("connected to: " + frame);

                    stompClient.subscribe("http://localhost:8081/topic/messages/" + userId, function (response) {
                    this.data = JSON.parse(response.body);
                    console.log(this.data);
                        this.render(this.data.content, this.data.senderId);         
                    });
                });

            },

            selectUser(userId, userName) {
                console.log("selecting users: " + userId);
                this.selectedUser = userId;
                console.log(userName);
                
                //$('li').remove("#chat-contents");
                
                //제일 나중에
                //recallChat(selectedUser);
                
                // let isNew = document.getElementById("newMessage_" + userName) !== null;
                //     if (isNew) {
                //         let element = document.getElementById("newMessage_" + userName);
                //         element.parentNode.removeChild(element);
                //         render(newMessages.get(userName), userName);
                //     }
            
                this.opponent ='Chat with ' + userName;
            
            },
        
            sendMsg(from, text) {
                stompClient.send("http://localhost:8081/app/chat/" + this.selectedUser, {}, JSON.stringify({
                    senderId: from,
                    receiverId: this.selectedUser,
                    content: text
                }));
            },

            scrollToBottom() {
                //var chatHistory = document.getElementsByClassName("chat-history");
                //chatHistory.scrollTop(chatHistory[0].scrollHeight);
            },

            sendMessage(message) {
    
                console.log("보내는 사람:" + this.loginedUser);

                console.log("받는 사람: " + this.selectedUser);

                console.log("보내는 메세지: " + message);

                this.sendMsg(this.loginedUser, message);

                this.scrollToBottom();

                // if (message.trim() !== '') {
                //     var template = Handlebars.compile($("#message-template").html());
                //     var context = {
                //         messageOutput: message,
                //         time: getCurrentTime(),
                //         toUserName: selectedUser
                //     };

                //     $chatHistoryList.append(template(context));
                this.scrollToBottom();

                this.message = '';
                    
                }
            },
        
                

    created: function(){

        this.connectToChat(1);

    } 
}

</script>


