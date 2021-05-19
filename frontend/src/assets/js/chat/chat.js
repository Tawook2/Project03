const url = '/fleamarket';
let stompClient;
let selectedUser;
let newMessages = new Map();

// 완료
function connectToChat(userId) {
    console.log("connecting to chat...")
    let socket = new SockJS(url + '/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected to: " + frame);
        stompClient.subscribe("/topic/messages/" + userId, function (response) {
            let data = JSON.parse(response.body);
                     
            render(data.content, data.senderId);
                     
        });
    });
}

// 완료
function sendMsg(from, text) {
    stompClient.send("/app/chat/" + selectedUser, {}, JSON.stringify({
        senderId: from,
        receiverId: selectedUser,
        content: text
    }));
}

// 완료
function selectUser(userId, userName) {
    console.log("selecting users: " + userId);
    selectedUser = userId;
    
    $('li').remove("#chat-contents");
    
    recallChat(selectedUser);
    
    let isNew = document.getElementById("newMessage_" + userName) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + userName);
        element.parentNode.removeChild(element);
        render(newMessages.get(userName), userName);
    }
    $('#selectedUserId').html('');
    $('#selectedUserId').append('Chat with ' + userName);
      
}

function recallChat(selectedUser) {
	$.get(url + "/recallChat/" + selectedUser, function (response){
		let messages = response;
			
		console.log(messages);
	});
}
