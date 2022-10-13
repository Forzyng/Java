<template>
  <header class="header-section-other">
    <div class="container-fluid">
      <div class="logo">
        <a href="/"><img src="/img/Every_logo.png" alt=""></a>
      </div>
      <div class="nav-menu">
        <nav class="main-menu mobile-menu">
          <ul>
            <li><a href="/">Home</a></li>
            <li><a href="#">Pages</a>
              <ul class="sub-menu">
                <li><a href="/about">About</a></li>
                <li><a href="/categories">Categories</a></li>
                <li><a href="/recipes">Recipes</a></li>
                <li><a href="/posts">Posts</a></li>
                <li><a href="/recommendations">Best Of</a></li>
              </ul>
            </li>
            <li v-if="store.isAuthenticated"><a href="#">Profile</a>
              <ul class="sub-menu">
                <li v-if="store.isAuthenticated"><a href="/my-profile">My Profile</a></li>
                <li v-if="store.isAuthenticated"><a href="/my-liked" >My liked</a></li>
                <li v-if="store.isAuthenticated"><a href="/my-bookmarked">Saved</a></li>
                <li v-if="store.isAuthenticated"><a href="/notifications">Notifications</a></li>
                <li v-if="store.isAuthenticated"><a href="/messenger" >Messenger</a></li>
              </ul>
            </li>
            <li v-if="!store.isAuthenticated"><a href="/login" >Login</a></li>
            <li v-if="!store.isAuthenticated"><a href="/register">Register</a></li>
            <li v-if="store.isAuthenticated"><a href="/register"  @click="UserLogOut">Logout>Register</a></li>

          </ul>
        </nav>
        <div class="nav-right search-switch">
          <i class="fa fa-search"></i>
        </div>
      </div>
      <div id="mobile-menu-wrap"></div>
    </div>
  </header>
</template>

<script>

import {useAuthStore} from "../../stores/auth";

export default {
  name: 'Header-Routes',
  setup () {
      const store = useAuthStore()

      const UserLogOut = function () {
          console.log('logout')
          store.UserLogout()
      }

      return {
          store, UserLogOut, //UserLogin
      }
  }
}
</script>

<style scoped>
/* Style The Dropdown Button */
.dropbtn {
    background-color: #333333;
    color: white;
    padding: 18px;
    font-size: 14px;
    border: none;
    cursor: pointer;
    font-family: 'Open Sans', sans-serif;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
/*.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}*/
</style>
