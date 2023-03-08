<template>
    <div v-if="!store.isLoaded">
        <!-- here put a spinner or whatever you want to indicate that a request is in progress -->
        <LoadingComponent></LoadingComponent>
    </div>
    <div class="main_bg" v-else>
        <div class="content"      >
            <div class="container_12">

                <div class="grid_8">
                    <div class="inner-block box b1">

                        <section class="slider"  v-if="store.postLast.image">
                            <div class="flexslider" style="text-align: center">
                                <a class="page3-img1 fixed-img magnifier" v-bind:href="'/storage/' + store.postLast.image">
                                <img v-bind:src="'/storage/' + store.postLast.image">
                                </a>
                            </div>
                        </section>

                        <div class="project-details">
                            <div class="port-corner-top"></div>
                            <h3>{{store.postLast.title }} <em class="fright">Price {{store.postLast.price }} $</em></h3>

                            <ul class="listbox-1">
                                <li><span>Property Type:</span><a href="#">{{store.postLast.category.name }}</a></li>
                                <li v-if="store.postLast.sale_type"><span>Sale Type:</span><a href="#">{{store.postLast.sale_type.name}}</a></li>
                                <li><span>Address:</span><a href="#">{{store.postLast.address }}</a></li>
                                <li><span>Land Area:</span><a href="#">{{store.postLast.size }} sq.ft</a></li>
                                <li><span>Year Built:</span><a href="#">{{store.postLast.year }}</a></li>
                                <li><span>Country:</span><a href="#">{{store.postLast.country }}</a></li>
                                <li><span>City:</span><a href="#">{{store.postLast.city }}</a></li>
                            </ul>


                            <h2 v-if="store.postLast.description">Property Description</h2>

                            <p v-if="store.postLast.description">{{store.postLast.description }}</p>

                            <div  v-if="store.isUserPost">
                            <ul class="list-inline m-0">
                                <li class="list-inline-item">
                                    <a style="color: white" href="#"> <button class="btn btn-success btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Edit"> Edit</button></a>
                                </li>
                                <li class="list-inline-item">
                                    <a style="color: white" href="#"> <button class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete">Delete</button></a>
                                </li>
                            </ul>
                        </div>
                            <div v-else>
                                <ul class="list-inline m-0">
                                    <li class="list-inline-item">
                                        <a href="#">Like</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="#">Comment</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="grid_4">
                    <div class="box b3">
                        <div class="agent-text ident-bot-1" style="text-align: center" >
                            <h3><a v-bind:href="'http://127.0.0.1:8000/users/' + store.postLast.author_id.login">Contact Agent</a></h3><img v-bind:href="'http://127.0.0.1:8000/users/' + store.postLast.author_id.login" v-bind:src="'/storage/' + store.postLast.author_id.avatar" alt="avatar" class="rounded-circle img-fluid">
                            <p class="agent-name">{{ store.postLast.author_id.name }}</p>
                            <a class="agent-email-link" v-bind:href="'http://127.0.0.1:8000/users/' + store.postLast.author_id.login" >{{ store.postLast.author_id.email }}</a>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</template>

<script>
//import {usePostStore} from "../../stores/posts";
import { useRouter, useRoute } from 'vue-router'
import {usePostStore} from "../../stores/posts";
import LoadingComponent from "../Loading/LoadingComponent.vue";

export default {
    name: "SinglePost",
    components: {LoadingComponent},
    setup () {
        const store = usePostStore()
        const router = useRouter()
        const route = useRoute()


        const dogetPostBySlug = function () {
            console.log('get')
            store.getPostBySlug(route.params.slug)
        }

        if(!store.isLoaded || store.isLoaded )
        {
            dogetPostBySlug()
        }

        return {
            store, dogetPostBySlug
        }
    }
}
</script>

<style scoped>

</style>
