<template>
  <div class="header-nav">
    <router-link class="header-nav__logo" to="/">  
      <img alt="Logo" src="../assets/image/logo.png" class="header-nav__logo-img">
    </router-link>
    <div class="header-nav__items">
      <router-link to="/login" class="header-nav__item">Sign in</router-link>
      <router-link to="/join" class="header-nav__item">Sign up</router-link>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.header-nav {
  padding: 10px 20px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.header-nav__logo {
  height: 40px;
  width: 40px;
}
.header-nav__logo-img {
  height: 100%;
  object-fit: contain;
}
.header-nav__item {
  margin-right: 10px;
}
.header-nav__item:last-child {
  margin-right: 0;
}
</style> 