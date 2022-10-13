import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'About',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../views/LoginPage.vue')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../views/RegisterPage.vue')
    },
    {
      path: '/redact-profile',
      name: 'RedactProfile',
      component: () => import('../views/RedactProfile.vue')
    },
    //User-Redact-Profile
    {
      path: '/posts',
      name: 'Posts',
      component: () => import('../views/PostsPage.vue')
    },
    {
      path: '/users/:login',
      name: 'User',
      component: () => import('../views/OneUserPage.vue')
    },
    {
      path: '/posts/:slug',
      name: 'Post',
      component: () => import('../views/SinglePostPage.vue')
    },
    {
      path: '/post/redact/:slug',
      name: 'RedactPost',
      component: () => import('../views/RedactPostPage.vue')
    },
    {
      path: '/create-post',
      name: 'CreatePost',
      component: () => import('../views/CreatePostPage.vue')
    },
    {
      path: '/my-profile',
      name: 'MyProfile',
      component: () => import('../views/MyProfilePage.vue')
    },
    {
      path: '/forgot-password',
      name: 'ForgotPassword',
      component: () => import('../views/ForgotPasswordPage.vue')
    },
    {
      path: '/reset-password',
      name: 'ResetPassword',
      component: () => import('../views/ResetPasswordPage.vue')
    },
    {
      path: '/resend-email',
      name: 'SentEmail',
      component: () => import('../views/SentEmailPage.vue')
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
      component: () => import('../views/PageError404.vue')
    },
  ]
})

export default router
