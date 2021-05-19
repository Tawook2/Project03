import Vue from "vue"
import VueRouter from "vue-router"
import MainView from "../views/MainView.vue"
import LoginView from "../views/LoginView.vue"
import ChatTest from "../views/ChatTest.vue"
import ChatView from "../views/ChatView.vue"


Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    routes: [
        { path: "/", component: MainView },
        { path: "/login", component: LoginView },
        { path: "/chattest", component: ChatTest},
        { path: "/chat", component: ChatView},
    ]
})

export default router