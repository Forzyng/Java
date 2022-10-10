import { defineStore } from 'pinia'
import { useAuthStore } from './auth'
import router from "../router";
import {api} from "./api";
import {useToastStore} from "./toast";

export const useUserStore = defineStore('user', {
    state: () => (
        {
            email_verified_at: '',
            description: '',
            name: '',
            user: JSON.parse(localStorage.getItem('user')) || null,
            users: [],
            total: 0, // общее количество загруженных постов
            per_page: 1, // количество постов на страницу
            page: 0, // текущая страница
            isCanMore: true,
            userLast: null,
            isLoaded: false,
            userPosts: null,
            countPosts: 0
        }),
    getters: {

    },
    actions: {
        updateUser (payload) {
            if(payload.description !== null)
            {
                this.description = payload.description
            }
            else {
                this.description = ''
            }


            this.name = payload.name

            this.rememberUser(payload)
        },
        rememberUser(user)
        {
            this.user = user
            console.log(user);
            localStorage.setItem('user', JSON.stringify(this.user))
        },
        forgetUser() {
            this.name = ''
            this.description = ''
            this.user = null
            localStorage.removeItem('user')
        },
        DeletePost(id) {
            const toast = useToastStore()
            const data = new FormData()
            data.append('id', id);

            api.post('/DeletePost', data)
                .then(res=> {
                    console.log(res)
                    // toast.success( "Loaded" )
                    if(res.token)
                    {
                        const AuthStore = useAuthStore()
                        AuthStore.rememberJwt(res.token)
                        toast.info( "Try again" )
                    }
                    if(res.error)
                    {
                        toast.error( res.error )
                    }
                    else {


                        if(res)
                        {
                                    this.userPosts = this.userPosts.filter((post) => post.id !== id);
                            this.countPosts = this.userPosts.length
                                    //this.posts.splice(this.posts.indexOf(id), 1);

                        }
                    }

                })
        },
        GoRedact()
        {
            router.push('/redact-profile')
        },
        GoMyProfile()
        {
            router.push('/my-profile')
        },
        GoCreatePost()
        {
            router.push('/create-post')
        },
        getMoreUsers(){

            const toast =useToastStore()
            if (this.page * this.per_page > this.total) {
                this.isCanMore = false
                return
            }
            this.page++
            this.isLoaded = false
            let url = '/users/?page=' + this.page + '&per_page=' + this.per_page
            console.log('get new users: ' + url)

            api.get(url)
                .then(res => {
                        if(res.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(res.token)
                            toast.info( "Try again" )
                        }
                        if(res.error)
                        {
                            toast.error(res.error)
                        }
                        else {
                            if (res) {
                                this.total = res.total
                                console.log('getData: ')
                                console.log(res.data)
                                this.users = this.users.concat(res.data)
                                this.isLoaded = true
                            }
                        }
                })
        },

        getUserByLogin(login)
        {
            this.countPosts = 0
            this.isLoaded = false
            const toast = useToastStore()
            const data = new FormData()
            data.append('login', login);

            api.post('/get-user-login', data)
                .then(res=> {
                    console.log(res)
                        if(res.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(res.token)
                            toast.info( "Try again" )
                        }
                        if(res.error)
                        {
                            toast.error(res.error)
                        }
                        else {
                            if (res) {
                                toast.success("Loaded")
                                console.log(res)
                                this.userLast = res
                                //this.isLoaded = true

                                this.getUsersPosts(this.userLast.id)
                            }
                        }
                })
        },
        getMyUser()
        {
            const toast = useToastStore()
            this.countPosts = 0
            this.isLoaded = false
           // const toast = useToastStore()
            const data = new FormData()
            data.append('login', this.user.login);

            api.post('/get-user-login', data)
                .then(res=> {
                    //toast.success( "Loaded" )
                    console.log(res)
                    //this.user = res
                    //this.isLoaded = true
                        if(res.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(res.token)
                            toast.info( "Try again" )
                        }
                        if(res.error)
                        {
                            toast.error(res.error)
                        }
                        else {
                            if (res) {
                                this.forgetUser()
                                this.updateUser(res);
                                this.getUsersPosts(this.user.id)
                            }
                        }
                })
        },
        getUsersPosts(user_id)
        {
            this.isLoaded = false
            const toast = useToastStore()
            const data = new FormData()
            data.append('user_id', user_id);

            api.post('/get-posts-id', data)
                .then(res=> {
                    console.log(res)

                        if(res.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(res.token)
                            toast.info( "Try again" )
                        }
                        if(res.error)
                        {
                            toast.error(res.error)
                        }
                        else {
                            if (res) {
                                toast.success("Loaded")
                                this.userPosts = res
                                this.isLoaded = true
                                this.countPosts = this.userPosts.length
                            }

                        }
                })
        },











         apiTryUpdatePolicyUser (newPassword, newPasswordConfirm) {

             const toast = useToastStore()
            console.log('Try to update')
            const password = newPassword
            if (password !== null) {
                    if (password.length < 6 || password.length > 35) {
                        toast.error( "Invalid Password" )
                        return false
                    }
            }
                if (newPassword !== newPasswordConfirm) {
                    toast.error( "Invalid Password Confirmation" )
                    return false
                }
             const data = new FormData()
             data.append('password', newPassword);
             data.append('password_confirmation', newPasswordConfirm);
             data.append('id', this.user.id)


            console.log('Fetch')
            fetch('http://127.0.0.1:8000/api/UpdateUserPrivacy', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    Authorization: "bearer " + localStorage.getItem('jwt')
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: data // body data type must match "Content-Type" header
            })
                .then(res => {

                        return res.json()

                })
                .then(json => {

                    console.log(json)

                    if(!json.error)
                    {
                        this.updateUser(json)
                        toast.success( "User updated" )
                    }
                    else {
                        if(json.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(json.token)
                            toast.info( "Try again" )
                        }
                        toast.error( json.error )
                    }
                    router.push('/my-profile')
                    // dispatch('nullingData')
                    // this.$router.push({ name: 'home' })
                })
                .catch(err => {
                    toast.error( err )

                })
        },
        UpdateAvatar (image) {

            const toast = useToastStore()
            console.log('Try to update')

            const data = new FormData()
            data.append("image", image);
            data.append('id', this.user.id)

            console.log('Fetch')
            fetch('http://127.0.0.1:8000/api/UpdateUser', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    Authorization: "bearer " + localStorage.getItem('jwt')
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: data // body data type must match "Content-Type" header
            })
                .then(res => {

                    return res.json()

                })
                .then(json => {

                    console.log(json)

                    if(!json.error)
                    {
                        this.updateUser(json)
                        toast.success( "User avatar updated" )
                    }
                    else {
                        if(json.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(json.token)
                            toast.info( "Try again" )
                        }

                        toast.error( json.error )
                    }
                    router.push('/my-profile')
                    // dispatch('nullingData')
                    // this.$router.push({ name: 'home' })
                })
                .catch(err => {
                    toast.error( err )

                })
        },


        tryUpdateUser (newFullname, newDescription) {
            const toast = useToastStore()
            console.log('Try to update')
            if (/\d/.test(newFullname.value)) {
                return false
            }

            if(newFullname !== undefined && newDescription !== undefined && newDescription !== '' && newFullname !== '')
            {
            const data = new FormData()
            data.append('id', this.user.id)/*
            data.append("image", image);*/
                if(newFullname !== null && newFullname !== '' && newFullname !== undefined)
                {
                    data.append('name', newFullname);
                }

                if(newDescription !== null && newDescription !== '' && newDescription !== undefined)
                {
                    data.append('description', newDescription);
                }

            console.log('Fetch')
            fetch('http://127.0.0.1:8000/api/UpdateUser', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    Authorization: "bearer " + localStorage.getItem('jwt')
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: data // body data type must match "Content-Type" header
            })
                .then(res => {
                            return res.json()
                    }
                )
                .then(json => {


                    console.log(json);
                    if(!json.error)
                    {
                        this.updateUser(json)
                        toast.success( "User updated" )
                    }
                    else {
                        if(json.token)
                        {
                            const AuthStore = useAuthStore()
                            AuthStore.rememberJwt(json.token)
                            toast.info( "Try again" )
                        }
                        toast.error( json.error )
                    }

                    router.push('/my-profile')
                    // this.$router.push({ name: 'login', query: { redirect: '/' } })
                })
                .catch(err => {
                    toast.error( err )

                    // commit('Updating', false)
                    // dispatch('nullingData')
                })

        }
            else {
                toast.info("You nothing changed")
            }
        }

    }

})
