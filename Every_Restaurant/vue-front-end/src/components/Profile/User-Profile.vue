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
              <img v-bind:src="'/storage/' + store.user.avatar" alt="avatar" class="rounded-circle img-fluid" style="width: 150px;">
              <h5 class="my-3">{{ UserLogin }}</h5>
              <p class="text-muted mb-1"> {{ UserFullName }}</p>
              <div class="d-flex justify-content-center mb-1">
                <button style="border-radius: 8px; border: 1px solid #b2b2b2" type="button" class="btn btn-outline-primary ms-1" id="Redact" @click="GoRedact">Redact Profile</button>
              </div>
            </div>
          </div>
          <div class="row"><!--
            <div class="col-md-6 mb20" style="text-align:center">
              <h5 class="text-muted mb-0">0</h5>
              <h6 class="text-small text-muted">Deals</h6>
            </div>-->
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
                  <p class="text-muted mb-0" id="CreatedAt">{{ UserCreatedAt }}</p>
                </div>
              </div>
              <hr>
              <div class="row" v-if="UserFullName">
                <div class="col-sm-3">
                  <p class="mb-0" id="UpdatedAt">Full name</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0" id="Fullname">{{ UserFullName }}</p>
                </div>
              </div>
              <hr v-if="UserFullName">
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Login</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0" id="Login">{{ UserLogin }}</p>
                </div>
              </div>
              <hr>
              <div class="row" v-if="UserDescription">
                <div class="col-sm-3">
                  <p class="mb-0">Description</p>
                </div>
                <div class="col-sm-9">

                  <p class="text-muted mb-0" id="Description">{{ UserDescription }}</p>
                </div>
              </div>
              <hr v-if="UserDescription">

            </div>
          </div>
          <!---->
          <div class="row" v-if="store.userPosts">
            <div class="col-md-12">
              <div class="card mb-4 mb-md-0">
                <div class="card-body" >
                    <div class="d-flex justify-content-center mb-1">
                        <button style="border-radius: 8px; border: 1px solid #b2b2b2" type="button" class="btn btn-outline-primary ms-1" id="Redact" @click="CreatePost">Create Post</button>
                    </div>
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
                                    <div>
                                        <ul class="list-inline m-0">
                                            <li class="list-inline-item">
                                                <a style="color: white" v-bind:href="'http://127.0.0.1:8000/post/redact/' + post.slug"> <button class="btn btn-success btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Edit"> Edit</button></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a style="color: white" href="#"> <button @click="doDelete(post.id)" class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete">Delete</button></a>
                                            </li>
                                        </ul>
                                    </div>

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

import {useUserStore} from "../../store/user";
import LoadingComponent from "../Loading/LoadingComponent";
export default {
  name: 'User-Profile',
    components: {LoadingComponent},
    setup () {

        const store = useUserStore()
        const UserLogin = store.user.login
        const UserEmail = store.user.email
        const UserDescription = store.user.description
        const UserCreatedAt = store.user.created_at
        const UserFullName = store.user.name


        const GoRedact = function () {
            console.log('redact')
            store.GoRedact()
        }

        const CreatePost = function () {
            console.log('create')
            store.GoCreatePost()
        }


///////////////////////////////////////////////////////

        const dogetMyUser = function () {
            console.log('get')
            store.getMyUser()
        }

        if(!store.isLoaded || store.isLoaded )
        {
            dogetMyUser()
        }

        const doDelete = function (id){
            store.DeletePost(id)
        }
////////////////////////////////////////////////////////

        return {
            GoRedact, UserLogin, UserEmail, UserDescription, UserCreatedAt, UserFullName, dogetMyUser, store, CreatePost, doDelete
        }
    }
}
</script>

<style scoped>

</style>
