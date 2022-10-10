import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import Toaster from '@meforma/vue-toaster'

import './assets/main.css'

const app = createApp(App)

const pinia = createPinia()
app.use(pinia)

app.use(router)
    .use(Toaster)
    .mount('#app')

router.beforeEach((to, from, next) => {
    console.log('Before each')
    const logedStore = useUserStore()
    if (to.name === 'Login' && logedStore.user) next({ name: 'Home' })
    else if (to.name === 'RedactProfile' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'MyProfile' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'Post' && !logedStore.user) next({ name: 'Home' })  //CreatePost
    else if (to.name === 'User' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'CreatePost' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'RedactPost' && !logedStore.user) next({ name: 'Home' })
    else next()
})



/*
import BootstrapVue3 from 'bootstrap-vue-3'
import VueToast from 'vue-toast-notification'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import 'vue-toast-notification/dist/theme-sugar.css'

app.use(createPinia())
    .use(router)
    .use(BootstrapVue3)
    .use(VueToast)
    .mount('#app')

router.beforeEach((to, from, next) => {
    const isLogged = !!store.getters.user
    if (to.name === 'login' && isLogged) return false
    else if (to.name === 'redactprofile' && !isLogged) return false
    else if (to.name === 'myprofile' && !isLogged) return false
    else next()
})*/
