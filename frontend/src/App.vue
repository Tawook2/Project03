<template>
  <div id="app">
    
    <HeaderNav></HeaderNav>
    <router-view></router-view>

     
  </div>
</template>

<script>
import HeaderNav from './components/HeaderNav.vue'




export default {
  name: 'App',
  components: {
    HeaderNav,

  },

}
</script>

<style src="./assets/css/reset.css"></style>

<style>
</style>
