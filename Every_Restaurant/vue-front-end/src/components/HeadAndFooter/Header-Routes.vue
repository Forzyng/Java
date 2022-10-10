<template>
    <header class="pad0" style="background: #333333;">
        <div class="container_12" >

            <div class="grid_12"  >

                <div class="menu_block">
                    <nav>
                        <ul class="sf-menu">
                            <li><a href="/">Home</a> </li>
                            <div  class="dropdown"  v-if="store.isAuthenticated">
                                <button class="dropbtn">Properties</button>
                                <div class="dropdown-content">
                                    <a href="/about">About Us</a>
                                    <a href="/posts">Houses/search</a>
                                    <a href="/agents">Agents/search</a>
                                </div>
                            </div>
                            <li><a href="/login"  v-if="!store.isAuthenticated">Login Or Register</a> </li>
                            <li><a href="/my-profile"  v-if="store.isAuthenticated">Profile</a> </li>
                            <li><a href="#"  v-if="store.isAuthenticated" @click="UserLogOut">Logout</a> </li>

                        </ul>
                    </nav>
                    <div class="clear"></div>
                </div>
            </div>
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
