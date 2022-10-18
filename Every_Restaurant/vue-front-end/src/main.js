import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'



const app = createApp(App)

app.use(createPinia())
router.beforeEach((to, from, next) => {
    console.log('Before each')
    const logedStore = useUserStore()
    if (to.name === 'Login' && logedStore.user) next({ name: 'Home' })
    else if (to.name === 'RedactProfile' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'Oauth2' && logedStore.user) next({ name: 'Home' })
    else if (to.name === 'Register' && logedStore.user) next({ name: 'Home' })
    else if (to.name === 'MyProfile' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'CreatePost' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'ResetPassword' && !logedStore.user) next({ name: 'Home' })
    else if (to.name === 'RedactPost' && !logedStore.user) next({ name: 'Home' })
    else next()
})
app.use(router)
import Toaster from '@meforma/vue-toaster'
import {useUserStore} from "./stores/user";
app.use(Toaster)



app.mount('#app')
