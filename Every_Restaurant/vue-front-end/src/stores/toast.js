import { defineStore } from 'pinia'
import { createToaster } from "@meforma/vue-toaster"
const toast = createToaster({
    /* options */
})

export const useToastStore = defineStore('toast', {
    actions: {
        error: (msg) =>{
            console.log("error: ")
            console.log(msg)
            toast.error(msg)
        },
        success: (msg) =>{
            console.log("success: ")
            console.log(msg)
            toast.success(msg)
        },
        info: (msg) =>{
            console.log("info: ")
            console.log(msg)
            toast.info(msg)
        },
        warning: (msg) =>{
            console.log("warning: ")
            console.log(msg)
            toast.info(msg)
        },
        show: (msg) =>{
            console.log("show: ")
            console.log(msg)
            toast.info(msg)
        },

    }
})
