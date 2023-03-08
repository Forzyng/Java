<template>
    <div v-if="!store.isLoaded">
        <!-- here put a spinner or whatever you want to indicate that a request is in progress -->
        <LoadingComponent></LoadingComponent>
    </div>
    <div v-else>
    <section style="background-color: #ebebeb;">
        <div class="container py-5">

            <div class="row">
                <div class="col-lg-4">
                    <div class="card mb-4">
                        <div class="card-body text-center">
                            <img v-bind:src="'/storage/' + store.userLast.avatar" alt="avatar" class="rounded-circle img-fluid" style="width: 150px;">
                            <h5 class="my-3">{{ store.userLast.login }}</h5>
                            <p class="text-muted mb-1"> {{ store.userLast.name }}</p>
                            <div class="d-flex justify-content-center mb-1">
                                <button style="border-radius: 8px; border: 1px solid #b2b2b2" type="button" class="btn btn-outline-primary ms-1" id="Redact" >Send Message</button>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 mb20" style="text-align:center">
                            <h5 class="text-muted mb-0">{{ store.countPosts }} Posts</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Here from</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0" id="CreatedAt">{{ store.userLast.created_at }}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row" v-if="store.userLast.name">
                                <div class="col-sm-3">
                                    <p class="mb-0" id="UpdatedAt">Full name</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0" id="Fullname">{{ store.userLast.name }}</p>
                                </div>
                            </div>
                            <hr v-if="store.userLast.login">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Login</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0" id="Login">{{ store.userLast.login }}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row" v-if="store.userLast.description">
                                <div class="col-sm-3">
                                    <p class="mb-0">Description</p>
                                </div>
                                <div class="col-sm-9">

                                    <p class="text-muted mb-0" id="Description">{{ store.userLast.description }}</p>
                                </div>
                            </div>
                            <hr v-if="store.userLast.description">

                        </div>
                    </div>
                    <!---->
                    <div class="row" v-if="store.userPosts">
                        <div class="col-md-12">
                            <div class="card mb-4 mb-md-0">
                                <div class="card-body" >

                                    <ul  id="stage"      v-for="post in store.userPosts">
                                        <li class="grid_6 p8" v-bind:data-id="'id-' + post.id">
                                            <div class="inner-block box b1"> <a class="page3-img1 fixed-img magnifier"  v-bind:href="'http://127.0.0.1:8000/posts/' + post.slug" ><img  v-bind:src="'/storage/' + post.image" alt=""><span></span></a>
                                                <div class="port-title">
                                                    <div class="port-corner-top"></div>
                                                    <h2><a v-bind:href="'http://127.0.0.1:8000/posts/' + post.slug">{{post.title}}</a></h2>
                                                    <ul class="listbox-1">
                                                        <li><span>Property Type:</span><a href="#" v-text="post.category.name"></a></li>
                                                        <li v-if="post.sale_type"><span>Sale Type:</span><a href="#">{{post.sale_type.name}}</a></li>
                                                        <li><span>Address:</span><a href="#">{{post.address}}</a></li>
                                                        <li><span>Year Built:</span><a href="#">{{post.year}}</a></li>
                                                        <li><span>Building Size (sq ft):</span><a href="#">{{post.size}} </a></li>
                                                        <li><span>Country:</span><a href="#">{{post.country}} </a></li>
                                                        <li><span>City:</span><a href="#">{{post.city}} </a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>


                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </section>
    </div>
</template>

<script>
import {useUserStore} from "../../stores/user";
import { useRouter, useRoute } from 'vue-router'
import LoadingComponent from "../Loading/LoadingComponent.vue";

export default {
    name: "OneUserProfile",
    components: {LoadingComponent},
    setup () {
        const store = useUserStore()
        const router = useRouter()
        const route = useRoute()

        const doPushProfile = function() {
            store.GoMyProfile()
        }

        const dogetUserByLogin = function () {
            console.log('get')
            store.getUserByLogin(route.params.login)
        }

        if(store.user.login === route.params.login)
        {
            doPushProfile()
        }
        else {
            if(!store.isLoaded || store.isLoaded )
            {
                dogetUserByLogin()
            }
        }

        return {
            store, dogetUserByLogin, doPushProfile
        }
    }
}
</script>

<style scoped>

</style>
