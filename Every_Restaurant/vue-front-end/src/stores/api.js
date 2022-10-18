// import { defineStore } from 'pinia'
import {useToastStore} from "./toast";
import {useAuthStore} from "./auth";

const serverUrl = 'http://localhost:8080'

export const api = {

    get(url, options = {}) {

        // В любой запрос нужно добавить JWT
        // А тут перед запросом можно еще и проверить
        // Если он устарел - можно и обновить
        options.headers = {}
        const auth = useAuthStore()
        console.log("check")
        if (auth.jwt !== null)
        {
            options.headers['Authorization'] = 'Bearer ' + auth.jwt
            console.log(auth.jwt)
        }

        return new Promise((resolve, reject) => {

            fetch(serverUrl + url, options)
                .then(res => {
                    return res.json()
                })
                .then(json => {
                    resolve( json)
                })
                .catch(err => {
                    const toast = useToastStore()
                    toast.error(err)
                    reject(err)
                })
        })
    },

    // post (url, data, options = {}){
    //     console.log('Send post data')
    //     console.log(data)
    //     options.method = 'POST'
    //     options.body = data
    //     fetch(serverUrl + url, options)
    //         .then(res=> {
    //             return res.json()
    //         })
    //         .then(json => {
    //             return json
    //         })
    //         .catch(err => {
    //             const toast = useToastStore()
    //             toast.error(err)
    //         })
    // }

    async post (url, data, options = {}) {

        console.log('Send post data')
        console.log(data)

        options.method = 'POST'
        options.body = data

        // В любой запрос нужно добавить JWT
        // А тут перед запросом можно еще и проверить
        // Если он устарел - можно и обновить
        options.headers = {}
        const auth = useAuthStore()
        console.log("check")
        if (auth.jwt !== null)
        {
            options.headers['Authorization'] = 'bearer ' + auth.jwt
            console.log(auth.jwt)
        }
        console.log("promise")

        return new Promise((resolve, reject) => {
            fetch(serverUrl + url, options)
                .then(res=> res.json())
                .then(json=> resolve(json))
                .catch(err=> {
                    const toast = useToastStore()
                    toast.error(err)
                    reject(err)
                })
        })
    }
}




/*
// Пример отправки POST запроса:
async function postData(url = '', data = {}) {
  // Default options are marked with *
  const response = await fetch(url, {
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
  });
  return await response.json(); // parses JSON response into native JavaScript objects
}
postData('https://example.com/answer', { answer: 42 })
  .then((data) => {
    console.log(data); // JSON data parsed by `response.json()` call
  });
 */
