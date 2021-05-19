import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueMaterial from 'vue-material'




import io from 'socket.io-client';
import jQuery from 'jquery'

window.jQuery = jQuery
window.$ = jQuery

const socket = io('http://localhost:8080');



Vue.prototype.$socket = socket;

Vue.use(VueMaterial)




Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
