<template>

    <!-- HIDDEN PREHEADER TEXT -->
    <div style="display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;"> We're thrilled to have you here! Get ready to dive into your new account. </div>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <!-- LOGO -->
        <tr>
            <td bgcolor="#000000" align="center">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td align="center" valign="top" style="padding: 40px 10px 40px 10px;"> </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#000000" align="center" style="padding: 0px 10px 0px 10px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#ffffff" align="center" valign="top" style="padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;">
                            <h1 style="font-size: 48px; font-weight: 400; margin: 2px;">Resend Email</h1> <img src="https://img.icons8.com/clouds/100/000000/handshake.png" width="125" height="120" style="display: block; border: 0px;" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#dcdcdc" align="center" style="padding: 0px 10px 0px 10px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#ffffff" align="left" style="padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <p style="margin: 0;">Enter your data and we will resend you email </p>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ffffff" align="left">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td bgcolor="#ffffff" align="center" style="padding: 20px 30px 60px 30px;">
                                        <table border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td align="center" style="border-radius: 3px;" bgcolor="#ffffff">
                                                    <form>
                                                        <div id="Errors" class="text-danger"></div>

                                                        <div class="form-group">
                                                            <input v-model="email" type="email" bgcolor="#dcdcdc"  id="Email" placeholder="E-mail" color="#000000">
                                                            <input v-model="password" type="password" id="Password" placeholder="Password" bgcolor="#dcdcdc"  color="#000000">

                                                            <button style="margin-top: 15px;"  id="callbackSend"  class="form-control btn btn-primary submit px-3" @click="tryToResend" :disabled=store.Sending>Resend</button>
                                                            <div style="font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 12px; font-weight: 400; " align="center" id="timer">(After sending, page will be updated)</div>
                                                        </div>
                                                    </form>



                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr> <!-- COPY -->

                    <tr>
                        <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <p style="margin: 0;">If you have any questions, we're always happy to help out.</p>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <p style="margin: 0;">Cheers,<br>Triangle Team</p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#dcdcdc" align="center" style="padding: 30px 10px 0px 10px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#FFECD1" align="center" style="padding: 30px 30px 30px 30px; border-radius: 4px 4px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <h2 style="font-size: 20px; font-weight: 400; color: #111111; margin: 0;">Need more help?</h2>
                            <p style="margin: 0;"><a href="/Home/Help" target="_blank" style="color: #FFA73B;">We&rsquo;re here to help you out</a></p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

    </table>

</template>

<script>
import {useAuthStore} from "../../stores/auth";
import {ref} from "vue";

export default {
    name: "SentEmailComponent",
    setup()
    {
        const store = useAuthStore()
        const email = ref()
        const password = ref()
        const tryToResend = function () {
            console.log('Start Sending email: ' + email.value + ' ' + password.value)
            store.tryToResend(email.value, password.value)
        }
        return{
            store, email, password, tryToResend
        }
    }
}
</script>

<style scoped>
input         {
    font-size:18px;
    padding:10px 10px 10px 5px;
    display:block;
    width:300px;
    border:none;
    border-bottom:1px solid #757575;
}
/* CLIENT-SPECIFIC STYLES */
body,
table,
td,
a {
    -webkit-text-size-adjust: 100%;
    -ms-text-size-adjust: 100%;
}
table,
td {
    mso-table-lspace: 0pt;
    mso-table-rspace: 0pt;
}
img {
    -ms-interpolation-mode: bicubic;
}
/* RESET STYLES */
img {
    border: 0;
    height: auto;
    line-height: 100%;
    outline: none;
    text-decoration: none;
}
table {
    border-collapse: collapse !important;
}
body {
    height: 100% !important;
    margin: 0 !important;
    padding: 0 !important;
    width: 100% !important;
}
/* iOS BLUE LINKS */
a[x-apple-data-detectors] {
    color: inherit !important;
    text-decoration: none !important;
    font-size: inherit !important;
    font-family: inherit !important;
    font-weight: inherit !important;
    line-height: inherit !important;
}
/* MOBILE STYLES */

h1 {
    font-size: 32px !important;
    line-height: 32px !important;
}
z
    /* ANDROID CENTER FIX */
div[style*="margin: 16px 0;"] {
    margin: 0 !important;
}
</style>
