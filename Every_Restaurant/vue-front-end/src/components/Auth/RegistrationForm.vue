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
              <input type="email" id="email_reg" class="form-control form-control-lg"  v-model="email"/>
              <label class="form-label" for="email_reg">Email address</label>
            </div>

            <div class="form-outline mb-4">
              <input type="text" id="login" class="form-control form-control-lg" v-model="login"/>
              <label class="form-label" for="login" >Login</label>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <input type="password" id="form1Example23" class="form-control form-control-lg" v-model="password"/>
              <label class="form-label" for="form1Example23"  >Password</label>
            </div>

            <div class="d-flex justify-content-around align-items-center mb-4">
              <!-- Checkbox -->
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="checkAgreement" v-model="registerCheck"/>
                <label class="form-check-label" for="checkAgreement"> I agree all statements in <a href="#">Terms of service</a> </label>
              </div>
            </div>

            <!-- Submit button -->

            <button style="text-align: center;  width: 100%" type="button" class="btn btn-primary btn-lg btn-block" @click="tryCreateUser" :disabled=canSendForm>Sign up</button>

            <div class="divider d-flex align-items-center my-4">
              <p class="text-center fw-bold mx-3 mb-0 text-muted mx-auto">OR</p>
            </div>

            <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998; text-align: center; width: 100%" v-bind:href="FACEBOOK_AUTH_URL"
               role="button">
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
import {useAuthStore} from "../../stores/auth";
import {ref} from "vue";

export default {
  name: "RegistrationForm",
  setup() {

    const API_BASE_URL = 'http://localhost:8080';
    const OAUTH2_REDIRECT_URI = 'http://127.0.0.1:5173/oauth2/redirect'; //const OAUTH2_REDIRECT_URI = 'http://127.0.0.1:5173/oauth2/redirect' /oauth2/redirect

    const GOOGLE_AUTH_URL = API_BASE_URL + '/oauth2/authorize/google?redirect_uri=' + OAUTH2_REDIRECT_URI;
    const FACEBOOK_AUTH_URL = API_BASE_URL + '/oauth2/authorize/facebook?redirect_uri=' + OAUTH2_REDIRECT_URI;


    const store = useAuthStore()

    const canSendForm = store.Sending

     const login = ref()
     const email = ref()
     const password = ref()
     const registerCheck = ref()

     const tryCreateUser = function () {
       console.log('Start Creating: ')
       store.tryRegister(email.value, login.value, password.value, registerCheck.value)
     }

    return {
       tryCreateUser,canSendForm,
       login,
       email,
       password,
       registerCheck,
      GOOGLE_AUTH_URL,
      FACEBOOK_AUTH_URL
    }
  }
}
</script>

<style scoped>

</style>