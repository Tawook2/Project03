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
            <textarea id="message-to-send" name="message-to-send" placeholder="Type your message" rows="3"></textarea>

            <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
            <i class="fa fa-file-image-o"></i>

            <button id="sendBtn" @click="sendMessage(message)">Send</button>

            <button v-on:click="sendMessage('Hello World')">sendMessage</button>

        </div> <!-- end chat-message -->

    </div> <!-- end chat -->

</div> <!-- end container -->
</template>

<style src="../assets/css/chattest.css"></style>




<script>
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'
//import axios from '../api'

//import Stomp from 'webstomp-client'
//import SockJS from 'sockjs-client'


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
        stompClient : null,
        }
    },
    methods: {
            connectToChat(userId) {
                //console.log(userId)
                console.log("connecting to chat...")
                let socket = new SockJS(this.url + '/ws');
                console.log("URL : " + this.url + '/ws');

                console.log("웹소켓 확인" + socket);
                this.stompClient = Stomp.over(socket);
                console.log("중간체크" + this.stompClient);
                this.stompClient.connect({}, function (frame) {
                    console.log("connected to: " + frame);


                    this.stompClient.subscribe("http://localhost:8081/topic/messages/" + userId, function (response) {
                    this.data = JSON.parse(response.body);
                    console.log(this.data);
                    //     render(data.content, data.senderId);         
                    });
                });

            },

            selectUser(userId, userName) {
                console.log("selecting users: " + userId);
                this.selectedUser = userId;
                console.log(userName);
                //$('li').remove("#chat-contents");
                
                //recallChat(selectedUser);
                
                // let isNew = document.getElementById("newMessage_" + userName) !== null;
                //     if (isNew) {
                //         let element = document.getElementById("newMessage_" + userName);
                //         element.parentNode.removeChild(element);
                //         render(newMessages.get(userName), userName);
                //     }
                //    $('#selectedUserId').html('');
                //    $('#selectedUserId').append('Chat with ' + userName);

                this.opponent ='Chat with ' + userName;
                //this.$refs.opponent ='Chat with ' + userName;
            }
        },

        
                

    created: function(){

        this.connectToChat(1);
        

    } 
}

</script>


