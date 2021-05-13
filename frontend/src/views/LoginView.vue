<template>
  <form v-on:submit.prevent="submitLoginForm" action="">
    <div>
      <label for="password">ID : </label>
      <input type="text" autocomplete="off" v-model="username">
    </div>
    <div>
      <label for="password">Password</label>
      <input type="password" autocomplete="new-password" v-model="password">
    </div>
    <button type="submit">Login</button>
  </form>
</template>

<script>
import axios from '../api'
export default {
  data: function() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    submitLoginForm: function() {
      var data = {
        username: this.username,
        password: this.password,
      };
      axios.post("/login", data)
        .then(function(response) {
          if (response.status === 200) {
            location.href = "/";    
          }
          console.log(response);
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
}
</script>

<style>
</style> 