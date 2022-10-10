import { defineStore } from 'pinia'
import {api} from './api'
import {useToastStore} from "./toast";
import {useUserStore} from "./user";
import router from "../router";
import {useAuthStore} from "./auth";

export const usePostStore = defineStore('post', {
    state: () => ({
        posts: [],
        total: 0, // общее количество загруженных постов
        per_page: 2, // количество постов на страницу
        page: 0, // текущая страница
        isCanMore: true,
        postLast: null,
        isLoaded: false,
        isUserPost: false,
        Categories: null,
        SaleTypes: null
    }),
    getters: {
    },
    actions: {

        GetCategories()
        {
            const toast = useToastStore()
            //get-categories
            api.get("/get-categories")
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
                                console.log('getData: ')
                                console.log(res)
                                this.Categories = res
                                this.isLoaded = true;
                            }
                        }

                })
        },
        GetSaleTypes()
        {
            const toast = useToastStore()
            console.log("check before")
            this.isLoaded = false;
            //get-sale-types
            api.get("/get-sale-types")
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


                    if(res)
                    {
                        console.log('getData: ')
                        console.log(res)
                        this.SaleTypes = res
                        this.GetCategories()
                    }
                }

                })

        },
        CreatePost(title, body, price, address, size, year, country, city, number_categ, toBeConfirmed, number_sale, image)
        {
                const toast = useToastStore()
                const data = new FormData()

            if(title !== undefined && body !== undefined &&price !== undefined &&address !== undefined &&size !== undefined &&year !== undefined &&country !== undefined &&city !== undefined &&number_categ !== undefined  &&number_sale !== undefined &&image !== undefined && image!== null) {
                if (title !== '' && body !== '' && price !== '' && address !== '' && size !== '' && year !== '' && country !== '' && city !== '' && number_categ !== ''&& number_sale !== '' && image !== '' && image !== null) {
if(price > 0 && size > 1 && year > 1800)
{



    if(toBeConfirmed)
    {
        if (toBeConfirmed === true) {
            data.append('toBeConfirmed', toBeConfirmed);
        }
    }


                    data.append('title', title);
                    data.append('body', body);
                    data.append('price', price);
                    data.append('address', address);
                    data.append('size', size);
                    data.append('year', year);
                    data.append('country', country);
                    data.append('city', city);
                    data.append('category_id', number_categ);
                    data.append('sale_type_id', number_sale);
                    data.append('file', image);

                    /*    console.log(title)
                    console.log(body)

                    console.log(size)
                    console.log(address)
                    console.log(price)
                    console.log(number_categ)
                    console.log(number_sale)*/


                    api.post('/create-post', data)
                        .then(res => {
                            console.log(res)
                            // toast.success( "Loaded" )
                            if (res) {
                                console.log(res)

                                if (!res.error) {
                                    toast.success("Post created")

                                } else {
                                    if (res.token) {
                                        const AuthStore = useAuthStore()
                                        AuthStore.rememberJwt(res.token)
                                        toast.info("Try again")
                                    }
                                    toast.error(res.error)
                                }
                                router.push('/my-profile')
                            }

                        })
}
else {
    toast.info("False data")
}
                } else {
                    toast.info("Everything required")

                }
            }else {
                toast.info("Everything required")
            }


        },

        RedactPost( body, price, address, size, year, country, city, number_categ, toBeConfirmed, number_sale, image)
        {
            const toast = useToastStore()
            const data = new FormData()

            if(body !== undefined &&price !== undefined &&address !== undefined &&size !== undefined &&year !== undefined &&country !== undefined &&city !== undefined &&number_categ !== undefined  &&number_sale !== undefined ) {
                if (body !== '' && price !== '' && address !== '' && size !== '' && year !== '' && country !== '' && city !== '' && number_categ !== '' && number_sale !== '' ) {
                    if(price > 0 && size > 1 && year > 1800)
                    {



                        if(toBeConfirmed)
                        {
                            if (toBeConfirmed === true) {
                                data.append('toBeConfirmed', toBeConfirmed);
                            }
                        }
                        data.append('body', body);
                        data.append('price', price);
                        data.append('address', address);
                        data.append('size', size);
                        data.append('year', year);
                        data.append('country', country);
                        data.append('city', city);
                        data.append('category_id', number_categ);
                        data.append('sale_type_id', number_sale);
                        data.append('post_id', this.postLast.id);

                        if (image) {
                            data.append('file', image);
                        }


                        /*    console.log(title)
                        console.log(body)

                        console.log(size)
                        console.log(address)
                        console.log(price)
                        console.log(number_categ)
                        console.log(number_sale)*/


                        api.post('/UpdatePost', data)
                            .then(res => {
                                console.log(res)
                                // toast.success( "Loaded" )
                                if (res) {
                                    console.log(res)

                                    if (!res.error) {
                                        toast.success("Post updated")

                                    } else {
                                        if (res.token) {
                                            const AuthStore = useAuthStore()
                                            AuthStore.rememberJwt(res.token)
                                            toast.info("Try again")
                                        }
                                        toast.error(res.error)
                                    }
                                    router.push('/my-profile')
                                }

                            })
                    }
                    else {
                        toast.info("False data")
                    }
                } else {
                    toast.info("Everything required")

                }
            }else {
                toast.info("Everything required")
            }

        },
        getPostBySlug(slug, isRedact)
        {
            this.isUserPost = false
            this.isLoaded = false
            const toast = useToastStore()
            const data = new FormData()
            data.append('slug', slug);

            api.post('/get-post-slug', data)
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

                            this.postLast = res
                            this.isLoaded = true

                            const userStore = useUserStore()

                            if(isRedact) {
                                if (isRedact === true) {
                                    if (this.postLast.author_id.id === userStore.user.id) {
                                        this.isUserPost = true
                                    } else {
                                        router.push('/home')
                                    }
                                }
                            }
                            else {
                                if (this.postLast.author_id.id === userStore.user.id) {
                                    this.isUserPost = true
                                }
                            }
                            if(!this.postLast.image.includes("-medium.jpg") && !this.postLast.image.includes("-medium.jpeg") && !this.postLast.image.includes("-medium.png") && !this.postLast.image.includes("-medium.webp"))
                            {
                                this.postLast.image = this.postLast.image.replace(".jpg", "-medium.jpg");
                                this.postLast.image = this.postLast.image.replace(".jpeg", "-medium.jpeg");
                                this.postLast.image = this.postLast.image.replace(".png", "-medium.png");
                                this.postLast.image = this.postLast.image.replace(".webp", "-medium.webp");
                            }
                        }
                }

                })
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
                                router.push('/my-profile')

                        }
                    }

                })
        },
        // Получить посты
        getMorePosts(){

            console.log("Get post")
            if (this.page * this.per_page > this.total) {
                this.isCanMore = false
                return
            }
            this.page++
            this.isLoaded = false;
            let url = '/offers/?page=' + this.page + '&per_page=' + this.per_page
            console.log('get new posts: ' + url)

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
                        toast.error( res.error )
                    }
                    else {
                        if (res) {
                            this.total = res.total
                            console.log('getData: ')
                            console.log(res.data)
                            this.posts = this.posts.concat(res.data)

                            this.posts.forEach((value, index) => {
                                if (!value.image.includes("-medium.jpg") && !value.image.includes("-medium.jpeg") && !value.image.includes("-medium.png") && !value.image.includes("-medium.webp")) {
                                    value.image = value.image.replace(".jpg", "-medium.jpg");
                                    value.image = value.image.replace(".jpeg", "-medium.jpeg");
                                    value.image = value.image.replace(".png", "-medium.png");
                                    value.image = value.image.replace(".webp", "-medium.webp");
                                }
                                console.log(value);
                                console.log(index);
                            });
                            this.isLoaded = true;
                        }
                    }


                })
        },

        getLatestPosts()
        {

        }
    }
})
