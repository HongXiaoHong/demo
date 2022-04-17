import Vue from 'vue'
import VueRouter, {RouteConfig} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TodoView from "@/views/TodoView.vue";
import TestView from "@/views/TestView.vue";

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
    {
        path: '/',
        name: 'home',
        component: HomeView
    },
    {
        path: '/todo',
        name: 'todo',
        component: TodoView
    },
    {
        path: '/test',
        name: 'test',
        component: TestView
    },
    {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
