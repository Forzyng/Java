import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../views/LoginPage')
    },
    {
      path: '/redact-profile',
      name: 'RedactProfile',
      component: () => import('../views/RedactProfile')
    },
    //User-Redact-Profile
    {
      path: '/posts',
      name: 'Posts',
      component: () => import('../views/PostsPage')
    },
    {
      path: '/users/:login',
      name: 'User',
      component: () => import('../views/OneUserPage')
    },
    {
      path: '/posts/:slug',
      name: 'Post',
      component: () => import('../views/SinglePostPage')
    },
    {
      path: '/post/redact/:slug',
      name: 'RedactPost',
      component: () => import('../views/RedactPostPage')
    },
    {
      path: '/create-post',
      name: 'CreatePost',
      component: () => import('../views/CreatePostPage')
    },
    {
      path: '/agents',
      name: 'Agents',
      component: () => import('../views/AgentsPage')
    },
    {
      path: '/my-profile',
      name: 'MyProfile',
      component: () => import('../views/MyProfilePage')
    },
    {
      path: '/success-operation/:number',
      name: 'SuccessPage',
      component: () => import('../views/SuccessPage')
    },
    {
      path: '/forgot-password',
      name: 'ForgotPassword',
      component: () => import('../views/ForgotPasswordPage')
    },
    {
      path: '/reset-password',
      name: 'ResetPassword',
      component: () => import('../views/ResetPasswordPage')
    },
    {
      path: '/resend-email',
      name: 'SentEmail',
      component: () => import('../views/SentEmailPage')
    },
    //http://127.0.0.1:8000/email/verify/already-success
    /*    {
            path: '/email/verify/:user_id/:hash',
            name: 'emailVerify',
            component: () => import('../pages/EmailVerifyPage')
        },*/
    {
      path: '/:pathMatch(.*)*',
      name: 'Error404',
      component: () => import('../views/PageError404')
    },
  ]
})

export default router
