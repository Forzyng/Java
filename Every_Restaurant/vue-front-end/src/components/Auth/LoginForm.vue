<template>
  <section class="vh-100">
    <div class="container py-5 h-100">
      <div class="row d-flex align-items-center justify-content-center h-100">
        <div class="col-md-8 col-lg-7 col-xl-6">
          <img src="/inbox.jpg"
               class="img-fluid" alt="Phone image">
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <form>
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input type="email" id="email_log" class="form-control form-control-lg" />
              <label class="form-label" for="email_log">Email address</label>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <input type="password" id="password_log" class="form-control form-control-lg" />
              <label class="form-label" for="password_log">Password</label>
            </div>

            <div class="d-flex justify-content-around align-items-center mb-4">
              <!-- Checkbox -->
<!--              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="checkRemember" checked />
                <label class="form-check-label" for="checkRemember"> Remember me </label>
              </div>-->
              <a href="#!">Haven`t received email confirmation?</a>
              <a href="#!">Forgot password?</a>
            </div>

            <!-- Submit button -->

            <button style="text-align: center;  width: 100%" type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>

            <div class="divider d-flex align-items-center my-4">
              <p class="text-center fw-bold mx-3 mb-0 text-muted mx-auto">OR</p>
            </div>

            <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998; text-align: center; width: 100%" v-bind:href="FACEBOOK_AUTH_URL"
               role="button" >
              <i class="fa fa-facebook"></i> Continue with Facebook
            </a>
            <a class="btn btn-primary btn-lg btn-block" style="background-color: #55acee; text-align: center; width: 100%" v-bind:href="GOOGLE_AUTH_URL"
               role="button">
              <i class="fa fa-google"></i> Continue with Google</a>

          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>

import {useAuthStore} from "../../stores/auth.js";

export default {
  name: "LoginForm",
  setup() {

     const API_BASE_URL = 'http://localhost:8080';
     const OAUTH2_REDIRECT_URI = 'http://127.0.0.1:5173/oauth2/redirect'; //const OAUTH2_REDIRECT_URI = 'http://127.0.0.1:5173/oauth2/redirect' /oauth2/redirect

     const GOOGLE_AUTH_URL = API_BASE_URL + '/oauth2/authorize/google?redirect_uri=' + OAUTH2_REDIRECT_URI;
     const FACEBOOK_AUTH_URL = API_BASE_URL + '/oauth2/authorize/facebook?redirect_uri=' + OAUTH2_REDIRECT_URI;


   /* const store = useAuthStore()
    const emailForLogin = ref()
    const passwordForLogin = ref()
    const tryLogin = function () {
      console.log('Start Login: ' + emailForLogin.value + ' ' + passwordForLogin.value)
      store.tryLogin(emailForLogin.value, passwordForLogin.value)
    }
    const canSendForm = store.Sending
    const canSendLoginForm = store.Sending

    const login = ref()
    const email = ref()
    const password = ref()
    const password_confirmation = ref()
    const registerCheck = ref()

    const tryCreateUser = function () {
      console.log('Start Creating: ')
      store.tryRegister(email.value, login.value, password.value, password_confirmation.value, registerCheck.value)
    }
*/
    return {
      /*emailForLogin,
      passwordForLogin,
      tryLogin,
      canSendForm,
      canSendLoginForm,
      tryCreateUser,
      login,
      email,
      password,
      password_confirmation,
      registerCheck,*/
      GOOGLE_AUTH_URL,
      FACEBOOK_AUTH_URL
    }
  }
}
</script>

<style scoped>

</style>