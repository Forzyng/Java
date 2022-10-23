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

            api.get('/delete-user')
                .then(res=> {
                    console.log(res)
                    if(res.error)
                    {
                        toast.error( res.message )
                    }
                    else {
                        if(res)
                        {
                            this.UserLogout();
                            //router.push('/login')
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



        },tryAuth () {
            const toast = useToastStore()
            console.log('Try to auth')

            api.get("/user/me")
                .then(res => {
                    if(res.error)
                    {
                        toast.error(res.error)
                    }
                    else {
                        if (res) {
                            console.log('getData: ')
                            console.log(res)
                            const curUser = useUserStore();
                            curUser.updateUser(res)
                            console.log(res)
                            router.push('/my-profile')
                        }
                    }

                })
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

            const data = { email: email, password: password };

            console.log(data)
            /*const data = new FormData()
            data.append('email', email);
            data.append('password', password);*/

            fetch('http://localhost:8080/auth/login', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: JSON.stringify(data) // body data type must match "Content-Type" header
            })
                .then(res => {
                    return res.json();
                })
                .then(json => {
                    if(json.error )
                    {
                        console.log(json.message)
                        this.Sending = false
                    }
                    else {
                        console.log(json)
                        toast.success("User authorized")
                        this.Sending = false
                        this.rememberJwt(json.accessToken)
                        this.tryAuth()
                    }

                })
                .catch(err => {
                    toast.error(err)
                    this.Sending = false
                })
            //this.Sending = false
        },
        tryRegister(email, login, password, registerCheck)
        {
            const toast = useToastStore()
            console.log('Try create')
            const newUser = {
                login: login,
                email: email,
                password: password,
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

            const data = { email: email, password: password, login: login };

            console.log(data)
            /*const data = new FormData()
            data.append('email', email);
            data.append('password', password);
            data.append('login', login);*/


            fetch('http://localhost:8080/auth/register', {
                method: 'POST', // *GET, POST, PUT, DELETE, etc.
                mode: 'cors', // no-cors, *cors, same-origin
                cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                credentials: 'same-origin', // include, *same-origin, omit
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                redirect: 'follow', // manual, *follow, error
                referrerPolicy: 'no-referrer', // no-referrer, *client
                body: JSON.stringify(data) // body data type must match "Content-Type" header
            })
                .then(res => {
                    return res.json();
                })
                    .then(json => {
                        if(json.error )
                        {
                            console.log(json)
                            toast.error(json.message)
                        }
                        else {
                            if(json)
                            {
                                console.log(json)
                                toast.success(json.message)
                            }
                            else
                            {
                                toast.info("Smth went wrong")
                            }
                        }
                        this.Sending = false
                            // this.$router.push({ name: 'home' })
                        })
                            .catch(err => {
                                toast.error(err)
                                this.Sending = false
                            })



        },
        validateRegForm (data) {
            this.ErrorsValidation = null
            if (data.email === null || data.email === '' || data.password === undefined) { this.ErrorsValidation =  'Email required' }
            if (data.password === null || data.password === '' || data.password === undefined) { this.ErrorsValidation = 'Password required' }
            if (data.login === null || data.login === '' || data.login === undefined) { this.ErrorsValidation = 'Login required' }
            if (data.registerCheck !== true ) {  this.ErrorsValidation = 'You need to be agree with our privacy' }
        },
        validateLoginForm (data) {
            this.ErrorsValidation = null
            if (data.password === null || data.password === '' || data.password === undefined ) { this.ErrorsValidation =  'Invalid Attemp' }
            if (data.email === null || data.email === '' || data.email === undefined ) { this.ErrorsValidation =  'Invalid Attemp' }
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
