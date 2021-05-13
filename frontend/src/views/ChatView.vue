<template>
  <div class="container clearfix">
    
    <div class="people-list" id="people-list">
      <div class="search">
        <input id="userName" value="${userId }" type="text" />
      </div>

      <form class="search-form">
        <input
          type="search"
          value=""
          placeholder="Search"
          class="search-input"
        />
        <button type="submit" class="search-button">
          <svg class="submit-button">
            <use
              xmlns:xlink="http://www.w3.org/1999/xlink"
              xlink:href="#search"
            ></use>
          </svg>
        </button>
        <div class="search-option">
          <div>
            <input
              name="type"
              type="radio"
              value="type-users"
              id="type-users"
            />
            <label for="type-users">
              <svg class="edit-pen-title">
                <use
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                  xlink:href="#user"
                ></use>
              </svg>
              <span>Users</span>
            </label>
          </div>

          <div>
            <input
              name="type"
              type="radio"
              value="type-posts"
              id="type-posts"
            />
            <label for="type-posts">
              <svg class="edit-pen-title">
                <use
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                  xlink:href="#post"
                ></use>
              </svg>
              <span>Posts</span>
            </label>
          </div>
          <div>
            <input
              name="type"
              type="radio"
              value="type-images"
              id="type-images"
            />
            <label for="type-images">
              <svg class="edit-pen-title">
                <use
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                  xlink:href="#images"
                ></use>
              </svg>
              <span>Images</span>
            </label>
          </div>
          <div>
            <input
              name="type"
              type="radio"
              value="type-special"
              id="type-special"
              checked=""
            />
            <label for="type-special">
              <svg class="edit-pen-title">
                <use
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                  xlink:href="#special"
                ></use>
              </svg>
              <span>Special</span>
            </label>
          </div>
        </div>
      </form>

      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="0"
        height="0"
        display="none"
      >
        <symbol id="search" viewBox="0 0 32 32">
          <path
            d="M 19.5 3 C 14.26514 3 10 7.2651394 10 12.5 C 10 14.749977 10.810825 16.807458 12.125 18.4375 L 3.28125 27.28125 L 4.71875 28.71875 L 13.5625 19.875 C 15.192542 21.189175 17.250023 22 19.5 22 C 24.73486 22 29 17.73486 29 12.5 C 29 7.2651394 24.73486 3 19.5 3 z M 19.5 5 C 23.65398 5 27 8.3460198 27 12.5 C 27 16.65398 23.65398 20 19.5 20 C 15.34602 20 12 16.65398 12 12.5 C 12 8.3460198 15.34602 5 19.5 5 z"
          />
        </symbol>
        <symbol id="user" viewBox="0 0 32 32">
          <path
            d="M 16 4 C 12.145852 4 9 7.1458513 9 11 C 9 13.393064 10.220383 15.517805 12.0625 16.78125 C 8.485554 18.302923 6 21.859881 6 26 L 8 26 C 8 21.533333 11.533333 18 16 18 C 20.466667 18 24 21.533333 24 26 L 26 26 C 26 21.859881 23.514446 18.302923 19.9375 16.78125 C 21.779617 15.517805 23 13.393064 23 11 C 23 7.1458513 19.854148 4 16 4 z M 16 6 C 18.773268 6 21 8.2267317 21 11 C 21 13.773268 18.773268 16 16 16 C 13.226732 16 11 13.773268 11 11 C 11 8.2267317 13.226732 6 16 6 z"
          />
        </symbol>
        <symbol id="images" viewbox="0 0 32 32">
          <path
            d="M 2 5 L 2 6 L 2 26 L 2 27 L 3 27 L 29 27 L 30 27 L 30 26 L 30 6 L 30 5 L 29 5 L 3 5 L 2 5 z M 4 7 L 28 7 L 28 20.90625 L 22.71875 15.59375 L 22 14.875 L 21.28125 15.59375 L 17.46875 19.40625 L 11.71875 13.59375 L 11 12.875 L 10.28125 13.59375 L 4 19.875 L 4 7 z M 24 9 C 22.895431 9 22 9.8954305 22 11 C 22 12.104569 22.895431 13 24 13 C 25.104569 13 26 12.104569 26 11 C 26 9.8954305 25.104569 9 24 9 z M 11 15.71875 L 20.1875 25 L 4 25 L 4 22.71875 L 11 15.71875 z M 22 17.71875 L 28 23.71875 L 28 25 L 23.03125 25 L 18.875 20.8125 L 22 17.71875 z"
          />
        </symbol>
        <symbol id="post" viewbox="0 0 32 32">
          <path
            d="M 3 5 L 3 6 L 3 23 C 3 25.209804 4.7901961 27 7 27 L 25 27 C 27.209804 27 29 25.209804 29 23 L 29 13 L 29 12 L 28 12 L 23 12 L 23 6 L 23 5 L 22 5 L 4 5 L 3 5 z M 5 7 L 21 7 L 21 12 L 21 13 L 21 23 C 21 23.73015 21.221057 24.41091 21.5625 25 L 7 25 C 5.8098039 25 5 24.190196 5 23 L 5 7 z M 7 9 L 7 10 L 7 13 L 7 14 L 8 14 L 18 14 L 19 14 L 19 13 L 19 10 L 19 9 L 18 9 L 8 9 L 7 9 z M 9 11 L 17 11 L 17 12 L 9 12 L 9 11 z M 23 14 L 27 14 L 27 23 C 27 24.190196 26.190196 25 25 25 C 23.809804 25 23 24.190196 23 23 L 23 14 z M 7 15 L 7 17 L 12 17 L 12 15 L 7 15 z M 14 15 L 14 17 L 19 17 L 19 15 L 14 15 z M 7 18 L 7 20 L 12 20 L 12 18 L 7 18 z M 14 18 L 14 20 L 19 20 L 19 18 L 14 18 z M 7 21 L 7 23 L 12 23 L 12 21 L 7 21 z M 14 21 L 14 23 L 19 23 L 19 21 L 14 21 z"
          />
        </symbol>
        <symbol id="special" viewbox="0 0 32 32">
          <path
            d="M 4 4 L 4 5 L 4 27 L 4 28 L 5 28 L 27 28 L 28 28 L 28 27 L 28 5 L 28 4 L 27 4 L 5 4 L 4 4 z M 6 6 L 26 6 L 26 26 L 6 26 L 6 6 z M 16 8.40625 L 13.6875 13.59375 L 8 14.1875 L 12.3125 18 L 11.09375 23.59375 L 16 20.6875 L 20.90625 23.59375 L 19.6875 18 L 24 14.1875 L 18.3125 13.59375 L 16 8.40625 z M 16 13.3125 L 16.5 14.40625 L 17 15.5 L 18.1875 15.59375 L 19.40625 15.6875 L 18.5 16.5 L 17.59375 17.3125 L 17.8125 18.40625 L 18.09375 19.59375 L 17 19 L 16 18.40625 L 15 19 L 14 19.59375 L 14.3125 18.40625 L 14.5 17.3125 L 13.59375 16.5 L 12.6875 15.6875 L 13.90625 15.59375 L 15.09375 15.5 L 15.59375 14.40625 L 16 13.3125 z"
          />
        </symbol>
      </svg>
      <ul class="list" id="usersList">
        <a href="#" onclick="selectUser('${user.id}','${user.name}')">
          <li class="clearfix">
            <img
              src="https://source.unsplash.com/featured/face=2"
              width="40px"
              alt="avatar"
            />
            <div class="about">
              <div id="userNameAppender_${user.name}" class="name">
                ${user.name}
              </div>
              <div class="status">
                <i class="fa fa-circle offline"></i>
              </div>
            </div>
          </li>
        </a>

        <a href="#" onclick="selectUser('${user.id}','${user.name}')">
          <li class="clearfix">
            <img
              src="https://source.unsplash.com/featured/face=1"
              width="40px"
              alt="avatar"
            />
            <div class="about">
              <div id="userNameAppender_${user.name}" class="name">
                ${user.name}
              </div>
              <div class="status">
                <i class="fa fa-circle offline"></i>
              </div>
            </div>
          </li>
        </a>

        <a href="#" onclick="selectUser('${user.id}','${user.name}')">
          <li class="clearfix">
            <img
              src="https://source.unsplash.com/featured/face=3"
              width="40px"
              alt="avatar"
            />
            <div class="about">
              <div id="userNameAppender_${user.name}" class="name">
                ${user.name}
              </div>
              <div class="status">
                <i class="fa fa-circle offline"></i>
              </div>
            </div>
          </li>
        </a>

        <a href="#" onclick="selectUser('${user.id}','${user.name}')">
          <li class="clearfix">
            <img
              src="https://source.unsplash.com/featured/face=4"
             width="40px"
              alt="avatar"
            />
            <div class="about">
              <div id="userNameAppender_${user.name}" class="name">
                ${user.name}
              </div>
              <div class="status">
                <i class="fa fa-circle offline"></i>
              </div>
            </div>
          </li>
        </a>

        <a href="#" onclick="selectUser('${user.id}','${user.name}')">
          <li class="clearfix">
            <img
              src="https://source.unsplash.com/featured/face=5"
              width="40px"
              alt="avatar"
            />
            <div class="about">
              <div id="userNameAppender_${user.name}" class="name">
                ${user.name}
              </div>
              <div class="status">
                <i class="fa fa-circle offline"></i>
              </div>
            </div>
          </li>
        </a>

        <a href="#" onclick="selectUser('${user.id}','${user.name}')">
          <li class="clearfix">
            <img
              src="https://source.unsplash.com/featured/face=6"
              width="40px"
              
              alt="avatar"
            />
            <div class="about">
              <div id="userNameAppender_${user.name}" class="name">
                ${user.name}
              </div>
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
        
        <img
          alt="avatar"
          src="https://source.unsplash.com/featured/face=1"
          width="40px"
          
        />
        

        <div class="search icon"></div>
        <div class="heart icon"></div>

        <div class="chat-about">
          <div class="chat-with" id="selectedUserId"></div>
          <div class="chat-num-messages"></div>
        </div>
        <i class="fa fa-star"></i>

        
      </div>
      <div class="chat-line">

      </div>  

      
      
      <!-- end chat-header -->

      <div class="chat-history">
        <div class="overflow"></div>
        <ul></ul>
      </div>

      <div class="chat-line">

      </div> 
      <!-- end chat-history -->

      <div class="chat-message clearfix">
        <button class="special-input-btn" type="button">
          <div class="special-input-emoji">
            <svg
              aria-label="이모티콘"
              class="emoji-size"
              fill="#262626"
              height="24"
              viewBox="0 0 48 48"
              width="24"
            >
              <path
                d="M24 48C10.8 48 0 37.2 0 24S10.8 0 24 0s24 10.8 24 24-10.8 24-24 24zm0-45C12.4 3 3 12.4 3 24s9.4 21 21 21 21-9.4 21-21S35.6 3 24 3z"
              ></path>
              <path
                d="M34.9 24c0-1.4-1.1-2.5-2.5-2.5s-2.5 1.1-2.5 2.5 1.1 2.5 2.5 2.5 2.5-1.1 2.5-2.5zm-21.8 0c0-1.4 1.1-2.5 2.5-2.5s2.5 1.1 2.5 2.5-1.1 2.5-2.5 2.5-2.5-1.1-2.5-2.5zM24 37.3c-5.2 0-8-3.5-8.2-3.7-.5-.6-.4-1.6.2-2.1.6-.5 1.6-.4 2.1.2.1.1 2.1 2.5 5.8 2.5 3.7 0 5.8-2.5 5.8-2.5.5-.6 1.5-.7 2.1-.2.6.5.7 1.5.2 2.1 0 .2-2.8 3.7-8 3.7z"
              ></path>
            </svg>
          </div>
        </button>
        <button class="special-input-btn" type="button">
          <div class="special-input-emoji">
            <svg
              aria-label="사진 또는 동영상 추가"
              class="emoji-size"
              fill="#262626"
              height="24"
              viewBox="0 0 48 48"
              width="24"
            >
              <path
                d="M38.5 0h-29C4.3 0 0 4.3 0 9.5v29C0 43.7 4.3 48 9.5 48h29c5.2 0 9.5-4.3 9.5-9.5v-29C48 4.3 43.7 0 38.5 0zM45 38.5c0 3.6-2.9 6.5-6.5 6.5h-29c-3.3 0-6-2.5-6.4-5.6l8.3-8.3c.1-.1.3-.2.4-.2.1 0 .2 0 .4.2l6.3 6.3c1.4 1.4 3.6 1.4 5 0L35.9 25c.2-.2.6-.2.8 0l8.3 8.3v5.2zm0-9.4l-6.2-6.2c-1.3-1.3-3.7-1.3-5 0L21.3 35.3c-.1.1-.3.2-.4.2-.1 0-.2 0-.4-.2L14.2 29c-1.3-1.3-3.7-1.3-5 0L3 35.2V9.5C3 5.9 5.9 3 9.5 3h29C42.1 3 45 5.9 45 9.5v19.6zM11.8 8.2c-1.9 0-3.5 1.6-3.5 3.5s1.6 3.5 3.5 3.5 3.5-1.6 3.5-3.5-1.6-3.5-3.5-3.5z"
              ></path>
            </svg>
          </div>
        </button>
        <form enctype="multipart/form-data" method="POST" role="presentation">
          <input
            accept="image/jpeg,image/png"
            class="special-input-img"
            type="file"
          />
        </form>

        <textarea
          id="message-to-send"
          name="message-to-send"
          placeholder="Type your message"
          rows="3"
        >
        </textarea>

        <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
        <i class="fa fa-file-image-o"></i>

        <button id="sendBtn">Send</button>
      </div>
      <!-- end chat-message -->
    </div>
    <!-- end chat -->
  </div>
  <!-- end container -->
</template>
<script>
export default {};
</script>

<style src="../assets/css/chat.css"></style>
<style>
    
</style>