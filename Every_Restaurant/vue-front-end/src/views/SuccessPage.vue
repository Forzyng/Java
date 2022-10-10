<template>
  <div v-if="checker">
      <div v-if="id === '1'">
          <EmailConfirmed></EmailConfirmed>
      </div>
      <div v-if="id === '2'">
          <PasswordChanged></PasswordChanged>
      </div>
      <div v-if="id === '3'">
          <AlreadyConfirmed></AlreadyConfirmed>
      </div>
  </div>
    <div>

    </div>
</template>

<script>
import {useUserStore} from "../store/user";
import {useRoute, useRouter} from "vue-router/dist/vue-router";
import PasswordChanged from "../components/ForgotPassowd/PasswordChanged";
import EmailConfirmed from "../components/EmailConfirmation/EmailConfirmed";
import AlreadyConfirmed from "../components/EmailConfirmation/AlreadyConfirmed";

export default {
    name: "SuccessPage",
    components: {AlreadyConfirmed, EmailConfirmed, PasswordChanged},
    setup () {
        const store = useUserStore()
        const router = useRouter()
        const route = useRoute()
        const id = route.params.number
        let checker;
        if(id<1 || id>3)
        {
            checker = false;
        }
        else
        {
            checker = true;
        }
        return {
            id, checker
        }
    }
}
</script>

<style scoped>

</style>
