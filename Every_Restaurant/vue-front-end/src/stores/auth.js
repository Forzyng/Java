import { defineStore } from 'pinia'
import {api} from "./api";
import {useToastStore} from "./toast";
import router from "../router";
import {useUserStore} from "./user";

export const useAuthStore = defineStore('auth', {
    state: () => ({
        jwt: localStorage.getItem('jwt') || null,
        ErrorsValidation: null,
        Sending: false
    }),
    getters: {
        isAuthenticated: state => state.jwt!==null
    },
    actions: {
        DeleteUser()
        {
            const toast = useToastStore()
            const userStore = useUserStore()
            const data = new FormData()
            data.append('id', userStore.user.id);

            api.post('/DeleteUser', data)
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
                            this.UserLogout();
                            router.push('/login')

                        }
                    }

                })
        },

        UserLogout () {
            const toast = useToastStore()
            try {
                this.forgetJwt();
                const curUser = useUserStore();
                curUser.forgetUser();
                localStorage.clear()
                console.log("Storage clear")
                toast.success("User logout")
                router.push('/login')
            }catch(err) {
                toast.error(err)
                this.Sending = false
            }
            /*
            const userStore = useUserStore()
            const data = new FormData()
            data.append('user', userStore.user);
            api.post('/auth/logout', data)
                .then(res=> {
                    console.log(res)
                    if(res.error)
                    {
                        toast.error( res.error )
                    }
                    else {


                        if(res)
                        {
                            this.forgetJwt();
                            const curUser = useUserStore();
                            curUser.forgetUser();
                            localStorage.clear()
                            console.log("Storage clear")
                            router.push('/login')

                        }
                    }

                })*/


        },
        tryLogin (email, password) {
            const toast = useToastStore()
            console.log('Try to login')
            const user = {
                email: email,
                password: password
            }
            console.log('Validating')
            this.validateLoginForm(user)
            if (this.ErrorsValidation) {
                toast.error(this.ErrorsValidation)
                return false
            }
            this.Sending = true
            console.log('Fetch')

            const data = new FormData()
            data.append('email', email);
            data.append('password', password);

            // const res = api.post('auth/login', data)
            // console.log('tryLogin res: ')
            // console.log(res)

       /*     api.post('/auth/login', data)
                .then(res=> {

                    console.log(res)
                    //toast.success( "You Logged" )
                    this.rememberJwt(res.authorisation.token)
                    const curUser = useUserStore();
                    curUser.updateUser(res.user)
                    console.log(res.user)
                    console.log(res.authorisation.token)
                    router.push('/my-profile')
                })*/

            fetch('http://127.0.0.1:8000/api/auth/login', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    //'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: data // body data type must match "Content-Type" header
            })
                .then(res => {
                    return res.json();
                })
                .then(json => {
                    console.log(json)
                    toast.success("User authorized")
                    this.Sending = false
                    this.rememberJwt(json.authorisation.token)
                    const curUser = useUserStore();
                    curUser.updateUser(json.user)
                    console.log(json.user)
                    console.log(json.authorisation.token)
                    // this.$router.push({ name: 'home' })
                    router.push('/my-profile')
                })
                .catch(err => {
                    toast.error(err)
                    this.Sending = false
                })
            //this.Sending = false
        },
        tryRegister(email, login, password, password_confirmation, registerCheck)
        {
            const toast = useToastStore()
            console.log('Try create')
            const newUser = {
                login: login,
                email: email,
                password: password,
                password_confirmation: password_confirmation,
                registerCheck: registerCheck
            }
            this.validateRegForm(newUser)
            console.log('Valid')
            if (this.ErrorsValidation) {
                toast.error(this.ErrorsValidation)
                console.log('Return false')
                return false
            }
            this.Sending = true
            console.log('Fetch')

            const data = new FormData()
            data.append('email', email);
            data.append('password', password);
            data.append('login', login);
            data.append('password_confirmation', password_confirmation);
            data.append('name', login);


            fetch('http://127.0.0.1:8000/api/auth/register', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    //'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: data // body data type must match "Content-Type" header
            })
                .then(res => {
                    return res.json();
                })
                    .then(json => {
                            console.log(json)
                            toast.success("User created")
                        if(json.authorisation.token)
                        {
                            this.rememberJwt(json.authorisation.token)
                            const curUser = useUserStore();
                            curUser.updateUser(json.user)
                            console.log(json.user)
                            console.log(json.authorisation.token)
                            router.push('/my-profile')
                        }


                        this.Sending = false
                            // this.$router.push({ name: 'home' })
                            // TODO  уйти на другой маршрут, сообщить что все хорошо
                        })
                            .catch(err => {
                                toast.error(err)
                                this.Sending = false
                            })

                        /*api.post('/auth/register', data)
                            .then(res=> {
                                //toast.success("User created")
                            })*/

        },
        validateRegForm (data) {
            this.ErrorsValidation = null
            if (data.email === null) { this.ErrorsValidation =  'Email required' }
            if (data.password === null) { this.ErrorsValidation = 'Password required' }
            if (data.login === null) { this.ErrorsValidation = 'Login required' }
            if (data.registerCheck === false) {  this.ErrorsValidation = 'You need to be agree with our privacy' }
        },
        validateLoginForm (data) {
            this.ErrorsValidation = null
            if (data.password === null ) { this.ErrorsValidation =  'Invalid Attemp' }
            if (data.login === null ) { this.ErrorsValidation =  'Invalid Attemp' }
        },
        rememberJwt(jwt) {
            this.jwt = jwt
            localStorage.setItem('jwt', jwt)
        },
        forgetJwt() {
            this.jwt = null
            localStorage.removeItem('jwt')
        },


        tryToResend(email, password)
        {
            const toast = useToastStore()
            console.log('Try to resend')
            const user = {
                email: email,
                password: password
            }
            console.log('Validating')
            this.validateLoginForm(user)
            if (this.ErrorsValidation) {
                toast.error(this.ErrorsValidation)
                return false
            }
            this.Sending = true
            console.log('Fetch')
            const data = new FormData()
            data.append('email', email);
            data.append('password', password);

            fetch('http://127.0.0.1:8000/api/email/verify/resend', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    //'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: data // body data type must match "Content-Type" header
            })
                .then(res => {
                    return res.json();
                })
                .then(json => {
                    console.log(json)
                    if(json.error)
                    {
                        toast.error( json.error )
                    }
                    else {


                        if(json)
                        {
                            toast.success(json.success)


                            router.push('/login')
                        }
                    }
                    this.Sending = false

                })
                .catch(err => {
                    toast.error(err)
                    this.Sending = false
                })
        }

    }
})
